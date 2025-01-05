<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>입고 예정내역</title>
</head>
<body>
    <jsp:include page="includes/common.jsp" />
    <jsp:include page="includes/header.jsp" />
    <div class="d-flex">
        <jsp:include page="includes/sidebar.jsp" />
        <div class="main-content p-4">
            <div class="container-fluid px-0">
                <div class="my-3">
                    <h4>입고 예정내역</h4>
                </div>

                <!-- 확정 및 재고 반영 폼 -->
                <form action="${pageContext.request.contextPath}/SsmInbMgtApr/confirmThenStock" method="post">
                    <div class="card p-3">
                        <table class="table table-bordered align-middle">
                            <thead class="table-light">
                                <tr>
                                    <th>확정+재고 체크</th>
                                    <th>Inbound ID</th>
                                    <th>Store ID</th>
                                    <th>Goods ID</th>
                                    <th>Quantity</th>
                                    <th>Status</th>
                                    <th>Employee ID</th>
                                    <th>Confirm Date</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="row" items="${inboundList}">
                                    <tr>
                                        <td>
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
                            </tbody>
                        </table>
                        <div class="mt-3 text-center">
                            <input type="submit" class="btn btn-primary" value="입고확정 + 재고반영" />
                        </div>
                    </div>
                </form>

                <div class="card p-3 mt-4">
                    <h5>수정</h5>
                    <form action="${pageContext.request.contextPath}/SsmInbMgtChg/change" method="post">
                        <div class="mb-3">
                            <label for="inboundId" class="form-label">Inbound ID:</label>
                            <input type="text" class="form-control" id="inboundId" name="inboundId" />
                        </div>
                        <div class="mb-3">
                            <label for="goodsId" class="form-label">Goods ID:</label>
                            <input type="text" class="form-control" id="goodsId" name="goodsId" />
                        </div>
                        <div class="mb-3">
                            <label for="inboundQuantity" class="form-label">수량:</label>
                            <input type="number" class="form-control" id="inboundQuantity" name="inboundQuantity" />
                        </div>
                        <div class="text-center">
                            <input type="submit" class="btn btn-secondary" value="수정(CHG)" />
                        </div>
                    </form>
                </div>

                <div class="mt-4 text-end">
                    <a href="${pageContext.request.contextPath}/SsmInbMgtChk/list" class="btn btn-link">[확정 목록]</a>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="includes/footer.jsp" />
</body>
</html>