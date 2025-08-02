<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Kết quả kiểm tra Regex</title></head>
<body>
    <h2>Kết quả kiểm tra Regex</h2>
    <p><strong>Chuỗi:</strong> <%= request.getAttribute("input") %></p>
    <p><strong>Regex:</strong> <code><%= request.getAttribute("regex") %></code></p>
    <p><strong>Kết quả:</strong> <%= request.getAttribute("result") %></p>
    <br><a href="Bai1_RegularExpression.jsp">⬅ Quay lại</a>
</body>
</html>
