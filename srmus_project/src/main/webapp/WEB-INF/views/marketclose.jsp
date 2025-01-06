<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>매장 마감 등록</title>
	<jsp:include page="includes/common.jsp" />
</head>
<body>
	<jsp:include page="includes/header.jsp" />
	<div class="d-flex">
		<jsp:include page="includes/sidebar.jsp" />
		<div class="main-content p-4">
			<div class="container-fluid px-0">
				<div class="col-9">
					<h2>매장 마감 등록</h2>
					<form id="register-form" method="post" action="registmarketclosing">
						<div class="mb-3">
							<label for="register-marketClosingId" class="form-label">매장
								마감 일련번호</label> <input type="text" class="form-control"
								name="marketClosingId" id="register-marketClosingId" required />
						</div>
						<div class="mb-3">
							<label for="register-storeId" class="form-label">매장 ID</label> <input
								type="text" class="form-control" name="storeId"
								id="register-storeId" required />
						</div>
						<div class="mb-3">
							<label for="register-marketClosingDate" class="form-label">마감
								일자</label> <input type="datetime-local" class="form-control"
								name="marketClosingDate" id="register-marketClosingDate"
								required />
						</div>
						<div class="mb-3">
							<label for="register-marketClosingAmount" class="form-label">마감
								금액</label> <input type="number" class="form-control"
								name="marketClosingAmount" id="register-marketClosingAmount"
								required />
						</div>
						<button type="submit" class="btn btn-success">등록</button>
						<button type="reset" class="btn btn-secondary">초기화</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="includes/footer.jsp" />
</body>
</html>