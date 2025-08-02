<%-- 
    Document   : Bai2_index
    Created on : Jul 12, 2025, 3:35:55 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Client!</h1>
        <%
            String soLuong =   request.getParameter("quantity"); 
            String hoVaTen =  request.getParameter("fullname");
            String email =  request.getParameter("email");
            int tongTien = 0;
            try {
                int soLuongSo = Integer.parseInt(soLuong);
                tongTien = soLuongSo * 2;
            } catch (Exception e) {
                out.println("Có vẻ bạn chưa đặt sản phẩm nào!");
            }
        %>
        Vậy tên bạn <%= hoVaTen%> đã đặt <%= soLuong%> sản phẩm.Bằng Email <%= email%> . Và tổng tiền bạn cần trả là <%= tongTien%>k
    </body>
</html>
