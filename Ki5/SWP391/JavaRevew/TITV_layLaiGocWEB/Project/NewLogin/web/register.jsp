<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>Register</title>
  <style>
    body{font-family:Arial;margin:0;background:#f6f7fb}
    .wrap{max-width:720px;margin:40px auto;background:#fff;padding:24px;border-radius:10px;box-shadow:0 6px 20px rgba(0,0,0,.06)}
    .grid{display:grid;grid-template-columns:1fr 1fr;gap:12px}
    .grid-1{grid-template-columns:1fr}
    label{display:block;font-weight:bold;margin:8px 0 4px}
    input{width:100%;padding:10px;border:1px solid #ddd;border-radius:8px}
    button{padding:12px 18px;border:0;border-radius:8px;background:#2f6fed;color:#fff;cursor:pointer}
    .err{background:#fde2e2;color:#7a1c1c;padding:10px;border-radius:6px;margin-bottom:12px}
    .msg{background:#e6f7ed;color:#145c36;padding:10px;border-radius:6px;margin-bottom:12px}
  </style>
</head>
<body>
<div class="wrap">
  <h2>Tạo tài khoản</h2>

  <c:if test="${not empty sessionScope.err}">
    <div class="err">${sessionScope.err}</div>
    <c:remove var="err" scope="session"/>
  </c:if>
  <c:if test="${not empty sessionScope.msg}">
    <div class="msg">${sessionScope.msg}</div>
    <c:remove var="msg" scope="session"/>
  </c:if>

  <form action="${pageContext.request.contextPath}/RegisterServlet" method="post" class="grid grid-1">
    <div class="grid">
      <div>
        <label>Username</label>
        <input name="username" required minlength="3" maxlength="50">
      </div>
      <div>
        <label>Họ tên</label>
        <input name="full_name" required maxlength="120">
      </div>
    </div>

    <div class="grid">
      <div>
        <label>Email</label>
        <input type="email" name="email" required>
      </div>
      <div>
        <label>Mật khẩu</label>
        <input type="password" name="password" required minlength="6">
      </div>
    </div>

    <div class="grid">
      <div>
        <label>Nhập lại mật khẩu</label>
        <input type="password" name="confirm_password" required minlength="6">
      </div>
      <div>
        <label>Trạng thái</label>
        <input name="status" value="ACTIVE" readonly>
      </div>
    </div>

    <h3>Địa chỉ giao hàng (tùy chọn)</h3>
    <div class="grid">
      <div>
        <label>Tên người nhận</label>
        <input name="recipient_name">
      </div>
      <div>
        <label>Điện thoại</label>
        <input name="phone">
      </div>
    </div>
    <div class="grid">
      <div>
        <label>Địa chỉ</label>
        <input name="address_detail">
      </div>
      <div>
        <label>Thành phố</label>
        <input name="city">
      </div>
    </div>
    <div class="grid">
      <div>
        <label>Mã bưu chính</label>
        <input name="postal_code">
      </div>
    </div>

    <button type="submit">Đăng ký</button>
  </form>
</div>
</body>
</html>
