<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>발주 전송 (확정 상태)</title>
</head>
<body>
    <h1>확정된(Y) 주문 목록</h1>
    <p>전송할 주문을 체크한 뒤 "전송하기"를 누르세요.</p>

    <form action="${pageContext.request.contextPath}/SsmOrdSnd/submit" method="post">
        <table border="1">
            <tr>
                <th>전송 체크</th>
                <th>Order ID</th>
                <th>Store ID</th>
                <th>Confirm Status</th>
                <th>Goods ID</th>
                <th>Quantity</th>
            </tr>
            <c:forEach var="row" items="${yList}">
                <tr>
                    <td>
                        <input type="checkbox" name="orderIds" value="${row.orderId}" />
                    </td>
                    <td>${row.orderId}</td>
                    <td>${row.storeId}</td>
                    <td>${row.orderConfirmStatus}</td>
                    <td>${row.goodsId}</td>
                    <td>${row.orderQuantity}</td>
                </tr>
            </c:forEach>
        </table>
        <br/>
        <input type="submit" value="전송하기" />
    </form>

    <hr/>
    <a href="${pageContext.request.contextPath}/SsmOrdGdoChk/list">← 돌아가기</a>
</body>
</html>
