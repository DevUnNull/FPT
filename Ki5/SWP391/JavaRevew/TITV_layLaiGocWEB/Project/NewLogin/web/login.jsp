<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            height: 100vh;
            background: url('image/background.jpg') no-repeat center center/cover;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .login-container {
            background: rgba(0, 0, 0, 0.4);
            padding: 40px;
            border-radius: 10px;
            text-align: center;
            color: white;
            width: 320px;
        }
        .logo {
            font-size: 32px;
            font-weight: bold;
            margin-bottom: 30px;
        }
        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 12px;
            margin: 10px 0;
            border-radius: 6px;
            border: none;
            outline: none;
        }
        .actions {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin: 15px 0;
        }
        .actions a {
            font-size: 14px;
            color: #ccc;
            text-decoration: none;
        }
        .btn {
            width: 100%;
            padding: 12px;
            background: white;
            color: black;
            font-weight: bold;
            border: none;
            border-radius: 25px;
            cursor: pointer;
        }
        .btn:hover {
            background: #f0f0f0;
        }
    </style>
</head>
<body>

<div class="login-container">
    <div class="logo">UnNull</div>

    <form action="LoginServlet" method="post">
        <input type="text" name="username" placeholder="Username" required>
        <input type="password" name="password" placeholder="Password" required>

        <div class="actions">
            <a href="forgotPassword.jsp">Forgot Password?</a>
            <a href="register.jsp">Create an Account</a>
        </div>

        <button type="submit" class="btn">Login</button>
    </form>
</div>

</body>
</html>
