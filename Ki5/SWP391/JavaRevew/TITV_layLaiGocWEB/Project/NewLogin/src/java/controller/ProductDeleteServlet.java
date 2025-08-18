/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.*;

/**
 *
 * @author User
 */
public class ProductDeleteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
    String action = req.getParameter("action");
    HttpSession session = req.getSession();
    try {
        if ("delete".equalsIgnoreCase(action)) {
            int idProduct = Integer.parseInt(req.getParameter("id"));
            int result = ProductDAO.getInstance().DeleteProductById(idProduct);

            if (result > 0) {
                session.setAttribute("msg", "Đã xóa sản phẩm #" + idProduct + " thành công");
            } else {
                session.setAttribute("err", "Không tìm thấy/không thể xóa sản phẩm #" + idProduct);
            }
        } else {
            session.setAttribute("err", "Hành động không hợp lệ");
        }
    } catch (Exception e) {
        e.printStackTrace();
        session.setAttribute("err", "Lỗi xóa sản phẩm: " + e.getMessage());
    }
    resp.sendRedirect(req.getContextPath() + "/ProductSelectAllProductServlet");
}

    
}
