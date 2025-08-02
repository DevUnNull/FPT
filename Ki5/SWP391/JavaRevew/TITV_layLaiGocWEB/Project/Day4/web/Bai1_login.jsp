<%-- 
    Document   : Bai1_login
    Created on : Jul 14, 2025, 12:44:30 PM
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
        <h1>Hello Client!</h1> 
        <form action="bai1_login" method="post">
            UserName: <input type="text" name="userName" value="hai23"><br> 
            PassWord: <input type="password" name="passWord" value="123"><br>
            <input type="submit" value="Login">
        </form>
    </body>
</html>
