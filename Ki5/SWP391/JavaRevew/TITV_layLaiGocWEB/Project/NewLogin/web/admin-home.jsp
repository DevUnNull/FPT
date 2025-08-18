<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }

        body {
            display: flex;
            height: 100vh;
        }

        /* Sidebar */
        .sidebar {
            width: 60px;
            background: #2f3542;
            color: white;
            height: 100vh;
            position: fixed;
            transition: width 0.3s ease;
            overflow: hidden;
        }

        .sidebar:hover {
            width: 200px;
        }

        .sidebar ul {
            list-style: none;
            padding: 0;
            margin: 0;
        }

        .sidebar li {
            padding: 20px;
            display: flex;
            align-items: center;
            cursor: pointer;
        }

        .sidebar li:hover {
            background: #57606f;
        }

        .sidebar .icon {
            font-size: 18px;
            margin-right: 10px;
            width: 24px;
            text-align: center;
        }

        .sidebar .text {
            white-space: nowrap;
            opacity: 0;
            transition: opacity 0.3s ease;
        }

        .sidebar:hover .text {
            opacity: 1;
        }

        /* Main content */
        .main {
            margin-left: 60px;
            flex-grow: 1;
            background: #f1f2f6;
            padding: 20px;

            height: 100vh;         /* Chiều cao full màn */
            overflow-y: auto;      /* Cho phép cuộn theo chiều dọc */
            transition: margin-left 0.3s ease;
        }


        .sidebar:hover ~ .main {
            margin-left: 200px;
        }

        .header {
            background: #fff;
            padding: 15px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .header input {
            padding: 8px 12px;
            border: 1px solid #ccc;
            border-radius: 20px;
            width: 300px;
        }

        .content-section {
            display: none;
        }

        .content-section.active {
            display: block;
        }

        .card, .section {
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 6px rgba(0,0,0,0.1);
            margin-bottom: 20px;
        }

        .cards {
            display: flex;
            gap: 20px;
            margin: 20px 0;
        }

        .card h3 {
            font-size: 16px;
            margin-bottom: 10px;
        }

        .card p {
            font-size: 24px;
            font-weight: bold;
        }

        .section h4 {
            margin-bottom: 10px;
        }
    </style>
</head>
<body>

<div class="sidebar">
    <ul>
        <li onclick="showSection('dashboard')"><span class="icon">🏠</span><span class="text">Dashboard</span></li>
        <li onclick="showSection('orders')"><span class="icon">📦</span><span class="text">Orders</span></li>
        <li onclick="showSection('analytics')"><span class="icon">📊</span><span class="text">Analytics</span></li>
        <li onclick="showSection('messages')"><span class="icon">💬</span><span class="text">Messages</span></li>
        <li onclick="showSection('settings')"><span class="icon">⚙️</span><span class="text">Product</span></li>
    </ul>
</div>

<div class="main">
    <div class="header">
        <input type="text" placeholder="Search reports...">
        <div style="display: flex; align-items: center;">
            <span style="margin-right: 10px;">👤 Admin</span>
            <img src="image/account.jpg" style="width: 30px; height: 30px; border-radius: 50%; vertical-align: middle; margin-right: 10px;">
            <a href="LogoutServlet" style="color: red; text-decoration: none; font-size: 14px;">Logout</a>
        </div>

    </div>

    <div id="dashboard" class="content-section active">
        <jsp:include page="admin-dashboard.jsp" />
    </div>

    <div id="orders" class="content-section">
        <jsp:include page="admin-order.jsp" />
    </div>

    <div id="analytics" class="content-section">
        <jsp:include page="admin-analytics.jsp" />
    </div>

    <div id="messages" class="content-section">
        <jsp:include page="admin-messages.jsp" />
    </div>

    <div  id="settings" class="content-section">
        <jsp:include page="admin-product.jsp" />
    </div>
</div>

<script>
    function showSection(sectionId) {
        const sections = document.querySelectorAll('.content-section');
        sections.forEach(sec => sec.classList.remove('active'));
        document.getElementById(sectionId).classList.add('active');
    }
</script>

</body>
</html>
