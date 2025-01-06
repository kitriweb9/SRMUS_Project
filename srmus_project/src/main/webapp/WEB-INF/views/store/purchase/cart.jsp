<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>장바구니</title>
</head>
<body>
    <jsp:include page="/WEB-INF/views/includes2/common.jsp" />
    <jsp:include page="/WEB-INF/views/includes2/header.jsp" />
    <div class="d-flex">
        <jsp:include page="/WEB-INF/views/includes2/sidebar.jsp" />
        <div class="main-content p-4">
            <div class="container-fluid px-0">
                <div class="my-3">
                    <h4>장바구니</h4>
                    <div class="text-muted">
                        <small><i class="bi bi-cart me-1"></i> 내가 담은 상품 목록</small>
                    </div>
                </div>
                <div class="dashboard-cards mb-4">
                    <div class="card p-3">
                        <form name="updatecart" method="post" action="${pageContext.request.contextPath}/modi">
                            <table class="table table-bordered align-middle">
                                <thead class="table-light">
                                    <tr>
                                        <th>상품명</th>
                                        <th>수량</th>
                                        <th>가격</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="pdlist" items="${pdlist}">
                                        <tr>
                                            <td>${pdlist.goodsName}</td>
                                            <td>${pdlist.purchaseQuantity}</td>
                                            <td>${pdlist.purchaseQuantity * pdlist.goodsPrice}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <input type="hidden" name="purchaseId" value="${purchaseId}">
                            <input type="hidden" name="customerId" value="${customerId}">
<!--                             <div class="mt-3 text-end">
                                <button type="submit" class="btn btn-sm btn-outline-primary">수량 변경</button>
                                <button type="button" class="btn btn-sm btn-outline-danger">장바구니 비우기</button>
                            </div> -->
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="/WEB-INF/views/includes2/footer.jsp" />
</body>
</html>
