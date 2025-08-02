/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import database.DBContext;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import model.Sach;
import java.sql.ResultSet;

/**
 *
 * @author User
 */
public class SachDAO implements DAOInterface<Sach>{

    private static SachDAO instance ;
    public static SachDAO getInstance(){
        if(instance == null){
            instance = new SachDAO();
        }
        return instance;
    }
    DBContext db = DBContext.getInstance();
    
    @Override
    public int insert(Sach t) {
        Connection conn = null;
        PreparedStatement ps = null;
        int result = 0;

        try {
            // Bước 1: Kết nối CSDL
            conn = db.getConnection();
            if (conn != null) {
                // Bước 2: Tạo đối tượng PreparedStatement
                String sql = "INSERT INTO Sach (id, tenSach, giaBan, namXuatBan) VALUES (?, ?, ?, ?)";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, t.getId());
                ps.setString(2, t.getTenSach());
                ps.setDouble(3, t.getGiaBan());
                ps.setInt(4, t.getNamXuatBan());

                // Bước 3: Thực thi câu lệnh SQL
                result = ps.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Lỗi insert: " + e.getMessage());
        } finally {
            // Đóng tài nguyên
            if (ps != null) {
                try { ps.close(); } catch (SQLException e) {}
            }
            if (conn != null) {
                //db.closeConnection(conn);
            }
        }
        return result; // Trả về số hàng bị ảnh hưởng
    }

    @Override
    public int Update(Sach t) {
        Connection conn = null;
        PreparedStatement ps = null;
        int result = 0;

        try {
            // Bước 1: Kết nối CSDL
            conn = db.getConnection();
            if (conn != null) {
                // Bước 2: Tạo đối tượng PreparedStatement
                String sql = "UPDATE Sach SET tenSach = ?, giaBan = ?, namXuatBan = ? WHERE id = ?";
                ps = conn.prepareStatement(sql);
                
                ps.setString(1, t.getTenSach());
                ps.setDouble(2, t.getGiaBan());
                ps.setInt(3, t.getNamXuatBan());
                ps.setInt(4, t.getId());
                // Bước 3: Thực thi câu lệnh SQL
                result = ps.executeUpdate();
                System.err.println("Update thanh cong sach co ID: "+t.getId());
            }
        } catch (SQLException e) {
            System.out.println("Lỗi update: " + e.getMessage());
        } finally {
            // Đóng tài nguyên
            if (ps != null) {
                try { ps.close(); } catch (SQLException e) {}
            }
            if (conn != null) {
                //db.closeConnection(conn);
            }
        }
        
        return result; // Trả về số hàng bị ảnh hưởng
    }

    @Override
    public int Delete(Sach t) {
        Connection conn = null;
        PreparedStatement ps = null;
        int result = 0;

        try {
            // Bước 1: Kết nối CSDL
            conn = db.getConnection();
            if (conn != null) {
                // Bước 2: Tạo đối tượng PreparedStatement
                String sql = "DELETE FROM Sach WHERE id = ?";
                ps = conn.prepareStatement(sql);
                
                ps.setInt(1, t.getId());
                // Bước 3: Thực thi câu lệnh SQL
                result = ps.executeUpdate();
                System.err.println("Delete thanh cong sach co ID: "+t.getId());
            }
        } catch (SQLException e) {
            System.out.println("Lỗi Delete: " + e.getMessage());
        } finally {
            // Đóng tài nguyên
            if (ps != null) {
                try { ps.close(); } catch (SQLException e) {}
            }
            if (conn != null) {
                //db.closeConnection(conn);
            }
        }
        
        return result; // Trả về số hàng bị ảnh hưởng
    }

    @Override
    public ArrayList<Sach> selectAll() {
        ArrayList<Sach> dsSach = new ArrayList<>(); // 1. Khởi tạo danh sách kết quả
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = db.getConnection(); // 2. Mở kết nối đến CSDL

            if (conn != null) {
                String sql = "SELECT * FROM Sach"; // 3. Câu lệnh SQL
                ps = conn.prepareStatement(sql);   // 4. Chuẩn bị thực thi SQL
                rs = ps.executeQuery();            // 5. Thực thi câu SQL => trả về ResultSet

                while (rs.next()) { // 6. Lặp qua từng dòng kết quả
                    int id = rs.getInt("id");
                    String tenSach = rs.getString("tenSach");
                    double giaBan = rs.getDouble("giaBan");
                    int namXuatBan = rs.getInt("namXuatBan");

                    // 7. Tạo đối tượng Sach từ dữ liệu
                    Sach sach = new Sach(id, tenSach, giaBan, namXuatBan);

                    // 8. Thêm vào danh sách
                    dsSach.add(sach);
                }
            }
        } catch (SQLException e) {
            System.out.println("Lỗi selectAll: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // 9. Đóng tài nguyên (ResultSet, PreparedStatement, Connection)
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (conn != null) {
                db.closeConnection(conn); // nếu bạn có hàm closeConnection trong DBContext
            }
        }

        return dsSach; // 10. Trả về danh sách kết quả
    }



    @Override
    public Sach selectById(int t) {
        Sach findSach = null; // 1. Khởi tạo danh sách kết quả
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = db.getConnection(); // 2. Mở kết nối đến CSDL

            if (conn != null) {
                String sql = "SELECT * FROM Sach Where id = ?"; // 3. Câu lệnh SQL
                ps = conn.prepareStatement(sql);   // 4. Chuẩn bị thực thi SQL
                ps.setInt(1, t);
                rs = ps.executeQuery();            // 5. Thực thi câu SQL => trả về ResultSet

                if (rs.next()) { // 6. Lặp qua từng dòng kết quả
                    int id = rs.getInt("id");
                    String tenSach = rs.getString("tenSach");
                    double giaBan = rs.getDouble("giaBan");
                    int namXuatBan = rs.getInt("namXuatBan");

                    // 7. Tạo đối tượng Sach từ dữ liệu
                    findSach = new Sach(id, tenSach, giaBan, namXuatBan);
                }else{
                    System.err.println("khong tim thay sach");
                }
            }
        } catch (SQLException e) {
            System.out.println("Lỗi selectById: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // 9. Đóng tài nguyên (ResultSet, PreparedStatement, Connection)
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (conn != null) {
                db.closeConnection(conn); // nếu bạn có hàm closeConnection trong DBContext
            }
        }

        return findSach; // 10. Trả về danh sách kết quả
    }

    public ArrayList<Sach> selectByCondition(String condition) {
        ArrayList<Sach> dsSach = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        // Các trường hợp điều kiện hợp lệ
        String[] validConditions = {"ID", "TenSach", "GiaBan"};

        // Kiểm tra điều kiện hợp lệ
        if (condition == null || condition.trim().isEmpty()) {
            throw new IllegalArgumentException("Điều kiện không thể rỗng!");
        }

        // Tạo câu truy vấn SQL cơ bản
        String sql = "SELECT * FROM Sach";

        try {
            conn = db.getConnection();

            // Kiểm tra nếu điều kiện có chứa các ký tự nguy hiểm
            if (containsDangerousCharacters(condition)) {
                throw new SQLException("Điều kiện không hợp lệ, có chứa ký tự nguy hiểm!");
            }

            // Kiểm tra điều kiện người dùng nhập vào
            boolean isValid = false;
            for (String validCondition : validConditions) {
                if (condition.toLowerCase().contains(validCondition.toLowerCase())) {
                    isValid = true;
                    break;
                }
            }

            if (!isValid) {
                throw new SQLException("Điều kiện không hợp lệ!");
            }

            // Nếu điều kiện hợp lệ, xây dựng câu truy vấn với WHERE
            sql += " WHERE " + condition;

            System.out.println("🧪 SQL đang chạy: " + sql);

            // Sử dụng PreparedStatement
            ps = conn.prepareStatement(sql);

            // Thực thi câu truy vấn
            rs = ps.executeQuery();

            // Đọc kết quả và thêm vào danh sách
            while (rs.next()) {
                int id = rs.getInt("ID");
                String tenSach = rs.getString("TenSach");
                double giaBan = rs.getDouble("GiaBan");
                int namXuatBan = rs.getInt("NamXuatBan");

                Sach sach = new Sach(id, tenSach, giaBan, namXuatBan);
                dsSach.add(sach);
            }
        } catch (SQLException e) {
            System.out.println("Lỗi SelectByCondition: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) db.closeConnection(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return dsSach;
    }

    // Hàm kiểm tra ký tự nguy hiểm (SQL Injection)
    private boolean containsDangerousCharacters(String condition) {
        // Danh sách các từ khóa nguy hiểm có thể dùng trong SQL Injection
        String[] dangerousKeywords = {"--", ";", "/*", "*/", "drop", "delete", "insert", "update", "or", "select", "union"};

        for (String keyword : dangerousKeywords) {
            if (condition.toLowerCase().contains(keyword)) {
                return true;
            }
        }
        return false;
    }





}
