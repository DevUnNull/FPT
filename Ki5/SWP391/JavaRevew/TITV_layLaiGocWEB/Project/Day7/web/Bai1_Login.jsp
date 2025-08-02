<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng nhập</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(to right, #74ebd5, #acb6e5);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .login-container {
            background-color: #fff;
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.15);
            width: 350px;
            text-align: center;
        }

        .login-container h2 {
            margin-bottom: 24px;
            color: #333;
        }

        .login-container label {
            display: block;
            margin-bottom: 6px;
            text-align: left;
            color: #555;
            font-weight: 500;
        }

        .login-container input[type="text"],
        .login-container input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 18px;
            border: 1px solid #ccc;
            border-radius: 6px;
            box-sizing: border-box;
        }

        .login-container input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 6px;
            font-size: 16px;
            cursor: pointer;
        }

        .login-container input[type="submit"]:hover {
            background-color: #45a049;
        }

        .error-message {
            color: red;
            margin-bottom: 16px;
        }

        .create-account-btn {
            margin-top: 12px;
            background-color: #2196F3;
        }

        .create-account-btn:hover {
            background-color: #1976D2;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <h2>Đăng nhập</h2>

        <%
            String error = request.getParameter("error");
            if (error != null) {
        %>
            <div class="error-message"><%= error %></div>
        <%
            }
        %>

        <form action="bai1_SessionLogin" method="post">
            <label for="username">Tên đăng nhập:</label>
            <input type="text" name="username" id="username" required />

            <label for="password">Mật khẩu:</label>
            <input type="password" name="password" id="password" required />

            <input type="submit" value="Đăng nhập" />
        </form>

        <form action="Bai1_CreateAccount.jsp" method="get">
            <input type="submit" value="Tạo tài khoản" class="create-account-btn" />
        </form>
    </div>
</body>
</html>
