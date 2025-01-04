<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>직원 등록 </title>	
	<script>
	    document.addEventListener("DOMContentLoaded", function() {
	    	const loginForm = document.getElementById("add-form");
	        const password = document.getElementById("employeePassword");
	        	loginForm.addEventListener("submit", function(event) {
	        	password.value = sha256(password.value);
	        });
	    });
	</script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/includes/header.jsp" />
	<jsp:include page="/WEB-INF/views/includes/common.jsp" />
	<div class="d-flex">
		<jsp:include page="/WEB-INF/views/includes/sidebar.jsp" />
		<div class="main-content p-4">
			<div class="container-fluid px-0">
				<div class="col-9">
					<c:if test="${registresult != null}">
					   <script>
					       document.addEventListener("DOMContentLoaded", function() {
					           alert("${registresult}");
					       });
					  	</script>
				   	</c:if>
					<h2>직원 등록</h2>
					<!-- 직원 등록 폼 -->
					<div id="add-form-container" class="mt-3">
						<h4>직원 정보 입력</h4>
						<form id="add-form" method="post"
							action="${pageContext.request.contextPath}/employee/add">
							<div class="mb-3">
								<label for="employeeId" class="form-label">직원 아이디</label> <input
									type="text" class="form-control" name="employeeId"
									id="employeeId" required />
							</div>
							<div class="mb-3">
								<label for="employeePassword" class="form-label">비밀번호</label> <input
									type="password" class="form-control" name="employeePassword"
									id="employeePassword" required />
							</div>
							<div class="mb-3">
								<label for="employeeName" class="form-label">이름</label> <input
									type="text" class="form-control" name="employeeName"
									id="employeeName" required />
							</div>
							<div class="mb-3">
								<label for="employeeContact" class="form-label">연락처</label> <input
									type="text" class="form-control" name="employeeContact"
									id="employeeContact" required />
							</div>
							<div class="mb-3">
								<label for="employeeEmail" class="form-label">이메일</label> <input
									type="email" class="form-control" name="employeeEmail"
									id="employeeEmail" required />
							</div>
							<div class="mb-3">
								<label for="positionId" class="form-label">직책</label> <select
									name="positionId" id="positionId" class="form-control" required>
									<c:forEach var="position" items="${positions}">
										<option value="${position.positionId}">${position.positionName}</option>
									</c:forEach>
								</select>
							</div>
							<div class="mb-3">
								<label for="roleId" class="form-label">역할</label> <select
									name="roleId" id="roleId" class="form-control" required>
									<c:forEach var="role" items="${roles}">
										<option value="${role.roleId}">${role.roleName}</option>
									</c:forEach>
								</select>
							</div>
							<div class="mb-3">
								<label for="temporaryRoleId" class="form-label">임시
									역할</label> <select name="temporaryRoleId"
									id="temporaryRoleId" class="form-control">
									<c:forEach var="role" items="${roles}">
										<option value="${role.roleId}">${role.roleName}</option>
									</c:forEach>
								</select>
							</div>
							<div class="mb-3">
								<label for="departmentId" class="form-label">부서</label> <select
									name="departmentId" id="departmentId" class="form-control"
									required>
									<c:forEach var="department" items="${departments}">
										<option value="${department.departmentId}">${department.departmentName}</option>
									</c:forEach>
								</select>
							</div>
							<button type="submit" class="btn btn-success">등록</button>
							<button type="button" class="btn btn-secondary"
								onclick="cancelAdd()">취소</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/includes/footer.jsp" />

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<script>
        function cancelAdd() {
            document.getElementById('add-form').reset();
        }
    </script>
</body>
</html>
