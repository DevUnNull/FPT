package controller;

import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Category;

import java.io.IOException;
import java.util.List;

public class CategoryAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String rawName = req.getParameter("category_name");
        String rawDesc = req.getParameter("description");

        String name = rawName == null ? "" : rawName.trim();
        String description = rawDesc == null ? "" : rawDesc.trim();

        // Validate tên
        if (name.isEmpty()) {
            req.getSession().setAttribute("CategoryAddNull", "Tên category không được để trống.");
            resp.sendRedirect(req.getContextPath() + "/ProductSelectAllProductServlet");
            return;
        }

        // Kiểm tra trùng (không phân biệt hoa thường)
        List<Category> listCategory = ProductDAO.getInstance().getAllCategories();
        boolean exists = listCategory != null && listCategory.stream()
                .anyMatch(c -> c.getCategoryName() != null
                             && c.getCategoryName().trim().equalsIgnoreCase(name));

        if (exists) {
            req.getSession().setAttribute("CategoryAddNull", "Category đã tồn tại.");
            resp.sendRedirect(req.getContextPath() + "/ProductSelectAllProductServlet");
            return;
        }

        // Thêm mới
        Category c = new Category();
        c.setCategoryName(name);
        c.setDescription(description);

        try {
            ProductDAO.getInstance().addCategory(c);
            // PRG: redirect về danh sách để tránh double-submit
            resp.sendRedirect(req.getContextPath() + "/ProductSelectAllProductServlet");
        } catch (Exception e) {
            req.getSession().setAttribute("CategoryAddNull", "Lỗi khi thêm category: " + e.getMessage());
            resp.sendRedirect(req.getContextPath() + "/ProductSelectAllProductServlet");
        }
    }
}
