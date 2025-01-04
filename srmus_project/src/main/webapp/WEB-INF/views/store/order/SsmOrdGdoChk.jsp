<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>발주 목록</title>
</head>
<body>
    <h1>발주 목록</h1>

    <table border="1">
        <tr>
            <th>확정 체크</th>
            <th>Order ID</th>
            <th>Store ID</th>
            <th>Register Date</th>
            <th>Confirm Date</th>
            <th>Status</th>
            <th>Goods ID</th>
            <th>Quantity</th>
        </tr>

        <!-- 확정 처리 폼 -->
        <form action="${pageContext.request.contextPath}/SsmOrdGdoApr/confirm" method="post">
        <c:forEach var="row" items="${orderList}">
            <tr>
                <td>
                    <!-- 여러 줄에 동일 orderId가 나올 수 있음(상품이 여러 건인 경우) -->
                    <input type="checkbox" name="orderIds" value="${row.orderId}" />
                </td>
                <td>${row.orderId}</td>
                <td>${row.storeId}</td>
                <td>${row.orderRegisterDate}</td>
                <td>${row.orderConfirmDate}</td>
                <td>${row.orderConfirmStatus}</td>
                <td>${row.goodsId}</td>
                <td>${row.orderQuantity}</td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="8" style="text-align:center">
                <input type="submit" value="체크된 주문 확정" />
            </td>
        </tr>
        </form>
    </table>

    <hr/>

    <h2>발주 변경</h2>
    <!-- 발주 변경 폼 -->
    <form action="${pageContext.request.contextPath}/SsmOrdGdoChg/change" method="post">
        <label>Order ID: </label>
        <input type="text" name="orderId" />
        <br>

        <label>Goods ID: </label>
        <input type="text" name="goodsId" />
        <br>

        <label>수정 수량(0이면 삭제): </label>
        <input type="number" name="orderQuantity" />
        <br>

        <input type="submit" value="변경" />
    </form>

    <br/>
    <!-- 등록 페이지로 이동 -->
    <a href="${pageContext.request.contextPath}/SsmOrdGdoReg/reg">
        발주 등록하기
    </a>
    <br>
    <a href="${pageContext.request.contextPath}/SsmOrdSnd/beforeSend">
    발주 전송하기
</a>

</body>
</html>
