package dao;

import database.DBContext;
import model.OrderItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
| Phương thức                            | Mô tả                                     |
| -------------------------------------- | ----------------------------------------- |
| `getItemsByOrderId(long orderId)`      | Lấy danh sách sản phẩm trong một đơn hàng |
| `insertOrderItem(OrderItem item)`      | Thêm một dòng vào `order_items`           |
| `insertMultipleItems(List<OrderItem>)` | Thêm nhiều sản phẩm cùng lúc              |

*/

public class OrderItemDAO extends DBContext {

    // Lấy các sản phẩm theo order_id
    public List<OrderItem> getItemsByOrderId(long orderId) {
        List<OrderItem> list = new ArrayList<>();
        String sql = "SELECT * FROM order_items WHERE order_id = ?";

        try (
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setLong(1, orderId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                OrderItem item = new OrderItem(
                    rs.getLong("id"),
                    rs.getLong("order_id"),
                    rs.getLong("product_id"),
                    rs.getInt("quantity"),
                    rs.getDouble("unit_price")
                );
                list.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // Thêm một dòng order item
    public boolean insertOrderItem(OrderItem item) {
        String sql = "INSERT INTO order_items (order_id, product_id, quantity, unit_price) VALUES (?, ?, ?, ?)";

        try (
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setLong(1, item.getOrderId());
            ps.setLong(2, item.getProductId());
            ps.setInt(3, item.getQuantity());
            ps.setDouble(4, item.getUnitPrice());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Thêm nhiều dòng order item
    public boolean insertMultipleItems(List<OrderItem> items) {
        boolean allInserted = true;

        for (OrderItem item : items) {
            if (!insertOrderItem(item)) {
                allInserted = false;
            }
        }

        return allInserted;
    }

    // Test
    public static void main(String[] args) {
        OrderItemDAO dao = new OrderItemDAO();
        List<OrderItem> list = dao.getItemsByOrderId(1);
        for (OrderItem item : list) {
            System.out.println(item);
        }
    }
}
