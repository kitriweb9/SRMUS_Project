<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet" />
</head>
<body>
	<!-- Header Include -->
	<jsp:include page="/WEB-INF/views/includes/header.jsp" />
	<!-- Common Include -->
	<jsp:include page="/WEB-INF/views/includes/common.jsp" />

	<div class="d-flex">
		<!-- Sidebar Include -->
		<jsp:include page="/WEB-INF/views/includes/sidebar.jsp" />

		<!-- Main Content -->
		<div class="main-content p-4">
			<div class="container-fluid px-0">
				<div class="col-9">
					<h2>마이페이지</h2>
					<!-- 마이페이지 폼 -->
					<div id="mypage-form-container" class="mt-3">
						<c:forEach var="employee" items="${employeeList}">
							<form id="mypage-form-${employee.employeeId}" method="post"
								action="${pageContext.request.contextPath}/mypage/update">
								<div class="mb-3">
									<label for="employeeId-${employee.employeeId}"
										class="form-label">직원 아이디</label> <input type="text"
										class="form-control" name="employeeId"
										id="employeeId-${employee.employeeId}"
										value="${employee.employeeId}" readonly />
								</div>

								<!-- 비밀번호 변경 입력 폼 추가 -->
								<div class="mb-3">
									<label for="newPassword-${employee.employeeId}"
										class="form-label">새 비밀번호</label> <input type="password"
										class="form-control" name="newPassword"
										id="newPassword-${employee.employeeId}"
										placeholder="새 비밀번호 입력" />
								</div>
								<div class="mb-3">
									<label for="confirmPassword-${employee.employeeId}"
										class="form-label">비밀번호 확인</label> <input type="password"
										class="form-control" name="confirmPassword"
										id="confirmPassword-${employee.employeeId}"
										placeholder="비밀번호 확인" />
								</div>

								<div class="mb-3">
									<label for="employeeName-${employee.employeeId}"
										class="form-label">이름</label> <input type="text"
										class="form-control" name="employeeName"
										id="employeeName-${employee.employeeId}"
										value="${employee.employeeName}" required />
								</div>
								<div class="mb-3">
									<label for="employeeContact-${employee.employeeId}"
										class="form-label">연락처</label> <input type="text"
										class="form-control" name="employeeContact"
										id="employeeContact-${employee.employeeId}"
										value="${employee.employeeContact}" required />
								</div>
								<div class="mb-3">
									<label for="employeeEmail-${employee.employeeId}"
										class="form-label">이메일</label> <input type="email"
										class="form-control" name="employeeEmail"
										id="employeeEmail-${employee.employeeId}"
										value="${employee.employeeEmail}" required />
								</div>
								<div class="mb-3">
									<label for="positionName-${employee.employeeId}"
										class="form-label">직책</label> <input type="text"
										class="form-control" name="positionName"
										id="positionName-${employee.employeeId}"
										value="${employee.positionName}" readonly />
								</div>
								<div class="mb-3">
									<label for="roleName-${employee.employeeId}" class="form-label">역할</label>
									<input type="text" class="form-control" name="roleName"
										id="roleName-${employee.employeeId}"
										value="${employee.roleName}" readonly />
								</div>
								<div class="mb-3">
									<label for="departmentName-${employee.employeeId}"
										class="form-label">부서</label> <input type="text"
										class="form-control" name="departmentName"
										id="departmentName-${employee.employeeId}"
										value="${employee.departmentName}" readonly />
								</div>

								<button type="submit" class="btn btn-primary">수정</button>
							</form>
							<hr />
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Footer Include -->
	<jsp:include page="/WEB-INF/views/includes/footer.jsp" />
</body>
</html>
