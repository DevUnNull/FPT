<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hủy đặt bàn</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f5f5f5;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 60%;
            margin: 50px auto;
            background: white;
            padding: 25px;
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
            flex-direction: column;
            gap: 20px;
        }
        select, textarea {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 14px;
        }
        textarea {
            min-height: 100px;
        }
        .cancel-btn {
            background: #dc3545;
            color: white;
            border: none;
            padding: 12px 20px;
            border-radius: 8px;
            cursor: pointer;
            align-self: flex-end;
        }
        .cancel-btn:hover {
            background: #c82333;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>❌ Hủy đặt bàn</h2>

        <form action="xulyhuydatban.jsp" method="post">
            <label><b>Chọn bàn muốn hủy:</b></label>
            <select name="bookingId" required>
                <option value="">-- Chọn đơn đặt bàn --</option>
                <option value="DB001">DB001 - Bàn 05 - 18:30 (15/09/2025)</option>
                <option value="DB002">DB002 - Bàn 02 - 12:00 (10/09/2025)</option>
                <option value="DB003">DB003 - Bàn 08 - 19:00 (05/09/2025)</option>
            </select>

            <label><b>Lý do hủy:</b></label>
            <textarea name="reason" placeholder="Nhập lý do hủy đơn..." required></textarea>

            <button type="submit" class="cancel-btn">Xác nhận hủy</button>
        </form>
    </div>
</body>
</html>
