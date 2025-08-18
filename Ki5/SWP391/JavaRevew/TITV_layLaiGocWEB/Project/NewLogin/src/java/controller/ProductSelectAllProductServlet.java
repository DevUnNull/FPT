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
import java.util.List;
import model.Category;
import model.Product;

/**
 *
 * @author User
 */
public class ProductSelectAllProductServlet extends HttpServlet {
   private final ProductDAO dao = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Product> products = dao.getAllProducts();
        List<Category> category = dao.getAllCategories();

        // Nếu cần lấy cả categoryName, bạn phải sửa DAO để JOIN bảng category

        req.setAttribute("categoryList", category);
        req.setAttribute("productList", products);
        req.getRequestDispatcher("/admin-home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        List<Product> products = dao.getAllProducts();
        List<Category> category = dao.getAllCategories();

        // Nếu cần lấy cả categoryName, bạn phải sửa DAO để JOIN bảng category

        req.setAttribute("categoryList", category);
        req.setAttribute("productList", products);
        req.getRequestDispatcher("/admin-home.jsp").forward(req, resp);

    }
    
    
}
