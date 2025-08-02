/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.DBContext;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.HocSinh;

/**
 *
 * @author User
 */
public class HocSinhDAO {
    DBContext db = DBContext.getInstance();
    List<HocSinh> hsList = new ArrayList<>();
    public void testConnection() {
        // Bước 1: Tạo kết nối
        Connection conn = db.getConnection();
        if (conn != null) {
            try {
                // Bước 2: Tạo Statement
                Statement stmt = conn.createStatement();
                // Bước 3: Thực thi truy vấn (ví dụ: SELECT từ bảng HocSinh)
                String sql = "SELECT * FROM HocSinh";
                ResultSet rs = stmt.executeQuery(sql);
                
                // Bước 4: Xử lý kết quả
                while (rs.next()) {
                    String ten = rs.getString("Ten");
                    int tuoi = rs.getInt("Tuoi");
                    String lop = rs.getString("Lop");
                    hsList.add(new HocSinh(ten,tuoi,lop));
                    //request.setAttribute("hsList",hsList); ở đây mình lưu list lại để gọi bên jsp vì khi chuyển trang không còn lưu giá trị nữa
                }
                
                // Bước 5: Ngắt kết nối
                db.closeConnection(conn);
            } catch (Exception e) {
                System.out.println("Loi: " + e.getMessage());
            }
        } else {
            System.out.println("Ket noi khong thanh cong.");
        }
    }

    public static void main(String[] args) {
        HocSinhDAO test = new HocSinhDAO();
        test.testConnection();
        for (HocSinh hs : test.hsList) {
            System.out.println("Ten: " + hs.getTen() + ", Tuoi: " + hs.getTuoi() + ", Lop: " + hs.getLop());
        }
    }
}
