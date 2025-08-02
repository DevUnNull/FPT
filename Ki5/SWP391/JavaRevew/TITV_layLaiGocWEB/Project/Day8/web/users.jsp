<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.User" %>
<html>
<head>
    <title>Danh sách người dùng</title>
    <style>
        table {
            width: 80%;
            border-collapse: collapse;
            margin: 20px auto;
        }
        th, td {
            border: 1px solid #333;
            padding: 8px 12px;
            text-align: center;
        }
        th {
            background-color: #f0f0f0;
        }
        h2 {
            text-align: center;
        }
    </style>
</head>
<body>

<h2>Danh sách người dùng</h2>

<table>
    <tr>
        <th>ID</th>
        <th>Tên đăng nhập</th>
        <th>Email</th>
        <th>Họ tên</th>
    </tr>

    <%
        List<User> userList = (List<User>) request.getAttribute("userList");

        if (userList != null && !userList.isEmpty()) {
            for (User user : userList) {
    %>
    <tr>
        <td><%= user.getId() %></td>
        <td><%= user.getUsername() %></td>
        <td><%= user.getEmail() %></td>
        <td><%= user.getFullName() %></td>
    </tr>
    <%
            }
        } else {
    %>
    <tr>
        <td colspan="4">Không có người dùng nào được tìm thấy.</td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>
