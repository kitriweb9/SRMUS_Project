<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>재고 조회 및 수정</title>
</head>
<body>
    <h1>재고 조회 및 수정</h1>

    <!-- 재고 목록 테이블 -->
    <table border="1">
        <tr>
            <th>Goods ID</th>
            <th>Store ID</th>
            <th>Stock Quantity</th>
            <th>Safety Quantity</th>
        </tr>
        <c:forEach var="stock" items="${stockList}">
            <tr>
                <td>${stock.goodsId}</td>
                <td>${stock.storeId}</td>
                <td>${stock.stockQuantity}</td>
                <td>${stock.stockSafetyQuantity}</td>
            </tr>
        </c:forEach>
    </table>

    <hr/>

    <!-- 재고 수정 폼 -->
    <h2>재고 수정</h2>
    <form action="${pageContext.request.contextPath}/SsmStkMgtChg/update" method="post">
        <label for="goodsId">Goods ID:</label>
        <input type="text" id="goodsId" name="goodsId" required />
        <br/>

        <label for="storeId">Store ID:</label>
        <input type="text" id="storeId" name="storeId" required />
        <br/>

        <label for="stockQuantity">Stock Quantity:</label>
        <input type="number" id="stockQuantity" name="stockQuantity" min="0" required />
        <br/>

        <label for="stockSafetyQuantity">Safety Quantity:</label>
        <input type="number" id="stockSafetyQuantity" name="stockSafetyQuantity" min="0" required />
        <br/>

        <input type="submit" value="재고 수정" />
    </form>

    <hr/>
</body>
</html>
