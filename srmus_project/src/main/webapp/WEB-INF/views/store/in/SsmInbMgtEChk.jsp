<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>입고 예정내역</title>
</head>
<body>
    <h1>입고 예정내역</h1>

    <!-- 확정 및 재고 반영 폼 -->
    <form action="${pageContext.request.contextPath}/SsmInbMgtApr/confirmThenStock" method="post">
    <table border="1">
        <tr>
            <th>확정+재고 체크</th>
            <th>Inbound ID</th>
            <th>Store ID</th>
            <th>Goods ID</th>
            <th>Quantity</th>
            <th>Status</th>
            <th>EmployeeID</th>
            <th>ConfirmDate</th>
        </tr>
        <c:forEach var="row" items="${inboundList}">
        <tr>
            <td>
                <!-- Inbound ID만 전송 -->
                <input type="checkbox" name="inboundIds" value="${row.inboundId}" />
            </td>
            <td>${row.inboundId}</td>
            <td>${row.storeId}</td>
            <td>${row.goodsId}</td>
            <td>${row.inboundQuantity}</td>
            <td>${row.inboundConfirmStatus}</td>
            <td>
                <c:choose>
                    <c:when test="${empty row.employeeId}">-</c:when>
                    <c:otherwise>${row.employeeId}</c:otherwise>
                </c:choose>
            </td>
            <td>
                <c:choose>
                    <c:when test="${empty row.inboundConfirmDate}">-</c:when>
                    <c:otherwise>${row.inboundConfirmDate}</c:otherwise>
                </c:choose>
            </td>
        </tr>
        </c:forEach>
        <tr>
            <td colspan="8" style="text-align:center">
                <input type="submit" value="입고확정 + 재고반영" />
            </td>
        </tr>
    </table>
    </form>

    <hr/>

    <!-- 수정 기능 폼 -->
    <h2>수정</h2>
    <form action="${pageContext.request.contextPath}/SsmInbMgtChg/change" method="post">
        <label>Inbound ID:</label>
        <input type="text" name="inboundId" /><br/>
        <label>Goods ID:</label>
        <input type="text" name="goodsId" /><br/>
        <label>수량:</label>
        <input type="number" name="inboundQuantity" /><br/>
        <input type="submit" value="수정(CHG)" />
    </form>

    <hr/>
    <a href="${pageContext.request.contextPath}/SsmInbMgtChk/list">[확정 목록]</a>
</body>
</html>
