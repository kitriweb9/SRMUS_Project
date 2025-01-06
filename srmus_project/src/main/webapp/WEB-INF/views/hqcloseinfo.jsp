<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>본부 마감 내역</title>
	<jsp:include page="includes/common.jsp" />
</head>
<body>
	<jsp:include page="includes/header.jsp" />
	<div class="d-flex">
		<jsp:include page="includes/sidebar.jsp" />
		<div class="main-content p-4">
			<div class="container-fluid px-0">
				<div class="col-12">
					<h2>본부 마감 내역</h2>

					<!-- 본부 마감 테이블 -->
					<table class="table table-striped">
						<thead>
							<tr>
								<th>마감 ID</th>
								<th>마감 날짜</th>
								<th>마감 금액</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="closing" items="${hqClosingList}">
								<tr id="row-${closing.hqClosingId}">
									<td>${closing.hqClosingId}</td>
									<td>${closing.hqClosingDate}</td>
									<td><fmt:formatNumber value="${closing.hqClosingAmount}" pattern="#,###" />원</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="includes/footer.jsp" />
</body>
</html>
