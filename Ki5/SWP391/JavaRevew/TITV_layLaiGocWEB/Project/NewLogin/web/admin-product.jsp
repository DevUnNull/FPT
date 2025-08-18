<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Product Management</title>
    <style>
        body { font-family: Arial; margin: 20px; background: #f1f2f6; }
        h2 { margin-bottom: 20px; }
        .section { background: white; padding: 20px; border-radius: 8px; box-shadow: 0 2px 6px rgba(0,0,0,0.1); margin-bottom: 30px; }
        .form-group { margin-bottom: 15px; }
        label { display: block; font-weight: bold; }
        input, select, textarea { width: 100%; padding: 8px; border: 1px solid #ccc; border-radius: 5px; }
        button { background: #2f3542; color: white; border: none; padding: 10px 15px; border-radius: 5px; cursor: pointer; }
        table { width: 100%; border-collapse: collapse; }
        table th, table td { padding: 10px; border: 1px solid #ddd; text-align: left; }
        .actions button { margin-right: 5px; background: #1e90ff; }
        .actions .delete { background: #e74c3c; }
        img { border-radius: 4px; }
    </style>
</head>
<body>

<h2>Product Management</h2>

<!-- Add/Edit Product Form -->
<div class="section">
    <h3>Add or Edit Product</h3>
    <form action="ProductAddServlet" method="post">
        <input type="hidden" name="action" value="save"/>
        <input type="hidden" name="product_id" value="${product.productId}" />

        <div class="form-group">
            <label>Product Name</label>
            <input type="text" name="name" value="${product.name}">
        </div>
        <div class="form-group">
            <label>Description</label>
            <textarea name="description" rows="3">${product.description}</textarea>
        </div>
        <div class="form-group">
            <label>Price</label>
            <input type="number" step="0.01" name="price" value="${product.price}">
        </div>
        <div class="form-group">
            <label>Stock Quantity</label>
            <input type="number" name="stock_quantity" value="${product.stockQuantity}">
        </div>
        <div class="form-group">
            <label>Category</label>
            
            <select name="category_name" required>
                <c:forEach var="cat" items="${categoryList}">
                  <option value="${cat.categoryName}"
                    <c:if test="${cat.categoryId == product.categoryId}">selected</c:if>>
                    ${cat.categoryName}
                  </option>
                </c:forEach>
            </select>

        </div>
        <div class="form-group">
            <label>Image URL</label>
            <input type="text" name="image_url" value="${product.imageUrl}">
        </div>
        <button type="submit">Save Product</button>
    </form>
</div>

<!-- Product List Table -->
<div class="section">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty sessionScope.msg}">
    <div style="padding: 10px; background: #d4edda; color: #155724; border: 1px solid #c3e6cb; margin-bottom: 15px;">
        ${sessionScope.msg}
    </div>
    <c:remove var="msg" scope="session" />
</c:if>

<c:if test="${not empty sessionScope.err}">
    <div style="padding: 10px; background: #f8d7da; color: #721c24; border: 1px solid #f5c6cb; margin-bottom: 15px;">
        ${sessionScope.err}
    </div>
    <c:remove var="err" scope="session" />
</c:if>
        <h3>All Products</h3>
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Stock</th>
                <th>Category</th>
                <th>Image</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="p" items="${productList}">
                <tr>
                    <td>${p.productId}</td>
                    <td>${p.name}</td>
                    <td>$${p.price}</td>
                    <td>${p.stockQuantity}</td>
                    <td>${p.categoryName}</td>
                    <td>
                        <img src="${p.imageUrl}" width="40" height="40" alt="product">
                    </td>
                    <td class="actions">
                        <form action="product" method="get" style="display:inline;">
                            <input type="hidden" name="action" value="edit">
                            <input type="hidden" name="id" value="${p.productId}">
                            <button type="submit">Edit</button>
                        </form>
                        <form action="ProductDeleteServlet" method="post" style="display:inline;">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="id" value="${p.productId}">
                            <button type="submit" class="delete">Delete</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    
</div>

<!-- Category Management -->
<div class="section">
    <h3>Manage Categories</h3>
    <form action="CategoryAddServlet" method="post">
        <div class="form-group">
            <label>Category Name</label>
            <input type="text" name="category_name">
        </div>
        <div class="form-group">
            <label>Description</label>
            <textarea name="description" rows="2"></textarea>
        </div>
        <button type="submit">Save Category</button>
    </form>
</div>

</body>
</html>
