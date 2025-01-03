<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>매장 등록</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<link rel="stylesheet" href="resources/css/main.css">
</head>
<body>
	<jsp:include page="includes/header.jsp" />
	<div class="d-flex">
		<jsp:include page="includes/sidebar.jsp" />
		<div class="main-content p-4">
			<div class="container-fluid px-0">
				<div class="col-9">
					<h2>매장 등록</h2>
					<form id="register-form" method="post" action="registstore">
						<div class="mb-3">
							<label for="register-storeId" class="form-label">매장 아이디</label> <input
								type="text" class="form-control" name="storeId"
								id="register-storeId" required />
						</div>
						<div class="mb-3">
							<label for="register-storeName" class="form-label">매장 이름</label>
							<input type="text" class="form-control" name="storeName"
								id="register-storeName" required />
						</div>
						<div class="mb-3">
							<label for="register-employeeId" class="form-label">관리 사원
								정보</label> <input type="text" class="form-control" name="employeeId"
								id="register-employeeId" required />
						</div>
						<div class="mb-3">
							<label for="register-storeAddress" class="form-label">매장
								주소</label> <input type="text" class="form-control" name="storeAddress"
								id="register-storeAddress" required />
						</div>
						<div class="mb-3">
							<label for="register-storeContact" class="form-label">매장
								연락처</label> <input type="text" class="form-control" name="storeContact"
								id="register-storeContact" required />
						</div>
						<button type="submit" class="btn btn-success">등록</button>
						<button type="reset" class="btn btn-secondary">초기화</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="includes/footer.jsp" />

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="js/main.js"></script>
</body>
</html>
