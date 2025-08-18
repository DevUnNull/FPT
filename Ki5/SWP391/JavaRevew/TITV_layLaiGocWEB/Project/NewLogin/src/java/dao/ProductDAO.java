package dao;

import database.DBContext;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Category;

public class ProductDAO extends DBContext {

    private static ProductDAO instance ;
    public static ProductDAO getInstance(){
        if(instance == null){
            instance = new ProductDAO();
        }
        return instance;
    }
    
    public int DeleteProductById(int productId) throws Exception {
        String sqlDelImage    = "DELETE FROM product_images WHERE product_id = ?";
        String sqlDelCategory = "DELETE FROM product_categories WHERE product_id = ?";
        String sqlDelProduct  = "DELETE FROM products WHERE product_id = ?";

        try (Connection con = getConnection()) {
            con.setAutoCommit(false);
            try (PreparedStatement ps1 = con.prepareStatement(sqlDelImage);
                 PreparedStatement ps2 = con.prepareStatement(sqlDelCategory);
                 PreparedStatement ps3 = con.prepareStatement(sqlDelProduct)) {

                // xóa ảnh
                ps1.setInt(1, productId);
                ps1.executeUpdate();

                // xóa mapping category
                ps2.setInt(1, productId);   // <-- sửa về 1
                ps2.executeUpdate();

                // xóa product (trả về số dòng xóa được)
                ps3.setInt(1, productId);   // <-- sửa về 1
                int affected = ps3.executeUpdate();

                con.commit();
                return affected;            // >0 nếu xóa thành công
            } catch (Exception ex) {
                con.rollback();
                throw ex;
            } finally {
                con.setAutoCommit(true);
            }
        }
    }

    // dao/ProductDAO.java

    public int addProductWithCategory(Product p, String categoryName) throws Exception {
        String sqlInsertCatIfNotExists =
            "INSERT INTO categories (category_name) " +
            "SELECT ? WHERE NOT EXISTS (SELECT 1 FROM categories WHERE category_name = ?)";
        String sqlGetCatId = "SELECT category_id FROM categories WHERE category_name = ?";
        String sqlInsertProduct =
            "INSERT INTO products (name, description, price, stock_quantity, image_url, created_at) " +
            "VALUES (?, ?, ?, ?, ?, GETDATE())"; // <-- MySQL
        String sqlMap = "INSERT INTO product_categories (product_id, category_id) VALUES (?, ?)";

        try (Connection con = getConnection()) {
            con.setAutoCommit(false);
            try (PreparedStatement insCat = con.prepareStatement(sqlInsertCatIfNotExists);
                 PreparedStatement getCat = con.prepareStatement(sqlGetCatId);
                 PreparedStatement insProd = con.prepareStatement(sqlInsertProduct, Statement.RETURN_GENERATED_KEYS);
                 PreparedStatement map = con.prepareStatement(sqlMap)) {

                // 1) Tạo category nếu chưa có
                insCat.setString(1, categoryName);
                insCat.setString(2, categoryName);
                insCat.executeUpdate();

                // 2) Lấy category_id
                int categoryId;
                getCat.setString(1, categoryName);
                try (ResultSet rs = getCat.executeQuery()) {
                    if (!rs.next()) throw new SQLException("Không lấy được category_id");
                    categoryId = rs.getInt(1);
                }

                // 3) Thêm product
                insProd.setString(1, p.getName());
                insProd.setString(2, p.getDescription());
                insProd.setBigDecimal(3, p.getPrice());
                insProd.setInt(4, p.getStockQuantity());
                insProd.setString(5, p.getImageUrl());
                insProd.executeUpdate();

                int productId;
                try (ResultSet rs = insProd.getGeneratedKeys()) {
                    if (!rs.next()) throw new SQLException("Không lấy được product_id");
                    productId = rs.getInt(1); // MySQL -> LAST_INSERT_ID()
                }

                // 4) Ánh xạ
                map.setInt(1, productId);
                map.setInt(2, categoryId);
                map.executeUpdate();

                con.commit();
                return productId;
            } catch (Exception ex) {
                con.rollback();
                throw ex;
            } finally {
                con.setAutoCommit(true);
            }
        }
    }
    
    public int addProductWithCategoryNew(Product p, String categoryName) throws Exception {
    // 1) Đảm bảo category tồn tại (upsert an toàn cho SQL Server)
    final String sqlEnsureCategory =
        "MERGE INTO categories WITH (HOLDLOCK) AS T " +
        "USING (VALUES (?)) AS S(category_name) " +
        "ON T.category_name = S.category_name " +
        "WHEN NOT MATCHED THEN INSERT (category_name) VALUES (S.category_name);";

    // 2) Lấy category_id
    final String sqlGetCatId =
        "SELECT category_id FROM categories WHERE category_name = ?;";

    // 3) Thêm product (SQL Server)
    final String sqlInsertProduct =
        "INSERT INTO products (name, description, price, stock_quantity, image_url, created_at) " +
        "VALUES (?, ?, ?, ?, ?, GETDATE());";

    // 4) Ánh xạ product-category
    final String sqlMap =
        "INSERT INTO product_categories (product_id, category_id) VALUES (?, ?);";

    try (Connection con = getConnection()) {
        con.setAutoCommit(false);
        try (PreparedStatement ensureCat = con.prepareStatement(sqlEnsureCategory);
             PreparedStatement getCatId = con.prepareStatement(sqlGetCatId);
             PreparedStatement insProd = con.prepareStatement(sqlInsertProduct, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement map = con.prepareStatement(sqlMap)) {

            // 1) Đảm bảo category tồn tại
            ensureCat.setNString(1, categoryName);
            ensureCat.executeUpdate();

            // 2) Lấy category_id
            int categoryId;
            getCatId.setNString(1, categoryName);
            try (ResultSet rs = getCatId.executeQuery()) {
                if (!rs.next()) throw new SQLException("Không lấy được category_id");
                categoryId = rs.getInt(1);
            }

            // 3) Thêm product
            insProd.setNString(1, p.getName());          // NVARCHAR
            insProd.setNString(2, p.getDescription());   // NVARCHAR(MAX)
            insProd.setBigDecimal(3, p.getPrice());      // DECIMAL(18,2)
            insProd.setInt(4, p.getStockQuantity());     // INT
            insProd.setNString(5, p.getImageUrl());      // NVARCHAR(255)
            insProd.executeUpdate();

            int productId;
            try (ResultSet rs = insProd.getGeneratedKeys()) {
                if (!rs.next()) throw new SQLException("Không lấy được product_id");
                productId = rs.getInt(1); // SQL Server: IDENTITY
            }

            // 4) Ánh xạ product - category
            map.setInt(1, productId);
            map.setInt(2, categoryId);
            map.executeUpdate();

            con.commit();
            return productId;

        } catch (Exception ex) {
            con.rollback();
            throw ex;
        } finally {
            con.setAutoCommit(true);
        }
    }
}


    
    public void addCategory(Category category) {
        String sql = "INSERT INTO categories (category_name, description) VALUES (?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, category.getCategoryName());
            ps.setString(2, category.getDescription());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public List<Category> getAllCategories() {
        List<Category> list = new ArrayList<>();
        String sql = "SELECT category_id, category_name, description FROM categories";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Category c = new Category();
                c.setCategoryId(rs.getInt("category_id"));
                c.setCategoryName(rs.getString("category_name"));
                c.setDescription(rs.getString("description"));
                list.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // Lấy 1 sản phẩm theo id (kèm category)
    public Product getProductById(int id) {
        String sql = "SELECT p.*, pc.category_id, c.category_name\n" +
"            FROM products p\n" +
"            LEFT JOIN product_categories pc ON p.product_id = pc.product_id\n" +
"            LEFT JOIN categories c ON pc.category_id = c.category_id\n" +
"            WHERE p.product_id = ?";
            
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Product p = new Product();
                    p.setProductId(rs.getInt("product_id"));
                    p.setName(rs.getString("name"));
                    p.setDescription(rs.getString("description"));
                    p.setPrice(rs.getBigDecimal("price"));
                    p.setStockQuantity(rs.getInt("stock_quantity"));
                    p.setImageUrl(rs.getString("image_url"));
                    Timestamp cAt = rs.getTimestamp("created_at");
                    if (cAt != null) p.setCreatedAt(cAt.toLocalDateTime());
                    Timestamp uAt = rs.getTimestamp("updated_at");
                    if (uAt != null) p.setUpdatedAt(uAt.toLocalDateTime());

                    p.setCategoryId((Integer) rs.getObject("category_id"));
                    p.setCategoryName(rs.getString("category_name"));
                    return p;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Cập nhật product + thay đổi danh mục (transaction)
    public int updateProductWithCategory(Product product) throws Exception {
        String sqlUpdate = "UPDATE products\n" +
"            SET name=?, description=?, price=?, stock_quantity=?, image_url=?, updated_at=GETDATE()\n" +
"            WHERE product_id=?";
        String sqlDelMap = "DELETE FROM product_categories WHERE product_id=?";
        String sqlInsMap = "INSERT INTO product_categories (product_id, category_id) VALUES (?, ?)";

        try (Connection con = getConnection()) {
            con.setAutoCommit(false);
            try (PreparedStatement up = con.prepareStatement(sqlUpdate)) {
                up.setString(1, product.getName());
                up.setString(2, product.getDescription());
                up.setBigDecimal(3, product.getPrice());
                up.setInt(4, product.getStockQuantity());
                up.setString(5, product.getImageUrl());
                up.setInt(6, product.getProductId());
                int affected = up.executeUpdate();

                // làm sạch mapping cũ rồi chèn mapping mới
                try (PreparedStatement d = con.prepareStatement(sqlDelMap)) {
                    d.setInt(1, product.getProductId());
                    d.executeUpdate();
                }
                if (product.getCategoryId() != null) {
                    try (PreparedStatement i = con.prepareStatement(sqlInsMap)) {
                        i.setInt(1, product.getProductId());
                        i.setInt(2, product.getCategoryId());
                        i.executeUpdate();
                    }
                }
                con.commit();
                return affected;
            } catch (Exception ex) {
                con.rollback();
                throw ex;
            } finally {
                con.setAutoCommit(true);
            }
        }
    }


    // Thêm product + gán category (đã có trong code của bạn, bổ sung mẹo SQL Server)
    public int addProduct(Product product) throws Exception {
        String sqlProduct  = "INSERT INTO products (name, description, price, stock_quantity, image_url, created_at) " +
                             "VALUES (?, ?, ?, ?, ?, GETDATE())";
        String sqlMapCat   = "INSERT INTO product_categories (product_id, category_id) VALUES (?, ?)";

        try (Connection con = getConnection()) {

            // 1) Với SQL Server, đôi khi cần chỉ ra tên cột khóa:
            // PreparedStatement ps = con.prepareStatement(sqlProduct, new String[]{"product_id"});
            // Nếu driver của bạn hỗ trợ RETURN_GENERATED_KEYS thì giữ nguyên như bạn:
            PreparedStatement ps = con.prepareStatement(sqlProduct, Statement.RETURN_GENERATED_KEYS);

            con.setAutoCommit(false);
            try {
                ps.setString(1, product.getName());
                ps.setString(2, product.getDescription());
                ps.setBigDecimal(3, product.getPrice());
                ps.setInt(4, product.getStockQuantity());
                ps.setString(5, product.getImageUrl());
                ps.executeUpdate();

                int newId;
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (!rs.next()) throw new SQLException("Không lấy được product_id mới");
                    newId = rs.getInt(1);
                }
                ps.close();

                if (product.getCategoryId() != null) {
                    try (PreparedStatement ps2 = con.prepareStatement(sqlMapCat)) {
                        ps2.setInt(1, newId);
                        ps2.setInt(2, product.getCategoryId());
                        ps2.executeUpdate();
                    }
                }

                con.commit();
                return newId;
            } catch (Exception e) {
                con.rollback();
                throw e;
            } finally {
                con.setAutoCommit(true);
            }
        }
    }


    public void updateProduct(Product product) {
        String sql = "UPDATE products SET name = ?, description = ?, price = ?, stock_quantity = ?, image_url = ?, updated_at = GETDATE() " +
                     "WHERE product_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            ps.setBigDecimal(3, product.getPrice());
            ps.setInt(4, product.getStockQuantity());
            ps.setString(5, product.getImageUrl());
            ps.setInt(6, product.getProductId());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

public List<Product> getAllProducts() {
    List<Product> list = new ArrayList<>();
    String sql = "        SELECT p.*, c.category_name\n" +
"        FROM products p\n" +
"        LEFT JOIN product_categories pc ON p.product_id = pc.product_id\n" +
"        LEFT JOIN categories c ON pc.category_id = c.category_id";



    try (Connection conn = getConnection();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            Product p = new Product();
            p.setProductId(rs.getInt("product_id"));
            p.setName(rs.getString("name"));
            p.setDescription(rs.getString("description"));
            p.setPrice(rs.getBigDecimal("price"));
            p.setStockQuantity(rs.getInt("stock_quantity"));
            p.setImageUrl(rs.getString("image_url"));
            p.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());

            Timestamp updated = rs.getTimestamp("updated_at");
            if (updated != null) {
                p.setUpdatedAt(updated.toLocalDateTime());
            }

            p.setCategoryName(rs.getString("category_name")); // bạn cần thêm trường này trong Product model

            list.add(p);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return list;
}

}
