<%@page import="java.util.List"%>
<%@page import="model.HocSinh"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Danh sách Học Sinh</title>
    <style>
        table {
            width: 50%;
            border-collapse: collapse;
            margin: 20px 0;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h2>Danh sách Học Sinh</h2>
    <table>
        <tr>
            <th>Tên</th>
            <th>Tuổi</th>
            <th>Lớp</th>
        </tr>
        <%
            List<HocSinh> hocSinhList = (List<HocSinh>) request.getAttribute("hocSinhList");
            if (hocSinhList != null) {
                for (HocSinh hs : hocSinhList) {
        %>
        <tr>
            <td><%=hs.getTen()%></td>
            <td><%=hs.getTuoi()%></td>
            <td><%=hs.getLop()%></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="3">Không có dữ liệu.</td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>