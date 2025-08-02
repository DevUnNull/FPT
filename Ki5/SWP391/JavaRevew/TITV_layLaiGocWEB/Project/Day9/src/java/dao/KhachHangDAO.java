/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import database.DBContext;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.KhachHang;

/**
 *
 * @author User
 */
public class KhachHangDAO implements DAOInterface<KhachHang>{

    private static KhachHangDAO instance;
    public static KhachHangDAO getInstance(){
        if(instance== null){
            instance = new KhachHangDAO();
        }
        return instance;
    }
    DBContext db = DBContext.getInstance();
    @Override
    public int insert(KhachHang t) {
        Connection conn = null; 
        PreparedStatement ps = null;
        int result = 0;
        
        try {
            conn = db.getConnection();
            if(conn!=null){
                String sql = "insert into KhachHang (id,HoVaTen,NgaySinh,DiaChi) values (?,?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, t.getId());
                ps.setString(2, t.getHoVaTen());
                ps.setDate(3, (Date) t.getNgaySinh());
                ps.setString(4, t.getDiaChi());
                
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
        return result;
    }

    @Override
    public int Update(KhachHang t) {
        Connection conn = null; 
        PreparedStatement ps = null;
        int result = 0;
        
        try {
            conn = db.getConnection();
            if(conn!=null){
                String sql = "update KhachHang set HoVaTen = ? , NgaySinh = ? , DiaChi = ? where ID = ?";
                ps = conn.prepareStatement(sql);
                
                ps.setString(1, t.getHoVaTen());
                ps.setDate(2, (Date) t.getNgaySinh());
                ps.setString(3, t.getDiaChi());
                ps.setInt(4, t.getId());
                result = ps.executeUpdate();
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
        return result;
    }

    @Override
    public int Delete(KhachHang t) {
        Connection conn = null; 
        PreparedStatement ps = null;
        int result = 0;
        
        try {
            conn = db.getConnection();
            if(conn!=null){
                String sql = "DELETE FROM KhachHang WHERE id = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, t.getId());
                result = ps.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Lỗi delete: " + e.getMessage());
        } finally {
            // Đóng tài nguyên
            if (ps != null) {
                try { ps.close(); } catch (SQLException e) {}
            }
            if (conn != null) {
                //db.closeConnection(conn);
            }
        }
        return result;
    }

    @Override
    public ArrayList<KhachHang> selectAll() {
        ArrayList<KhachHang> khachHangList = new ArrayList<>();
        Connection conn = null; 
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConnection();
            if(conn!=null){
                String sql = "Select * from KhachHang";
                ps = conn.prepareStatement(sql);
                rs  = ps.executeQuery();
                while (rs.next()) {                    
                    int id = rs.getInt("ID");
                    String HoVaTen = rs.getString("HoVaTen");
                    Date NgaySinh = rs.getDate("NgaySinh");
                    String DiaChi = rs.getString("DiaChi");
                    
                    KhachHang khachHang = new KhachHang(id, HoVaTen, NgaySinh, DiaChi);
                    khachHangList.add(khachHang);
                }
            }
        } catch (SQLException e) {
            System.out.println("Lỗi SelectAll: " + e.getMessage());
        } finally {
            // Đóng tài nguyên
            if (ps != null) {
                try { ps.close(); } catch (SQLException e) {}
            }
            if (conn != null) {
                //db.closeConnection(conn);
            }
        }
        return khachHangList;
    }

    @Override
    public KhachHang selectById(int t) {
        KhachHang khachHang = null;
        Connection conn = null; 
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConnection();
            if(conn!=null){
                String sql = "Select * from KhachHang where ID = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, t);
                rs  = ps.executeQuery();
                while (rs.next()) {                    
                    int id = rs.getInt("ID");
                    String HoVaTen = rs.getString("HoVaTen");
                    Date NgaySinh = rs.getDate("NgaySinh");
                    String DiaChi = rs.getString("DiaChi");
                    
                    khachHang = new KhachHang(id, HoVaTen, NgaySinh, DiaChi);
                }
            }
        } catch (SQLException e) {
            System.out.println("Lỗi SelectByID: " + e.getMessage());
        } finally {
            // Đóng tài nguyên
            if (ps != null) {
                try { ps.close(); } catch (SQLException e) {}
            }
            if (conn != null) {
                //db.closeConnection(conn);
            }
        }
        return khachHang;
    }

    @Override
    public ArrayList<KhachHang> selectByCondition(String condition) {
        ArrayList<KhachHang> khachHangList = new ArrayList<>();
        Connection conn = null; 
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConnection();
            if(conn!=null){
                String sql = "Select * from KhachHang Where "+condition;
                ps = conn.prepareStatement(sql);
                rs  = ps.executeQuery();
                while (rs.next()) {                    
                    int id = rs.getInt("ID");
                    String HoVaTen = rs.getString("HoVaTen");
                    Date NgaySinh = rs.getDate("NgaySinh");
                    String DiaChi = rs.getString("DiaChi");
                    
                    KhachHang khachHang = new KhachHang(id, HoVaTen, NgaySinh, DiaChi);
                    khachHangList.add(khachHang);
                }
            }
        } catch (SQLException e) {
            System.out.println("Lỗi SelectByCOndition: " + e.getMessage());
        } finally {
            // Đóng tài nguyên
            if (ps != null) {
                try { ps.close(); } catch (SQLException e) {}
            }
            if (conn != null) {
                //db.closeConnection(conn);
            }
        }
        return khachHangList;
    }
    
}
