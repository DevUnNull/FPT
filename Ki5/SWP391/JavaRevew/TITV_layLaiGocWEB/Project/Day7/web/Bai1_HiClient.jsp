<%@ page contentType="text/html;charset=UTF-8" %>
<%
    String name = (String) session.getAttribute("CreateUserName");
%>
<h1>Hello <%= name %>!</h1>
