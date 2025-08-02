package dao;

import database.DBContext;
import model.Admin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
| Tên hàm                   | Mô tả                                   |
| ------------------------- | --------------------------------------- |
| `getAllAdmins()`          | Lấy toàn bộ danh sách admin             |
| `isAdmin(int userId)`     | Kiểm tra 1 `userId` có phải admin không |
| `addAdmin(int userId)`    | Thêm 1 user làm admin                   |
| `removeAdmin(int userId)` | Gỡ quyền admin                          |

*/

public class AdminDAO extends DBContext {

    // Lấy danh sách tất cả admin
    public List<Admin> getAllAdmins() {
        List<Admin> list = new ArrayList<>();
        String sql = "SELECT * FROM admins";

        try (
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                Admin admin = new Admin(
                    rs.getInt("id"),
                    rs.getInt("user_id")
                );
                list.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // Kiểm tra user có phải admin không
    public boolean isAdmin(int userId) {
        String sql = "SELECT * FROM admins WHERE user_id = ?";
        try (
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            return rs.next(); // Nếu có dòng thì là admin
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Thêm 1 user làm admin
    public boolean addAdmin(int userId) {
        String sql = "INSERT INTO admins (user_id) VALUES (?)";
        try (
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, userId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Gỡ quyền admin
    public boolean removeAdmin(int userId) {
        String sql = "DELETE FROM admins WHERE user_id = ?";
        try (
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, userId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Test thử
    public static void main(String[] args) {
        AdminDAO dao = new AdminDAO();
        System.out.println("Is userId 1 admin? " + dao.isAdmin(1));
        System.out.println("All admins:");
        for (Admin a : dao.getAllAdmins()) {
            System.out.println(a);
        }
    }
}
