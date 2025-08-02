/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
public class Bai2_SaveProduct extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Bai2_SaveProduct</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Bai2_SaveProduct at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String maSanPham = request.getParameter("maSanPham");
        String tenSanPham = request.getParameter("tenSanPham");
        String giaNhap = request.getParameter("giaNhap");
        String giaBan = request.getParameter("giaBan");
        String hanSuDung = request.getParameter("hanSuDung");
        String vat = request.getParameter("vat");
        String moTa = request.getParameter("moTa");
        // check
        String e_maSanPham="";
        if(maSanPham == null || maSanPham.trim().length()==0){
            e_maSanPham = "Vui long nhap ma san pham";
            request.setAttribute("error", e_maSanPham);
        }else if(maSanPham.equals("123")){
            e_maSanPham += "Ma san pham 123 da ton tai , vui long nhap lai";
        }
        request.setAttribute("e_maSanPham", e_maSanPham);
        request.setAttribute("maSanPham", maSanPham);
        request.setAttribute("tenSanPham", tenSanPham);
        request.setAttribute("giaNhap", giaNhap);
        request.setAttribute("giaBan", giaBan);
        request.setAttribute("hanSuDung", hanSuDung);
        request.setAttribute("vat", vat);
        request.setAttribute("moTa", moTa);

        // url
        String url = "";
        if(e_maSanPham.length()>0){
             url = "/Bai2_AddProduct.jsp";
        }else{
            url = "/Bai2_StoreProduct.jsp";
        }
        RequestDispatcher rq = getServletContext().getRequestDispatcher(url);
        rq.forward(request, response);  // PHẢI CÓ DÒNG NÀY        
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
