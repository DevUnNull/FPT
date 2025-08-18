package controller;

import dao.ProductDAO;
import model.Product;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ProductAddServlet extends HttpServlet {

    // controller/ProductAddServlet.java

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String name        = req.getParameter("name");
        String description = req.getParameter("description");
        String priceStr    = req.getParameter("price");
        String stockStr    = req.getParameter("stock_quantity");
        String imageUrl    = req.getParameter("image_url");
        String categoryName= req.getParameter("category_name"); // <<< thêm input này ở form

        try {
            BigDecimal price = new BigDecimal(priceStr);
            int stockQuantity = Integer.parseInt(stockStr);

            Product p = new Product();
            p.setName(name);
            p.setDescription(description);
            p.setPrice(price);
            p.setStockQuantity(stockQuantity);
            p.setImageUrl(imageUrl);

            int newId = ProductDAO.getInstance().addProductWithCategoryNew(p, categoryName);

            req.getSession().setAttribute("msg", "Đã thêm sản phẩm #" + newId + " thành công");
            resp.sendRedirect(req.getContextPath() + "/ProductSelectAllProductServlet");

        } catch (Exception e) {
            e.printStackTrace();
            req.getSession().setAttribute("err", "Lỗi thêm sản phẩm: " + e.getMessage());
            resp.sendRedirect(req.getContextPath() + "/ProductSelectAllProductServlet");
        }
    }

}
