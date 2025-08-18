
package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
    private final String HOST = "localhost\\SQLEXPRESS";   // Tên server SQL
    private final String DATABASE_NAME = "LoginPhanQuyen";      // Tên DB
    private final String USER = "sa";
    private final String PASS = "123";

    private final String URL = "jdbc:sqlserver://" + HOST + ":1433;databaseName=" + DATABASE_NAME
                             + ";encrypt=true;trustServerCertificate=true";

    // Luôn trả về Connection mới
    public Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
