<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>확정된 입고내역</title>
</head>
<body>
	<!-- 공통 요소 포함 -->
	<jsp:include page="/WEB-INF/views/includes2/common.jsp" />
	<jsp:include page="/WEB-INF/views/includes2/header.jsp" />

	<div class="d-flex">
		<!-- 사이드바 포함 -->
		<jsp:include page="/WEB-INF/views/includes2/sidebar.jsp" />

		<div class="main-content p-4">
			<div class="container-fluid px-0">
				<h1>확정된 입고내역</h1>
				<div class="table-responsive mt-3">
					<table class="table table-bordered align-middle">
						<thead class="table-light">
							<tr>
								<th>Inbound ID</th>
								<th>Store ID</th>
								<th>Inbound Date</th>
								<th>Confirm Date</th>
								<th>Goods ID</th>
								<th>Quantity</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="row" items="${confirmedList}">
								<tr>
<%-- 									<td>
										<input type="checkbox" name="inboundIds" value="${row.inboundId}" />
										<input type="hidden" name="goodsIds" value="${row.goodsId}" />
										<input type="hidden" name="inboundQuantities" value="${row.inboundQuantity}" />
									</td> --%>
									<td>${row.inboundId}</td>
									<td>${row.storeId}</td>
									<td>${row.inboundDate}</td>
									<td>${row.inboundConfirmDate}</td>
									<td>${row.goodsId}</td>
									<td>${row.inboundQuantity}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<hr />
			</div>
		</div>
	</div>

	<!-- 푸터 포함 -->
	<jsp:include page="/WEB-INF/views/includes2/footer.jsp" />
</body>
</html>
