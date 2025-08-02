package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy session hiện tại, không tạo mới
        HttpSession session = request.getSession(false);

        if (session != null) {
            // Hủy session để logout
            session.invalidate();
        }

        // Chuyển về trang login.jsp
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Xử lý POST tương tự GET
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet dùng để đăng xuất người dùng";
    }
}
