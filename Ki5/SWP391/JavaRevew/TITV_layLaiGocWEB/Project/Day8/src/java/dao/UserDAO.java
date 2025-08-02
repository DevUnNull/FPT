/*
    + khách hàng 
        đăng ký tài khoản 
        đăng nhập / đăng xuất
        xem sản phẩm 
        tìm kiếm sản phẩm 
        thêm sản phẩm vào giỏ hàng
        các bước thanh toán
        thay dổi thông tin/ đổi mk
        xem lại đơn hàng cũ 
    + Admin
*/

package dao;

import database.DBContext;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/*
| Tên hàm                                        | Mô tả                            |
| ---------------------------------------------- | -------------------------------- |
| `getAllUsers()`                                | Lấy danh sách toàn bộ người dùng |
| `getUserByUsername(String username)`           | Lấy user theo tên đăng nhập      |
| `insertUser(User user)`                        | Đăng ký tài khoản mới            |
| `checkLogin(String username, String password)` | Kiểm tra đăng nhập               |

*/
public class UserDAO extends DBContext {

    private static UserDAO instance;
    public static UserDAO getInstance(){
        if(instance== null){
            instance = new UserDAO();
        }
        return instance;
    }
    
    // Lấy toàn bộ danh sách người dùng
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try (
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                User user = new User(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("email"),
                    rs.getString("full_name")
                );
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    // Tìm user theo username
    public User getUserByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try (
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new User(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("email"),
                    rs.getString("full_name")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Đăng ký tài khoản mới
    public boolean insertUser(User user) {
    String sql = "INSERT INTO users (username, password, email, full_name) VALUES (?, ?, ?, ?)";
    try (
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)
    ) {
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getEmail());
        ps.setString(4, user.getFullName());
        return ps.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();  // 👉 In lỗi cụ thể ra console
    }
        return false;
    }


    // Kiểm tra đăng nhập
    public User checkLogin(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new User(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("email"),
                    rs.getString("full_name")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Test thử
    public static void main(String[] args) {
    UserDAO dao = new UserDAO();

    User user = new User(0, "test99349", "123", "t999@example.com", "Test 999");
    boolean success = dao.insertUser(user);
    System.out.println(">>> Insert result: " + success);
}

}
