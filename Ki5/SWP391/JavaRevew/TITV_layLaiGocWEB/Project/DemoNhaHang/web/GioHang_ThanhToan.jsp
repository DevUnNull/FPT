<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Giỏ hàng & Thanh toán</title>
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
        .remove-mark {
            font-size: 18px;
            color: red;
            font-weight: bold;
        }
        .total {
            text-align: right;
            font-size: 18px;
            margin-top: 10px;
        }
        .payment-method {
            margin: 20px 0;
        }
        .payment-method label {
            margin-right: 20px;
            font-weight: bold;
        }
        .update-btn {
            background: #ffc107;
            color: black;
            border: none;
            padding: 10px 18px;
            border-radius: 8px;
            cursor: pointer;
        }
        .update-btn:hover {
            background: #e0a800;
        }
        .confirm-btn {
            background: #28a745;
            color: white;
            border: none;
            padding: 12px 20px;
            border-radius: 8px;
            cursor: pointer;
            float: right;
        }
        .confirm-btn:hover {
            background: #218838;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>🛒 Giỏ hàng & Thanh toán</h2>
        
        <form action="xulygiohang.jsp" method="post">
            <table>
                <tr>
                    <th>Xóa</th>
                    <th>Tên món</th>
                    <th>Số lượng</th>
                    <th>Đơn giá (VND)</th>
                    <th>Thành tiền (VND)</th>
                </tr>
                <tr>
                    <td><input type="checkbox" name="remove" value="phoBo"checked><span class="remove-mark"></span></td>
                    <td>Phở Bò</td>
                    <td><input type="number" name="phoBo_qty" value="2" min="0"></td>
                    <td>50,000</td>
                    <td>100,000</td>
                </tr>
                <tr>
                    <td><input type="checkbox" name="remove" value="banhMi"checked><span class="remove-mark"></span></td>
                    <td>Bánh Mì Thịt</td>
                    <td><input type="number" name="banhMi_qty" value="1" min="0"></td>
                    <td>25,000</td>
                    <td>25,000</td>
                </tr>
                <tr>
                    <td><input type="checkbox" name="remove" value="nuocCam"checked><span class="remove-mark"></span></td>
                    <td>Nước Cam</td>
                    <td><input type="number" name="nuocCam_qty" value="3" min="0"></td>
                    <td>20,000</td>
                    <td>60,000</td>
                </tr>
            </table>

            <div class="total">
                <b>Tổng số món: 6</b><br>
                <b>Tổng cộng: 185,000 VND</b>
            </div>

            <div class="payment-method">
                <p><b>Chọn hình thức thanh toán:</b></p>
                <label><input type="radio" name="payment" value="COD" checked> Thanh toán khi nhận (COD)</label>
                <label><input type="radio" name="payment" value="Online"> Thanh toán Online</label>
                <label><input type="radio" name="payment" value="Card"> Thẻ Ngân Hàng</label>
            </div>

            <button type="submit" name="action" value="update" class="update-btn">🔄 Cập nhật giỏ hàng</button>
            <button type="submit" name="action" value="confirm" class="confirm-btn">✅ Xác nhận đơn hàng</button>
        </form>
    </div>
</body>
</html>
