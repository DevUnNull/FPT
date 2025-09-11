<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách bàn đã đặt</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f5f5f5;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 85%;
            margin: 40px auto;
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
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 25px;
        }
        table th, table td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: center;
        }
        table th {
            background: #007bff;
            color: white;
        }
        .status {
            font-weight: bold;
            padding: 5px 10px;
            border-radius: 6px;
        }
        .pending {
            background: #ffc107;
            color: black;
        }
        .confirmed {
            background: #28a745;
            color: white;
        }
        .done {
            background: #6c757d;
            color: white;
        }
        .detail-btn {
            background: #17a2b8;
            color: white;
            border: none;
            padding: 8px 14px;
            border-radius: 6px;
            cursor: pointer;
        }
        .detail-btn:hover {
            background: #117a8b;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>📋 Danh sách bàn đã đặt</h2>
        
        <table>
            <tr>
                <th>Mã đặt bàn</th>
                <th>Ngày</th>
                <th>Giờ</th>
                <th>Số bàn</th>
                <th>Số người</th>
                <th>Trạng thái</th>
                <th>Hành động</th>
            </tr>
            <tr>
                <td>DB001</td>
                <td>2025-09-15</td>
                <td>18:30</td>
                <td>Bàn 05</td>
                <td>4</td>
                <td><span class="status pending">⏳ Đang chờ</span></td>
                <td><button class="detail-btn">Chi tiết</button></td>
            </tr>
            <tr>
                <td>DB002</td>
                <td>2025-09-10</td>
                <td>12:00</td>
                <td>Bàn 02</td>
                <td>2</td>
                <td><span class="status confirmed">✅ Đã xác nhận</span></td>
                <td><button class="detail-btn">Chi tiết</button></td>
            </tr>
            <tr>
                <td>DB003</td>
                <td>2025-09-05</td>
                <td>19:00</td>
                <td>Bàn 08</td>
                <td>6</td>
                <td><span class="status done">✔️ Hoàn tất</span></td>
                <td><button class="detail-btn">Chi tiết</button></td>
            </tr>
        </table>
    </div>
</body>
</html>
