<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Kết quả đăng nhập</title>
</head>
<body>
    <%
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Kiểm tra đăng nhập (cứng, ví dụ thôi)
        if (username != null && password != null) {
            if (username.equals("admin") && password.equals("123456")) {
    %>
                <h2>Đăng nhập thành công!</h2>
                <p>Chào mừng <strong><%= username %></strong>.</p>
    <%
            } else {
    %>
                <h2>Đăng nhập thất bại!</h2>
                <p>Tên đăng nhập hoặc mật khẩu không đúng.</p>
    <%
            }
        } else {
    %>
            <h2>Chưa nhập thông tin đăng nhập</h2>
    <%
        }
    %>
</body>
</html>
