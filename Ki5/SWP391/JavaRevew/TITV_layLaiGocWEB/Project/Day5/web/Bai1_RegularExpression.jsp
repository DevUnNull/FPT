<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test Regular Expression</title>
</head>
<body>
    <h2>🔍 Test ký hiệu Regex</h2>

    <form action="regexTestServlet" method="post">
        <label>Nhập chuỗi:</label><br>
        <input type="text" name="input" required/><br><br>

        <label>Chọn ký hiệu Regex:</label><br>
        <select name="regexSymbol">
            <option value="\d">\d – chữ số (0-9)</option>
            <option value="\d+">\d+ – nhiều chữ số</option>
            <option value="\D">\D – không phải số</option>
            <option value="\w">\w – ký tự chữ/số/_</option>
            <option value="\w+">\w+ – nhiều ký tự</option>
            <option value="\W">\W – không phải \w</option>
            <option value="\s">\s – khoảng trắng</option>
            <option value="\S">\S – không phải khoảng trắng</option>
            <option value="^a">^a – bắt đầu bằng 'a'</option>
            <option value="a$">a$ – kết thúc bằng 'a'</option>
            <option value="[abc]">[abc] – là a, b hoặc c</option>
            <option value="[^0-9]">[^0-9] – không phải số</option>
            <option value="(ha)+">(ha)+ – nhóm 'ha' lặp lại</option>
            <option value="cat|dog">cat|dog – cat hoặc dog</option>
            <option value="\bcat\b">\bcat\b – từ cat độc lập</option>
            <option value="\Bcat\B">\Bcat\B – cat không độc lập</option>
            <option value="Gmail">Gmail – Nhập đúng Form gmail</option>
            <option value="SDT">SĐT – Nhập đúng Form số điện thoại của Việt Nam</option>
        </select><br><br>
        
        <input type="submit" value="Kiểm tra"/>
    </form>
</body>
</html>
