<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>확정된 입고</title>
</head>
<body>
    <h1>확정된 입고내역</h1>

<%--     <form action="${pageContext.request.contextPath}/SsmInbMgtApy/apply" method="post"> --%>
    <table border="1">
        <tr>
            <th>재고 반영</th>
            <th>Inbound ID</th>
            <th>Store ID</th>
            <th>Inbound Date</th>
            <th>Confirm Date</th>
            <th>Goods ID</th>
            <th>Quantity</th>
        </tr>
        <c:forEach var="row" items="${confirmedList}">
        <tr>
            <td>
                <input type="checkbox" name="inboundIds" value="${row.inboundId}" />
                <input type="hidden" name="goodsIds" value="${row.goodsId}" />
                <input type="hidden" name="inboundQuantities" value="${row.inboundQuantity}" />
            </td>
            <td>${row.inboundId}</td>
            <td>${row.storeId}</td>
            <td>${row.inboundDate}</td>
            <td>${row.inboundConfirmDate}</td>
            <td>${row.goodsId}</td>
            <td>${row.inboundQuantity}</td>
        </tr>
        </c:forEach>
<!--         <tr>
            <td colspan="7" style="text-align:center">
                <input type="submit" value="재고 반영(APY)" />
            </td>
        </tr> -->
    </table>
<!--     </form> -->

    <hr/>
    <a href="${pageContext.request.contextPath}/SsmInbMgtEChk/list">[예정 내역(EChk)]</a>
</body>
</html>
