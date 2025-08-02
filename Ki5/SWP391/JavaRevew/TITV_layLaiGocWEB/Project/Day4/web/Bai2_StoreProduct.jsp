<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>Sản phẩm đã được lưu</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light p-5">
<div class="container bg-white p-4 rounded shadow-sm">

  <h3 class="text-success mb-4">✅ Sản phẩm đã được thêm thành công!</h3>

  <table class="table table-bordered">
    <tr>
      <th>Mã sản phẩm</th>
      <td><%= request.getAttribute("maSanPham") %></td>
    </tr>
    <tr>
      <th>Tên sản phẩm</th>
      <td><%= request.getAttribute("tenSanPham") %></td>
    </tr>
    <tr>
      <th>Giá nhập</th>
      <td><%= request.getAttribute("giaNhap") %></td>
    </tr>
    <tr>
      <th>Giá bán</th>
      <td><%= request.getAttribute("giaBan") %></td>
    </tr>
    <tr>
      <th>Hạn sử dụng</th>
      <td><%= request.getAttribute("hanSuDung") %></td>
    </tr>
    <tr>
      <th>VAT (%)</th>
      <td><%= request.getAttribute("vat") %></td>
    </tr>
    <tr>
      <th>Mô tả</th>
      <td><%= request.getAttribute("moTa") %></td>
    </tr>
  </table>

  <div class="mt-4">
    <a href="Bai2_AddProduct.jsp" class="btn btn-outline-primary">➕ Thêm sản phẩm khác</a>
  </div>

</div>
</body>
</html>
