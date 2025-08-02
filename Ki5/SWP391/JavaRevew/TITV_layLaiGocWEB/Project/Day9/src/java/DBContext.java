package database;

/*
    những thứ mình cần xác định được khi cấu hình kết nối database
    + link of Database : String url = "jdbc:sqlserver://" + HOST + ":1433;databaseName=" + DATABASE_NAME + ";encrypt=true;trustServerCertificate=true"; // thêm cấu hình SSL tránh lỗi
    + Port : 1433
    + Database name : Project_PRJ301
    + Username : sa
    + Password : 123
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBContext {
    protected Connection connection;

    // ✅ Biến có thể chỉnh tùy theo từng project
    private final String HOST = "localhost\\SQLEXPRESS";         // Có thể đổi sang IP hoặc tên khác
    private final String DATABASE_NAME = "Project_PRJ301";       // Đổi tên database tùy project

    // khởi tạo singleton
    private static DBContext instance;
    public  static DBContext getInstance(){
        if(instance==null){
            instance = new DBContext();
        }
        return instance;
    }
    
    public DBContext() {
        try {
            String user = "sa";
            String pass = "123";
            String url = "jdbc:sqlserver://" + HOST + ":1433;databaseName=" + DATABASE_NAME
                       + ";encrypt=true;trustServerCertificate=true"; // thêm cấu hình SSL tránh lỗi

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Ket Noi Den database '" + DATABASE_NAME + " Thanh Cong!");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Ket Noi That Bai: " + ex.getMessage());
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    public static void main(String[] args) {
        DBContext db = DBContext.getInstance();  // gọi phương thức getInstance()
        if (db.getConnection() != null) {
            System.out.println("Ready to use connection.");
        } else {
            System.out.println("Connection is null.");
        }
    }
}
