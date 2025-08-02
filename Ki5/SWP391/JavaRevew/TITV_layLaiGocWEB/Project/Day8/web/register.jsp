<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Đăng ký</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        h2 {
            text-align: center;
            margin-top: 20px;
        }

        .container {
            width: 600px;
            margin: 30px auto;
            background: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
        }

        form label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        form input[type="text"],
        form input[type="password"],
        form input[type="email"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        #matchMessage {
            margin-bottom: 15px;
            font-weight: bold;
        }

        input[type="submit"] {
            background-color: #28a745;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #218838;
        }

        .message {
            text-align: center;
            margin-top: 10px;
        }

        .message a {
            color: #007bff;
            text-decoration: none;
        }

        .message a:hover {
            text-decoration: underline;
        }

        .error {
            color: red;
            text-align: center;
        }

        .success {
            color: green;
            text-align: center;
        }
    </style>

    <script>
        function checkPasswordMatch() {
            var password = document.getElementById("password").value;
            var confirm = document.getElementById("confirmPassword").value;
            var message = document.getElementById("matchMessage");

            if (confirm.length === 0) {
                message.textContent = "";
                return;
            }

            if (password === confirm) {
                message.style.color = "green";
                message.textContent = "✔ Mật khẩu khớp";
            } else {
                message.style.color = "red";
                message.textContent = "✖ Mật khẩu không khớp";
            }
        }
    </script>
</head>
<body>
    <h2>ĐĂNG KÝ TÀI KHOẢN</h2>
    <div class="container">
        <form action="RegisterServlet" method="post">
            <label for="username">Tên đăng nhập:</label>
            <input type="text" name="username" required />

            <label for="password">Mật khẩu:</label>
            <input type="password" id="password" name="password" required onkeyup="checkPasswordMatch()" />

            <label for="confirmPassword">Nhập lại mật khẩu:</label>
            <input type="password" id="confirmPassword" name="confirmPassword" required onkeyup="checkPasswordMatch()" />
            <div id="matchMessage"></div>

            <label for="email">Email:</label>
            <input type="email" name="email" />

            <label for="fullName">Họ tên:</label>
            <input type="text" name="fullName" />

            <input type="submit" value="Đăng ký" />
        </form>
        <p class="error">${error}</p>
        <p class="success">${success}</p>
        <div class="message">
            <p>Đã có tài khoản? <a href="login.jsp">Đăng nhập</a></p>
        </div>
    </div>
</body>
</html>
