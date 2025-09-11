<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chọn món & Đặt bàn</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f5f5f5;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 80%;
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
        .menu-list {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(220px, 1fr));
            gap: 20px;
        }
        .menu-item {
            border: 1px solid #ddd;
            padding: 15px;
            border-radius: 8px;
            background: #fafafa;
        }
        .menu-item h3 {
            margin-top: 0;
            color: #007bff;
        }
        .menu-item input[type=number] {
            width: 60px;
            padding: 5px;
            margin-top: 10px;
        }
        textarea {
            width: 100%;
            height: 80px;
            margin-top: 15px;
            padding: 10px;
            border-radius: 6px;
            border: 1px solid #ccc;
        }
        button {
            margin-top: 20px;
            padding: 12px 20px;
            background: #28a745;
            color: white;
            border: none;
            border-radius: 8px;
            cursor: pointer;
        }
        button:hover {
            background: #218838;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>🍽️ Chọn món & Đặt bàn</h2>
        <form action="xacnhandatban.jsp" method="post">
            <div class="menu-list">
                <%-- Giả lập menu (sau này lấy từ DB) --%>
                <div class="menu-item">
                    <h3>Phở Bò</h3>
                    <p>Giá: 50,000 VND</p>
                    <label>Số lượng: 
                        <input type="number" name="phoBo" value="0" min="0">
                    </label>
                </div>
                <div class="menu-item">
                    <h3>Bánh Mì Thịt</h3>
                    <p>Giá: 25,000 VND</p>
                    <label>Số lượng: 
                        <input type="number" name="banhMi" value="0" min="0">
                    </label>
                </div>
                <div class="menu-item">
                    <h3>Cơm Gà</h3>
                    <p>Giá: 40,000 VND</p>
                    <label>Số lượng: 
                        <input type="number" name="comGa" value="0" min="0">
                    </label>
                </div>
                <div class="menu-item">
                    <h3>Nước Cam</h3>
                    <p>Giá: 20,000 VND</p>
                    <label>Số lượng: 
                        <input type="number" name="nuocCam" value="0" min="0">
                    </label>
                </div>
            </div>

            <label for="note"><b>Ghi chú yêu cầu đặc biệt:</b></label>
            <textarea name="note" placeholder="Ví dụ: thêm đá, ít cay..."></textarea>

            <button type="submit">✅ Xác nhận đặt bàn kèm món</button>
        </form>
    </div>
</body>
</html>
