<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tìm bàn trống</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f5f5f5;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 70%;
            margin: 50px auto;
            background: white;
            padding: 20px;
            border-radius: 12px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.2);
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }
        form {
            display: flex;
            justify-content: center;
            gap: 20px;
            margin-bottom: 30px;
        }
        input, button, select {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 6px;
        }
        button {
            background: #28a745;
            color: white;
            cursor: pointer;
        }
        button:hover {
            background: #218838;
        }
        .table-list {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(180px, 1fr));
            gap: 20px;
        }
        .table-item {
            border: 1px solid #ddd;
            padding: 15px;
            border-radius: 8px;
            text-align: center;
            background: #fafafa;
        }
        .table-item button {
            background: #007bff;
        }
        .table-item button:hover {
            background: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>🍽️ Tìm bàn trống</h2>
        <form action="timban.jsp" method="get">
            <label>Ngày: <input type="date" name="ngay" required></label>
            <label>Giờ: <input type="time" name="gio" required></label>
            <button type="submit">Tìm bàn trống</button>
        </form>

        <div class="table-list">
            <%-- Giả lập dữ liệu bàn trống (sau này sẽ lấy từ DB) --%>
            <div class="table-item">
                <h3>Bàn 01</h3>
                <p>Sức chứa: 4 người</p>
                <button>Đặt bàn</button>
            </div>
            <div class="table-item">
                <h3>Bàn 02</h3>
                <p>Sức chứa: 6 người</p>
                <button>Đặt bàn</button>
            </div>
            <div class="table-item">
                <h3>Bàn 05</h3>
                <p>Sức chứa: 2 người</p>
                <button>Đặt bàn</button>
            </div>
        </div>
    </div>
</body>
</html>
