package dao;

import database.DBContext;
import model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
| Phương thức                                 | Mô tả                        |
| ------------------------------------------- | ---------------------------- |
| `getAllOrders()`                            | Lấy toàn bộ đơn hàng         |
| `getOrdersByUserId(long userId)`            | Lấy đơn hàng theo người dùng |
| `getOrderById(long id)`                     | Lấy đơn hàng theo ID         |
| `insertOrder(Order order)`                  | Thêm đơn hàng mới            |
| `updateOrderStatus(long id, String status)` | Cập nhật trạng thái đơn hàng |

*/
public class OrderDAO extends DBContext {

    // Lấy tất cả đơn hàng
    public List<Order> getAllOrders() {
        List<Order> list = new ArrayList<>();
        String sql = "SELECT * FROM orders";

        try (
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                Order order = new Order(
                    rs.getInt("id"),
                    rs.getInt("user_id"),
                    rs.getTimestamp("order_date"),
                    rs.getString("status"),
                    rs.getInt("total_amount") // 👉 THÊM
                );
                list.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // Lấy đơn hàng theo ID
    public Order getOrderById(long id) {
        String sql = "SELECT * FROM orders WHERE id = ?";

        try (
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Order(
                    rs.getInt("id"),
                    rs.getInt("user_id"),
                    rs.getTimestamp("order_date"),
                    rs.getString("status"),
                    rs.getInt("total_amount") // 👉 THÊM
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Lấy đơn hàng theo user
    public List<Order> getOrdersByUserId(long userId) {
        List<Order> list = new ArrayList<>();
        String sql = "SELECT * FROM orders WHERE user_id = ?";

        try (
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setLong(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Order order = new Order(
                    rs.getInt("id"),
                    rs.getInt("user_id"),
                    rs.getTimestamp("order_date"),
                    rs.getString("status"),
                    rs.getInt("total_amount") // 👉 THÊM
                );
                list.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // Thêm đơn hàng mới
    public boolean insertOrder(Order order) {
        String sql = "INSERT INTO orders (user_id, order_date, status, total_amount) VALUES (?, ?, ?, ?)";

        try (
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            ps.setLong(1, order.getUserId());
            ps.setTimestamp(2, new Timestamp(order.getOrderDate().getTime()));
            ps.setString(3, order.getStatus());
            ps.setInt(4, order.getTotalAmount()); // 👉 THÊM

            int affectedRows = ps.executeUpdate();

            if (affectedRows > 0) {
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    order.setId(generatedKeys.getInt(1));
                }
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Cập nhật trạng thái đơn hàng
    public boolean updateOrderStatus(long id, String status) {
        String sql = "UPDATE orders SET status = ? WHERE id = ?";

        try (
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, status);
            ps.setLong(2, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Test
    public static void main(String[] args) {
        OrderDAO dao = new OrderDAO();
        List<Order> list = dao.getAllOrders();
        for (Order o : list) {
            System.out.println(o);
        }
    }
}
