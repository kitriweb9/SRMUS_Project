<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>본부 수주내역 조회</title>

</head>
<body>
	<jsp:include page="/WEB-INF/views/includes/common.jsp" />
	<jsp:include page="/WEB-INF/views/includes/header.jsp" />
	<div class="d-flex">
		<jsp:include page="/WEB-INF/views/includes/sidebar.jsp" />
		<div class="main-content p-4">
			<div class="container-fluid px-0">
				<div class="col-9">
					<h3>수주 목록</h3>
					<form action="${pageContext.request.contextPath}/searchorders" method="post">
					
						수주 번호
						<input type="text" name="orderId" /> 상품명 <input type="text" name="goodsName" />
						<button type="submit">주문 등록</button>
						<br />
						<br />
						<br />
					</form>
					<c:if test="${not empty ordersList}">
						<table class="table table-bordered project-table align-middle">
							<thead class="table-light">
								<tr>
									<th>주문 번호</th>
									<th>매장명</th>
									<th>직원명</th>
									<th>상품 카테고리</th>
									<th>상품명</th>
									<th>수량</th>
									<th>상태</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="order" items="${ordersList}">
									<tr>
										<td>${order.orderId}</td>
										<td>${order.storeName}</td>
										<td>${order.employeeName}</td>
										<td>${order.goodsCategoryName}</td>
										<td>${order.goodsName}</td>
										<td>${order.orderQuantity}</td>
										<td>${order.orderConfirmStatus}</td>
										<td><c:if test="${order.orderConfirmStatus == '수주'}">
												<form
													action="${pageContext.request.contextPath}/integrationorder"
													method="post">
													<input type="hidden" name="orderId"
														value="${order.orderId}">
													<button type="submit">발주</button>
												</form>
											</c:if></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:if>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/includes/footer.jsp" />
</body>
</html>