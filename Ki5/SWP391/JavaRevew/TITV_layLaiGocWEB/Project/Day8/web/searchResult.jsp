<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Product" %>
<html>
<head>
    <title>Kết quả tìm kiếm</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <!-- Thêm icon bootstrap -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
</head>
<body class="container mt-4">

<h2 class="mb-3">
    Kết quả tìm kiếm cho: 
    <span class="text-primary"><%= request.getAttribute("keyword") != null ? request.getAttribute("keyword") : "" %></span>
</h2>

<%
    List<Product> products = (List<Product>) request.getAttribute("products");
    if (products != null && !products.isEmpty()) {
%>
    <table class="table table-bordered table-hover">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Tên sản phẩm</th>
            <th>Mô tả</th>
            <th>Giá (VNĐ)</th>
            <th>Số lượng tồn</th>
            <th>Hình ảnh</th>
            <th>Danh mục</th>
            <th>Trạng thái</th>
            <th>Thêm vào giỏ</th>  <!-- Cột mới -->
        </tr>
        </thead>
        <tbody>
        <% for (Product p : products) { %>
            <tr>
                <td><%= p.getId() %></td>
                <td><%= p.getName() %></td>
                <td><%= p.getDescription() %></td>
                <td><%= String.format("%,d", p.getPrice()) %></td>
                <td><%= p.getStockQuantity() %></td>
                <td>
                    <% if (p.getImageUrl() != null && !p.getImageUrl().isEmpty()) { %>
                        <img src="<%= p.getImageUrl() %>" alt="Ảnh" width="60" height="60">
                    <% } else { %>
                        <span>Không có</span>
                    <% } %>
                </td>
                <td><%= p.getCategory() %></td>
                <td>
                    <% if (p.getStock() == 1) { %>
                        <span class="badge bg-success">Đang bán</span>
                    <% } else { %>
                        <span class="badge bg-secondary">Ngừng bán</span>
                    <% } %>
                </td>
                <td class="text-center">
                    <% if (p.getStock() == 1) { %>
                        <form action="<%= request.getContextPath() %>/AddToCartServlet" method="post" class="d-inline">
                            <input type="hidden" name="productId" value="<%= p.getId() %>">
                            <input type="hidden" name="quantity" value="1">
                            <button type="submit" class="btn btn-sm btn-primary">
                                <i class="bi bi-cart-plus"></i>
                            </button>
                        </form>
                    <% } else { %>
                        <button class="btn btn-sm btn-secondary" disabled>
                            <i class="bi bi-cart-x"></i>
                        </button>
                    <% } %>
                </td>

            </tr>
        <% } %>
        </tbody>
    </table>
<%
    } else {
%>
    <div class="alert alert-warning">
        Không tìm thấy kết quả nào phù hợp với từ khóa "<%= request.getAttribute("keyword") %>"
    </div>
<%
    }
%>

<a href="home.jsp" class="btn btn-secondary mt-3">Quay lại trang chủ</a>

</body>
</html>
