<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>발주 등록</title>
</head>
<body>
    <h1>발주 등록</h1>

    <form action="${pageContext.request.contextPath}/SsmOrdGdoReg/reg" method="post">
        <label>상품 ID: </label>
        <input type="text" name="goodsId" />
        <br>

        <label>수량: </label>
        <input type="number" name="orderQuantity" />
        <br>

        <input type="submit" value="등록" />
    </form>

</body>
</html>
