<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="dao.ProductDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Product" %>
<%
    Boolean isLoggedIn = (Boolean) session.getAttribute("isLoggedIn");
    String username = (String) session.getAttribute("username");
    String email = (String) session.getAttribute("email");

    if (isLoggedIn == null || !isLoggedIn) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>TITV Store</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
  <style>
    .product-img {
      height: 250px;
      object-fit: cover;
    }
    .star-rating {
      color: #f0ad4e;
    }
    .banner {
      width: 100%;
      height: auto;
      object-fit: cover;
      border-radius: 10px;
    }
    .cart-btn {
      font-size: 22px;
      position: relative;
      margin-left: 20px;
    }
    .cart-btn .badge {
      position: absolute;
      top: -5px;
      right: -10px;
      background: red;
      color: white;
      font-size: 12px;
    }
  </style>
</head>
<body>
  <!-- Navbar -->
  <nav class="navbar navbar-expand-lg navbar-light bg-light px-3">
    <a class="navbar-brand" href="#"><strong>Tiến Hùng</strong>.vn</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item"><a class="nav-link active" href="#">Trang chủ</a></li>
        <li class="nav-item"><a class="nav-link" href="#">Combo giảm giá</a></li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Thể loại</a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="#">Thời trang nam</a></li>
            <li><a class="dropdown-item" href="#">Thời trang nữ</a></li>
            <li><a class="dropdown-item" href="#">Dành cho bé</a></li>
          </ul>
        </li>
        <li class="nav-item"><a class="nav-link" href="#">Hết hàng</a></li>
      </ul>
      <form action="FindProductServlet" method="get" class="d-flex">
        <input class="form-control me-2" type="search" name="keyword" placeholder="Nội dung tìm kiếm">
        <button class="btn btn-outline-success" type="submit">Tìm</button>
      </form>

      <!-- Nút giỏ hàng -->
      <%@ page import="dao.CartDAO" %>
      <%
          CartDAO cart = (CartDAO) session.getAttribute("cart");
          int quantitycart = 0;
          if (cart != null) {
              if (cart.getItems() != null) {
                  quantitycart = cart.getItems().stream().mapToInt(i -> i.getQuantity()).sum();
              }
          }
      %>
      <a href="cart.jsp" class="cart-btn" title="Xem giỏ hàng">
        <i class="fas fa-shopping-cart"></i>
        <span class="badge"><%= quantitycart %></span>
      </a>

      <!-- Avatar user -->
      <div class="dropdown ms-3">
        <a class="d-flex align-items-center text-decoration-none dropdown-toggle" href="#" id="userMenu" data-bs-toggle="dropdown" aria-expanded="false">
          <img src="" alt="Avatar" class="rounded-circle me-2" width="40" height="40">
        </a>
        <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="userMenu">
          <li><h6 class="dropdown-header">Thông tin người dùng</h6></li>
          <li><a class="dropdown-item" href="#">Tên: <%= username %></a></li>
          <li><a class="dropdown-item" href="#">Email: <%= email %></a></li>
          <li><hr class="dropdown-divider"></li>
          <li><a class="dropdown-item text-danger" href="LogoutServlet">Đăng xuất</a></li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Main Content -->
  <div class="container mt-4">
    <div class="row">
      <!-- Sidebar danh mục -->
      <div class="col-md-3">
        <div class="list-group">
          <a href="#" class="list-group-item list-group-item-action">Thời trang nam</a>
          <a href="#" class="list-group-item list-group-item-action">Thời trang nữ</a>
          <a href="#" class="list-group-item list-group-item-action">Dành cho bé</a>
        </div>
      </div>

      <!-- Banner và sản phẩm -->
      <div class="col-md-9">
        <img src="image/banner.png" class="banner mb-4" alt="Banner">
        <div class="row row-cols-1 row-cols-md-3 g-4">
          <%
              List<Product> productList = ProductDAO.getInstance().getAllProducts();
              List<Product> affterCollection = new ArrayList<>();
              int count = 0;

              if (productList != null && !productList.isEmpty()) {
                  Collections.sort(productList, (p1, p2) -> p2.getStockQuantity() - p1.getStockQuantity());
                  for (Product product : productList) {
                      count++;
                      if (count <= 3) {
                          affterCollection.add(product);
                      }
                  }
              }
          %>
          <% for (int i = 0; i < Math.min(3, affterCollection.size()); i++) { %>
            <div class="col">
              <div class="card">
                <img src="https://via.placeholder.com/300x250.png?text=PRODUCT+<%= i + 1 %>" class="card-img-top product-img" alt="Product">
                <div class="card-body">
                  <h5><a href="#" class="text-decoration-none"><%= affterCollection.get(i).getName() %></a></h5>
                  <p class="fw-bold"><%= affterCollection.get(i).getPrice() %></p>
                  <p>Sản phẩm thoáng mát, có độ bền tốt, giữ màu sắc tốt.</p>
                  <div class="star-rating">★ ★ ★ ★ ☆</div>
                </div>
              </div>
            </div>
          <% } %>
        </div>
      </div>
    </div>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>