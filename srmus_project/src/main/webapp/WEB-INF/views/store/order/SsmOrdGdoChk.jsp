<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>발주 목록</title>
</head>
<body>
    <!-- 공통 헤더 포함 -->
    <jsp:include page="/WEB-INF/views/includes2/common.jsp" />
    <jsp:include page="/WEB-INF/views/includes2/header.jsp" />

    <div class="d-flex">
        <!-- 사이드바 포함 -->
        <jsp:include page="/WEB-INF/views/includes2/sidebar.jsp" />

        <div class="main-content p-4">
            <h1>발주 목록</h1>

            <!-- 발주 목록 테이블 -->
            <table class="table table-bordered">
                <thead class="table-light">
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
                </thead>
                <form action="${pageContext.request.contextPath}/SsmOrdGdoApr/confirm" method="post">
                    <tbody>
                        <c:forEach var="row" items="${orderList}">
                            <tr>
                                <td>
                                    <input type="checkbox" name="orderIds" value="${row.orderId}" />
                                </td>
                                <td>${row.orderId}</td>
                                <td>${row.storeId}</td>
                                <td>${row.orderRegisterDate}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${empty row.orderConfirmDate}">-</c:when>
                                        <c:otherwise>${row.orderConfirmDate}</c:otherwise>
                                    </c:choose>
                                </td>
                                <td>${row.orderConfirmStatus}</td>
                                <td>${row.goodsId}</td>
                                <td>${row.orderQuantity}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                    <tfoot>
                        <tr>
                            <td colspan="8" class="text-center">
                                <input type="submit" value="체크된 주문 확정" class="btn btn-primary" />
                            </td>
                        </tr>
                    </tfoot>
                </form>
            </table>

            <hr/>

            <!-- 발주 변경 폼 -->
            <h2>발주 변경</h2>
            <form action="${pageContext.request.contextPath}/SsmOrdGdoChg/change" method="post" class="form-inline">
                <div class="mb-3">
                    <label for="orderId" class="form-label">Order ID:</label>
                    <input type="text" id="orderId" name="orderId" class="form-control" />
                </div>
                <div class="mb-3">
                    <label for="goodsId" class="form-label">Goods ID:</label>
                    <input type="text" id="goodsId" name="goodsId" class="form-control" />
                </div>
                <div class="mb-3">
                    <label for="orderQuantity" class="form-label">수정 수량(0이면 삭제):</label>
                    <input type="number" id="orderQuantity" name="orderQuantity" class="form-control" />
                </div>
                <input type="submit" value="변경" class="btn btn-warning" />
            </form>

            <hr/>
        </div>
    </div>

    <!-- 공통 푸터 포함 -->
    <jsp:include page="/WEB-INF/views/includes2/footer.jsp" />
</body>
</html>
