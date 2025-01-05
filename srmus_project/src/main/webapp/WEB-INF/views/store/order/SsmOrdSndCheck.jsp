<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>발주 전송</title>
</head>
<body>
    <!-- 공통 헤더 포함 -->
    <jsp:include page="/WEB-INF/views/includes2/common.jsp" />
    <jsp:include page="/WEB-INF/views/includes2/header.jsp" />

    <div class="d-flex">
        <!-- 사이드바 포함 -->
        <jsp:include page="/WEB-INF/views/includes2/sidebar.jsp" />

        <div class="main-content p-4">
            <h1>발주 확정 목록</h1>
            <p>전송할 주문을 체크한 뒤 "전송하기"를 누르세요.</p>

            <form action="${pageContext.request.contextPath}/SsmOrdSnd/submit" method="post">
                <table class="table table-bordered">
                    <thead class="table-light">
                        <tr>
                            <th>전송 체크</th>
                            <th>Order ID</th>
                            <th>Store ID</th>
                            <th>Confirm Status</th>
                            <th>Goods ID</th>
                            <th>Quantity</th>
                        </tr>
                    </thead>
                    <tbody>
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
                    </tbody>
                </table>
                <div class="mt-3">
                    <input type="submit" value="전송하기" class="btn btn-primary" />
                </div>
            </form>

            <hr/>
        </div>
    </div>

    <!-- 공통 푸터 포함 -->
    <jsp:include page="/WEB-INF/views/includes2/footer.jsp" />
</body>
</html>
