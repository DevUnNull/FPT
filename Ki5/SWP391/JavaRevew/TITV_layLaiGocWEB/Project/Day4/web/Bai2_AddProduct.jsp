<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Form Sản Phẩm</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light p-4">

<%
    String maSanPham = (String) request.getAttribute("maSanPham");
    String tenSanPham = (String) request.getAttribute("tenSanPham");
    String giaNhap = (String) request.getAttribute("giaNhap");
    String giaBan = (String) request.getAttribute("giaBan");
    String hanSuDung = (String) request.getAttribute("hanSuDung");
    String vat = (String) request.getAttribute("vat");
    String moTa = (String) request.getAttribute("moTa");
    String error = (String) request.getAttribute("e_maSanPham");
%>

<div class="container bg-white p-4 rounded shadow-sm">
  <h4 class="mb-4">Thông tin sản phẩm</h4>

  <% if (error != null && !error.isEmpty()) { %>
    <div class="alert alert-danger"><%= error %></div>
  <% } %>

  <form action="bai2_SaveProduct" id="My_form" method="get">
    <div class="row mb-3">
      <div class="col-md-6">
        <label for="maSanPham" class="form-label">Mã sản phẩm*</label>
        <input type="text" name="maSanPham" class="form-control" id="maSanPham"
               value="<%= error != null ? "" : "" %>" required>
      </div>
      <div class="col-md-6">
        <label for="tenSanPham" class="form-label">Tên sản phẩm*</label>
        <input type="text" name="tenSanPham" class="form-control" id="tenSanPham"
               value="<%= tenSanPham != null ? tenSanPham : "" %>" required>
      </div>
    </div>

    <div class="row mb-3">
      <div class="col-md-6">
        <label for="giaNhap" class="form-label">Giá nhập*</label>
        <input type="number" name="giaNhap" class="form-control" id="giaNhap"
               value="<%= giaNhap != null ? giaNhap : "" %>" required>
      </div>
      <div class="col-md-6">
        <label for="giaBan" class="form-label">Giá bán*</label>
        <input type="number" name="giaBan" class="form-control" id="giaBan"
               value="<%= giaBan != null ? giaBan : "" %>" required>
      </div>
    </div>

    <div class="row mb-3">
      <div class="col-md-6">
        <label for="hanSuDung" class="form-label">Hạn sử dụng</label>
        <input type="date" name="hanSuDung" class="form-control" id="hanSuDung"
               value="<%= hanSuDung != null ? hanSuDung : "" %>">
      </div>
      <div class="col-md-6">
        <label for="vat" class="form-label">VAT (%)</label>
        <input type="number" name="vat" class="form-control" id="vat"
               value="<%= vat != null ? vat : "" %>">
      </div>
    </div>

    <div class="mb-3">
      <label for="moTa" class="form-label">Mô tả sản phẩm</label>
      <textarea class="form-control" name="moTa" id="moTa" rows="4"><%= moTa != null ? moTa : "" %></textarea>
    </div>

    <button type="submit" class="btn btn-primary w-100">Lưu sản phẩm</button>
  </form>
</div>

</body>
</html>
