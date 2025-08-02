<%-- 
    Document   : Bai1_BuyComputer
    Created on : Jul 13, 2025, 9:02:13 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Chọn máy tính</title>
    </head>
    <body>
        <h2>Chọn cấu hình máy tính bạn cần mua</h2>

        <form action="Bai2_BuyComputer.jsp" method="get">
            <fieldset>
                <legend><strong>Processor</strong></legend>
                <input type="radio" name="cpu" value="Core i9" id="i9">
                <label for="i9">Core I9</label><br>

                <input type="radio" name="cpu" value="Core i7" id="i7">
                <label for="i7">Core I7</label><br>

                <input type="radio" name="cpu" value="Core i5" id="i5">
                <label for="i5">Core I5</label><br>
            </fieldset>

            <br>

            <fieldset>
                <legend><strong>RAM</strong></legend>
                <input type="radio" name="ram" value="8GB" id="ram8">
                <label for="ram8">Ram 8GB</label><br>

                <input type="radio" name="ram" value="16GB" id="ram16">
                <label for="ram16">Ram 16GB</label><br> <%--for ở đây có tác dụng là nó sẽ liên kết chữ Ram 16GB đến với radio 16GB--%>
            </fieldset>

            <br>

            <fieldset>
                <legend><strong>Monitor</strong></legend>
                <input type="checkbox" name="monitor" value="Monitor" id="monitor">
                <label for="monitor">Monitor</label>
            </fieldset>

            <br>

            <fieldset>
                <legend><strong>Accessories</strong></legend>
                <select name="accessories" size="3" multiple>
                    <option value="Camera">Camera</option>
                    <option value="Printer">Printer</option>
                    <option value="Scanner">Scanner</option>
                </select>
            </fieldset>

            <br>
            <input type="submit" value="Buy">
        </form>

        <%
            String cpu = request.getParameter("cpu");
            String ram = request.getParameter("ram");
            String monitor = request.getParameter("monitor");
            String[] accessories = request.getParameterValues("accessories");

            int tongTien = 0;
            if(cpu!=null){
                if(cpu.equals("Core i9")){ // như ở đây thì value có tác dụng là xác định xem cpu có phải là cỏe i9 hay không sau khi mình submit
                    tongTien += 300;
                }else if(cpu.equals("Core i7")){
                    tongTien += 200;
                }else if(cpu.equals("Core i5")){
                    tongTien += 100;
                }
            }
            
            if(ram!=null){
                if(ram.equals("8GB")){
                    tongTien += 400;
                }else if(ram.equals("16GB")){
                    tongTien += 800;
                }
            }
            
            if(monitor!=null){
                tongTien += 1000;
            }
            if (accessories != null) {
                for (String acc : accessories) {
                    if (acc.equals("Camera")) {
                        tongTien += 500;
                    } else if (acc.equals("Printer")) {
                        tongTien += 300;
                    } else if (acc.equals("Scanner")) {
                        tongTien += 200;
                    }
                }
            }

            
            if (cpu != null || ram != null || monitor != null || accessories != null) {
        %>
            <hr>
            <h3>Bạn đã chọn:</h3>
            <ul>
                <% if (cpu != null) { %>
                    <li>CPU: <strong><%= cpu %></strong></li>
                <% } %>
                <% if (ram != null) { %>
                    <li>RAM: <strong><%= ram %></strong></li>
                <% } %>
                <% if (monitor != null) { %>
                    <li>Monitor: <strong>Yes</strong></li>
                <% } %>
                <% if (accessories != null) { %>
                    <li>Accessories:
                        <ul>
                        <% for (String acc : accessories) { %>
                            <li><%= acc %></li>
                        <% } %>
                        </ul>
                    </li>
                <% } %>
            </ul>
        <%
            }
        %>
        vậy tổng bill của bạn hết <%= tongTien%>k.
    </body>
</html>
