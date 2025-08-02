<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Đăng nhập</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        h2 {
            text-align: center;
            margin-top: 30px;
        }

        .container {
            width: 400px;
            margin: 30px auto;
            background: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
        }

        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"] {
            width: 100%;
            background-color: #007bff;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        .error {
            color: red;
            text-align: center;
            margin-top: 10px;
        }

        .message {
            text-align: center;
            margin-top: 15px;
        }

        .message a {
            color: #28a745;
            text-decoration: none;
        }

        .message a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h2>ĐĂNG NHẬP</h2>
    <div class="container">
        <form action="LoginServlet" method="post">
            <label for="username">Tên đăng nhập:</label>
            <input type="text" name="username" id="username" required />

            <label for="password">Mật khẩu:</label>
            <input type="password" name="password" id="password" required />

            <input type="submit" value="Đăng nhập" />
        </form>
        <p class="error">${error}</p>
        <div class="message">
            <p>Chưa có tài khoản? <a href="register.jsp">Đăng ký</a></p>
        </div>
    </div>
</body>
</html>
