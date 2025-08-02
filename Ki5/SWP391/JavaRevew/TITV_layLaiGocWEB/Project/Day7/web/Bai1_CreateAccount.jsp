<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Tạo tài khoản</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(to right, #ffecd2, #fcb69f);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .register-container {
            background-color: #fff;
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.15);
            width: 360px;
            text-align: center;
        }

        .register-container h2 {
            margin-bottom: 24px;
            color: #333;
        }

        .register-container label {
            display: block;
            margin-bottom: 6px;
            text-align: left;
            color: #555;
            font-weight: 500;
        }

        .register-container input[type="text"],
        .register-container input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 18px;
            border: 1px solid #ccc;
            border-radius: 6px;
            box-sizing: border-box;
        }

        .register-container input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #FF5722;
            color: white;
            border: none;
            border-radius: 6px;
            font-size: 16px;
            cursor: pointer;
        }

        .register-container input[type="submit"]:hover {
            background-color: #E64A19;
        }

        .back-link {
            margin-top: 16px;
            display: block;
            color: #333;
            text-decoration: none;
            font-size: 14px;
        }

        .back-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="register-container">
        <h2>Đăng ký tài khoản mới</h2>

        <form action="bai1_CreateAccount" method="post">
            <label for="CreateUserName">Tên đăng nhập:</label>
            <input type="text" name="CreateUserName" id="CreateUserName" required />

            <label for="CreatePassword">Mật khẩu:</label>
            <input type="password" name="CreatePassword" id="CreatePassword" required />

            <input type="submit" value="Tạo tài khoản" />
        </form>

        <a href="login.jsp" class="back-link">← Quay lại đăng nhập</a>
    </div>
</body>
</html>
