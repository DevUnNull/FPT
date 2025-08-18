<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8" />
    <title>Giỏ hàng</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <style>
        body { font-family: system-ui, -apple-system, Segoe UI, Roboto, Arial, sans-serif; margin: 24px; }
        .container { max-width: 1040px; margin: 0 auto; }
        h1 { margin-bottom: 16px; }
        .actions { display: flex; gap: 12px; margin-top: 16px; }
        .btn { padding: 10px 14px; border: 1px solid #ddd; background: #f7f7f7; cursor: pointer; border-radius: 8px; }
        .btn.primary { background: #0d6efd; color: #fff; border-color: #0d6efd; }
        .btn.danger { background: #dc3545; color: #fff; border-color: #dc3545; }
        .btn:disabled { opacity: .6; cursor: not-allowed; }
        table { width: 100%; border-collapse: collapse; margin-top: 12px; }
        th, td { padding: 12px; border-bottom: 1px solid #eee; text-align: left; vertical-align: middle; }
        th { background: #fafafa; }
        tfoot td { font-weight: 600; }
        .qty-input { width: 80px; padding: 6px; }
        .row-actions { display: flex; gap: 8px; align-items: center; }
        .empty { background: #fff5d6; border: 1px solid #ffe49d; padding: 14px; border-radius: 8px; }
        .right { text-align: right; }
        .price { white-space: nowrap; }
        .msg { margin: 10px 0; color: #0a7; }
    </style>
</head>
<body>
<div class="container">

    <h1>Giỏ hàng của bạn</h1>

    <!-- Hiển thị thông báo đơn giản qua query param, ví dụ: ?msg=added -->
    <c:if test="${not empty param.msg}">
        <div class="msg">
            <c:choose>
                <c:when test="${param.msg == 'added'}">Đã thêm sản phẩm vào giỏ.</c:when>
                <c:when test="${param.msg == 'updated'}">Đã cập nhật số lượng.</c:when>
                <c:when test="${param.msg == 'removed'}">Đã xóa sản phẩm khỏi giỏ.</c:when>
                <c:otherwise>${param.msg}</c:otherwise>
            </c:choose>
        </div>
    </c:if>

    <c:choose>
        <c:when test="${empty sessionScope.cart || empty sessionScope.cart.items}">
            <div class="empty">
                Giỏ hàng đang trống. <a href="<c:url value='/home.jsp'/>">Tiếp tục mua sắm</a>.
            </div>
        </c:when>

        <c:otherwise>
            <table>
                <thead>
                    <tr>
                        <th>Sản phẩm</th>
                        <th class="right">Đơn giá</th>
                        <th class="right">Số lượng</th>
                        <th class="right">Thành tiền</th>
                        <th>Thao tác</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${sessionScope.cart.items}">
                        <tr>
                            <td>
                                <strong>${item.productName}</strong><br/>
                                <small>Mã: ${item.productId}</small>
                            </td>

                            <td class="right price">
                                <fmt:formatNumber value="${item.price}" type="currency" currencySymbol="₫" maxFractionDigits="0"/>
                            </td>

                            <td class="right">
                                <!-- Form cập nhật số lượng cho từng dòng -->
                                <form action="<c:url value='/UpdateProductFromCart'/>" method="post" class="row-actions">
                                    <input type="hidden" name="productId" value="${item.productId}" />
                                    <input class="qty-input" type="number" min="1" name="quantity" value="${item.quantity}" required />
                                    <button type="submit" class="btn">Cập nhật</button>
                                </form>
                            </td>

                            <td class="right price">
                                <fmt:formatNumber value="${item.price * item.quantity}" type="currency" currencySymbol="₫" maxFractionDigits="0"/>
                            </td>

                            <td>
                                <!-- Form xóa sản phẩm -->
                                <form action="<c:url value='/RemoveProductFromCart'/>" method="post" onsubmit="return confirm('Xóa sản phẩm này khỏi giỏ?');">
                                    <input type="hidden" name="productId" value="${item.productId}" />
                                    <button type="submit" class="btn danger">Xóa</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>

                <tfoot>
                    <tr>
                        <td colspan="3" class="right">Tạm tính</td>
                        <td class="right price">
                            <fmt:formatNumber value="${sessionScope.cart.total}" type="currency" currencySymbol="₫" maxFractionDigits="0"/>
                        </td>
                        <td></td>
                    </tr>
                </tfoot>
            </table>

            <div  class="actions">
                <a class="btn" href="<c:url value='/home.jsp'/>">Tiếp tục mua sắm</a>
                <form action="<c:url value='/CheckoutServlet'/>" method="get">
                    <button type="submit" class="btn primary">Tiến hành thanh toán</button>
                </form>
            </div>
        </c:otherwise>
    </c:choose>
</div>

<script>
    // Chặn số lượng không hợp lệ
    document.querySelectorAll('.qty-input').forEach(function (el) {
        el.addEventListener('change', function () {
            if (this.value < 1) this.value = 1;
        });
    });
</script>

</body>
</html>
