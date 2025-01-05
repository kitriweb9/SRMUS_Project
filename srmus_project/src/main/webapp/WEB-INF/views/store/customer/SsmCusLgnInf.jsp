<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>고객 정보</title>
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
				<h4 class="my-3">고객 정보</h4>
				<div class="card p-3 mb-4">
					<h5>기본 정보</h5>
					<div class="table-responsive mt-3">
						<table class="table table-bordered align-middle">
							<thead class="table-light">
								<tr>
									<th>항목</th>
									<th>내용</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>고객 아이디</td>
									<td>${info.id}</td>
								</tr>
								<tr>
									<td>고객 이름</td>
									<td>${info.name}</td>
								</tr>
								<tr>
									<td>고객 주소</td>
									<td>${info.address}</td>
								</tr>
								<tr>
									<td>고객 연락처</td>
									<td>${info.contact}</td>
								</tr>
								<tr>
									<td>고객 이메일</td>
									<td>${info.email}</td>
								</tr>
								<tr>
									<td>고객 등급</td>
									<td>${info.grade}</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 푸터 포함 -->
	<jsp:include page="/WEB-INF/views/includes2/footer.jsp" />
</body>
</html>
