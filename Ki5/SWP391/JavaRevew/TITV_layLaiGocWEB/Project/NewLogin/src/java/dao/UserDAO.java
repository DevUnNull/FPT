//RBAC la viet tat cua phan quyen
package dao;

import database.DBContext;
import model.User;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.Role;
import model.ShippingAddress;

public class UserDAO {
    private DBContext dbContext;

    private static UserDAO instance;
    public static UserDAO getInstance(){
        if(instance== null){
            instance = new UserDAO();
        }
        return instance;
    }
    public UserDAO() {
            dbContext = new DBContext();
    }
//    public int registerUserPlain(User u , String reawPassword , ShippingAddress addr ){
//        String sqlUser = "";
//    }
    
    
    
    public List<Role> getRolesByUserId(int userId) {
        List<Role> roles = new ArrayList<>();
        String sql = "SELECT r.role_id, r.role_name FROM roles r "
                   + "JOIN user_roles ur ON r.role_id = ur.role_id "
                   + "WHERE ur.user_id = ?";

        try (Connection conn = dbContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Role role = new Role();
                    role.setRoleId(rs.getInt("role_id"));
                    role.setRoleName(rs.getString("role_name"));
                    roles.add(role);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roles;
    }
    public boolean updateUserRoles(int userId, List<Integer> roleIds) {
        String deleteSql = "DELETE FROM user_roles WHERE user_id = ?";
        String insertSql = "INSERT INTO user_roles (user_id, role_id) VALUES (?, ?)";

        try (Connection conn = dbContext.getConnection()) {
            conn.setAutoCommit(false);

            // Xóa quyền cũ
            try (PreparedStatement ps = conn.prepareStatement(deleteSql)) {
                ps.setInt(1, userId);
                ps.executeUpdate();
            }

            // Thêm quyền mới
            try (PreparedStatement ps = conn.prepareStatement(insertSql)) {
                for (int roleId : roleIds) {
                    ps.setInt(1, userId);
                    ps.setInt(2, roleId);
                    ps.addBatch();
                }
                ps.executeBatch();
            }

            conn.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



    // Lấy User theo username & password (plain text)
    public User getUserByLogin(String username, String password) {
        User user = null;
        String sql = "SELECT * FROM users WHERE username = ? AND password_hash = ? AND status = 1";

        try (Connection conn = dbContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    user = new User();
                    user.setUserId(rs.getInt("user_id"));
                    user.setUsername(rs.getString("username"));
                    user.setPasswordHash(rs.getString("password_hash"));
                    user.setFullName(rs.getString("full_name"));
                    user.setEmail(rs.getString("email"));
                    user.setStatus(rs.getInt("status"));

                    Timestamp created = rs.getTimestamp("created_at");
                    Timestamp updated = rs.getTimestamp("updated_at");

                    if (created != null) {
                        user.setCreatedAt(created.toLocalDateTime());
                    }
                    if (updated != null) {
                        user.setUpdatedAt(updated.toLocalDateTime());
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
    
    public static void main(String[] args) {
    UserDAO dao = UserDAO.getInstance();

    // 1. Test đăng nhập
    String testUsername = "admin";
    String testPassword = "hashed_password_admin"; // plain text trong DB

    User user = dao.getUserByLogin(testUsername, testPassword);

    if (user != null) {
        System.out.println("===== LOGIN SUCCESS =====");
        System.out.println("ID       : " + user.getUserId());
        System.out.println("Username : " + user.getUsername());
        System.out.println("Full Name: " + user.getFullName());
        System.out.println("Email    : " + user.getEmail());
        System.out.println("Status   : " + (user.getStatus() == 1 ? "Active" : "Inactive"));
        System.out.println("Created  : " + user.getCreatedAt());
        System.out.println("Updated  : " + user.getUpdatedAt());

        // 2. Lấy quyền hiện tại
        System.out.println("Quyền hiện tại:");
        List<Role> roles = dao.getRolesByUserId(user.getUserId());
        for (Role r : roles) {
            System.out.println(" - " + r.getRoleName());
        }

        // 3. Cập nhật quyền (ví dụ gán role_id = 1 và role_id = 2)
        List<Integer> newRoles = new ArrayList<>();
        newRoles.add(1); // ADMIN
        newRoles.add(2); // USER

        boolean updated = dao.updateUserRoles(user.getUserId(), newRoles);
        System.out.println(updated ? "Cập nhật quyền thành công" : "Cập nhật quyền thất bại");

        // 4. Kiểm tra lại quyền sau khi cập nhật
        System.out.println("Quyền sau khi cập nhật:");
        List<Role> updatedRoles = dao.getRolesByUserId(user.getUserId());
        for (Role r : updatedRoles) {
            System.out.println(" - " + r.getRoleName());
        }

    } else {
        System.out.println("===== LOGIN FAILED =====");
        System.out.println("Sai username hoặc password, hoặc tài khoản bị khóa!");
    }
}


}
