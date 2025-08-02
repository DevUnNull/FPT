
import dao.SachDAO;
import dao.KhachHangDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.KhachHang;
import model.Sach;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class test {
    public static void main(String[] args) throws ParseException {    
//        // test insert
//      for (int i = 5; i < 10; i++) {
//          Sach sach2 = new Sach(i,"lapTRinh"+i,2000*i,2023);
//          SachDAO.getInstance().insert(sach2);
//      }

//        //test update 
//      Sach sach2 = new Sach(2,"lapTRinh",5454545,2023); 
//      SachDAO.getInstance().Update(sach2);

//        //test delete
//        Sach sach2 = new Sach(2,"lapTRinh",5454545,2023);
//        SachDAO.getInstance().Delete(sach2);


//        // test SelectAll
//        ArrayList<Sach> danhSach = SachDAO.getInstance().selectAll();
//        for (Sach sach : danhSach) {
//            System.out.println("ID: " + sach.getId()
//                               + " | Tên: " + sach.getTenSach()
//                               + " | Giá: " + sach.getGiaBan()
//                               + " | Năm XB: " + sach.getNamXuatBan());
//        }

//        // test SelectById
//        Sach findSach = SachDAO.getInstance().selectById(3);
//        if(findSach!=null){
//            System.err.println("ID | TenSach | GiaBan | NamXuatBan");
//            System.err.println(findSach.getId() +" | "+ findSach.getTenSach()+" | "+findSach.getGiaBan()+" | "+findSach.getNamXuatBan());
//        }

        // test SelectByCondition
        ArrayList<Sach> ds = SachDAO.getInstance().selectByCondition("ID = 4 ");

        for (Sach s : ds) {
            System.out.println("ID: " + s.getId()
                + " | Tên: " + s.getTenSach()
                + " | Giá: " + s.getGiaBan()
                + " | Năm XB: " + s.getNamXuatBan());
        }
//--------------------------------------------------------------------------
//        // test insert
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        java.util.Date utilDate = sdf.parse("23/03/2003");
//        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
//        for (int i = 5; i < 10; i++) {
//            KhachHang khachHang = new KhachHang(i,"NgocHai "+i,sqlDate, "HungYen");
//            KhachHangDAO.getInstance().insert(khachHang);
//        }

//        // test update khachhang
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        java.util.Date utilDate = sdf.parse("23/03/2003");
//        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
//        KhachHang khachHang = new KhachHang(1, "khach hang", sqlDate, "dia chi");
//        KhachHangDAO.getInstance().Update(khachHang);
        
//        // test delete khach hang
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        java.util.Date utilDate = sdf.parse("23/03/2003");
//        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
//        KhachHang khachHang = new KhachHang(1, "khach hang", sqlDate, "dia chi");
//        KhachHangDAO.getInstance().Delete(khachHang);

         // test SelectAll
//        ArrayList<KhachHang> danhSach = KhachHangDAO.getInstance().selectAll();
//        for (KhachHang khachHang : danhSach) {
//            System.out.println("ID: " + khachHang.getId()
//                               + " | HoVaTen : " + khachHang.getHoVaTen()
//                               + " | NgaySinh: " + khachHang.getNgaySinh()
//                               + " | DiaChi: " + khachHang.getDiaChi());
//        }

//       // test SelectById
//        KhachHang khachHang = KhachHangDAO.getInstance().selectById(2);
//        if(khachHang!=null){
//            System.err.println("ID | HoVaTen | NgaySinh | DiaChi");
//            System.err.println(khachHang.getId() +" | "+ khachHang.getHoVaTen()+" | "+khachHang.getNgaySinh()+" | "+khachHang.getDiaChi());
//        }else{
//            System.err.println("khong tim duoc ");
//        }
        
//        // test SelectByCondition
//        ArrayList<KhachHang> kh = KhachHangDAO.getInstance().selectByCondition("ID = 4");
//        if(kh != null && !kh.isEmpty()){
//            for (KhachHang s : kh) {
//                System.out.println("ID: " + s.getId()
//                    + " | Tên: " + s.getHoVaTen()
//                    + " | NgaySinh: " + s.getNgaySinh()
//                    + " | DiaChi: " + s.getDiaChi());
//            }
//        }else{
//            System.err.println("khong tim duoc theo condition");
//        }
    }
}
