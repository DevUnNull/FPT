<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Chic Threads</title>
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
        }

        /* Header top bar */
        .top-bar {
            background: #fff;
            padding: 10px 20px;
            display: flex;
            justify-content: flex-end;
            border-bottom: 1px solid #eee;
        }
        .top-bar a {
            margin-left: 15px;
            text-decoration: none;
            color: #333;
            font-size: 14px;
        }

        /* Nav menu */
        nav {
            background: #fff;
            padding: 15px 30px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            border-bottom: 1px solid #eee;
        }
        nav .logo {
            font-size: 22px;
            font-weight: bold;
        }
        nav ul {
            list-style: none;
            display: flex;
            margin: 0;
            padding: 0;
        }
        nav ul li {
            margin: 0 15px;
        }
        nav ul li a {
            text-decoration: none;
            color: #333;
            font-weight: bold;
        }
        nav .cart {
            font-size: 14px;
            color: #333;
        }

        /* Banner chạy ngang */
        .banner {
            position: relative;
            width: 100%;
            overflow: hidden;
            height: 600px;
        }
        .banner-track {
            display: flex;
            width: calc(200%);
            animation: scrollBanner 20s linear infinite;
        }
        .banner-track img {
            width: 20%;
            height: auto;
        }
        @keyframes scrollBanner {
            0% { transform: translateX(0); }
            100% { transform: translateX(-50%); }
        }

        /* Search bar */
        .search-bar {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            display: flex;
            width: 50%;
            background: white;
            border-radius: 30px;
            overflow: hidden;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        }
        .search-bar input {
            flex: 1;
            border: none;
            padding: 15px;
            font-size: 16px;
            outline: none;
        }
        .search-bar button {
            background: none;
            border: none;
            padding: 0 20px;
            cursor: pointer;
            font-size: 16px;
        }

        /* Product list */
        .products {
            padding: 30px;
            display: grid;
            grid-template-columns: repeat(5, 1fr);
            gap: 20px;
        }
        .product {
            text-align: center;
        }
        .product img {
            width: 100%;
            border-radius: 5px;
        }
        .product-name {
            margin: 10px 0 5px;
            font-weight: bold;
        }
        .price {
            color: #666;
            margin-bottom: 5px;
        }
        .btn {
            display: inline-block;
            padding: 5px 10px;
            border: 1px solid #333;
            border-radius: 3px;
            background: #fff;
            cursor: pointer;
            font-size: 12px;
            margin: 2px;
        }
        .btn:hover {
            background: #333;
            color: white;
        }

        /* Footer */
        footer {
            background: #111;
            color: white;
            text-align: center;
            padding: 20px;
            font-size: 14px;
        }
    </style>
</head>
<body>

<!-- Top bar -->
<%
    model.User currentUser = (model.User) session.getAttribute("user");
%>

<div class="top-bar">
    <%
        if (currentUser == null) {
    %>
        <a href="login.jsp">Login</a>
        <a href="register.jsp">Register</a>
    <%
        } else {
    %>
        <img src="image/account.jpg" 
             alt="Avatar" 
             style="width:30px; height:30px; border-radius:50%; vertical-align:middle; margin-right:10px;">
        <a href="LogoutServlet" style="color:red;">Logout</a>
    <%
        }
    %>
</div>



<!-- Navigation -->
<nav>
    <div class="logo">CHIC THREADS</div>
    <ul>
        <li><a href="#">NEW ARRIVALS</a></li>
        <li><a href="#">WOMEN</a></li>
        <li><a href="#">MEN</a></li>
        <li><a href="#">ACCESSORIES</a></li>
        <li><a href="#">SALE</a></li>
    </ul>
    <div class="cart">3 items</div>
</nav>

<!-- Banner chạy ngang -->
<div class="banner">
    <div class="banner-track">
        <img src="image/model1.jpg" alt="Banner 1">
        <img src="image/model2.jpg" alt="Banner 2">
        <img src="image/model3.jpg" alt="Banner 3">
        <img src="image/model4.jpg" alt="Banner 4">
        <img src="image/model5.jpg" alt="Banner 5">
        <!-- Lặp lại để chạy mượt -->
        <img src="image/model1.jpg" alt="Banner 1">
        <img src="image/model2.jpg" alt="Banner 2">
        <img src="image/model3.jpg" alt="Banner 3">
        <img src="image/model4.jpg" alt="Banner 4">
        <img src="image/model5.jpg" alt="Banner 5">
    </div>
    <div class="search-bar">
        <input type="text" placeholder="Search">
        <button>🔍</button>
    </div>
</div>

<!-- Products -->
<div class="products">
    <div class="product">
        <img src="image/product1.jpg" alt="Product 1">
        <div class="product-name">Mall Frecalli Gown</div>
        <div class="price">$44.90</div>
        <button class="btn">Add to cart</button>
    </div>
    <div class="product">
        <img src="image/product2.jpg" alt="Product 2">
        <div class="product-name">Reagy Toorth</div>
        <div class="price">$28.90</div>
        <button class="btn">Add to cart</button>
    </div>
    <div class="product">
        <img src="image/product3.jpg" alt="Product 3">
        <div class="product-name">Noah Lind Sagas</div>
        <div class="price">$24.90</div>
        <button class="btn">Add to cart</button>
    </div>
    <div class="product">
        <img src="image/product4.jpg" alt="Product 4">
        <div class="product-name">Komen Still</div>
        <div class="price">$26.90</div>
        <button class="btn">Add to cart</button>
    </div>
    <div class="product">
        <img src="image/product5.jpg" alt="Product 5">
        <div class="product-name">Elegant Dress</div>
        <div class="price">$39.90</div>
        <button class="btn">Add to cart</button>
    </div>
</div>

<!-- Footer -->
<footer>
    CUSTOMER SERVICE | ABOUT US
</footer>

</body>
</html>
