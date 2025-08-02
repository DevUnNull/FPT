<%-- 
    Document   : Bai1_Sucsest
    Created on : Jul 14, 2025, 5:18:53 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Chào mừng <%= request.getAttribute("user") %> đến với trang Web!</h1> <%--request là kiểu object --%>
    </body>
</html>
