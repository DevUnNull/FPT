package controller;

import dao.UserDAO;
import model.User;
import model.Role;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDAO userDAO = UserDAO.getInstance();
        User us = userDAO.getUserByLogin(username, password);
        
        if (us != null) {
            // Lấy danh sách roles của user
            List<Role> roles = userDAO.getRolesByUserId(us.getUserId());

            // Lưu user và roles vào session
            HttpSession session = request.getSession();
            session.setAttribute("user", us);
            session.setAttribute("roles", roles);

            // Điều hướng dựa trên quyền
            boolean isAdmin = roles.stream().anyMatch(r -> "ADMIN".equalsIgnoreCase(r.getRoleName()));
            boolean isManager = roles.stream().anyMatch(r -> "MANAGER".equalsIgnoreCase(r.getRoleName()));
            boolean isUser = roles.stream().anyMatch(r -> "USER".equalsIgnoreCase(r.getRoleName()));

            if (isAdmin) {
                response.sendRedirect("ProductSelectAllProductServlet");
            } else if (isManager) {
                response.sendRedirect("manager-home.jsp");
            } else if (isUser) {
                response.sendRedirect("user-home.jsp");
            } else {
                // Nếu không có quyền nào khớp → access denied
                response.sendRedirect("access-denied.jsp");
            }
        } else {
            // Sai thông tin đăng nhập
            request.setAttribute("error", "Sai username hoặc password!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
