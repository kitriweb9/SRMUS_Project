<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>신규 상품 등록</title>
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
					<h2>신규 상품 등록</h2>
					<!-- 신규 상품 등록 폼 -->
					<div id="add-form-container" class="mt-3">
						<h4>상품 정보 입력</h4>
						<form id="add-form" method="post" action="registgoods">
							<div class="mb-3">
								<label for="add-goodsId" class="form-label">상품 아이디</label> <input
									type="text" class="form-control" name="goodsId"
									id="add-goodsId" required />
							</div>
							<div class="mb-3">
								<label for="add-goodsName" class="form-label">상품 이름</label> <input
									type="text" class="form-control" name="goodsName"
									id="add-goodsName" required />
							</div>
							<div class="mb-3">
								<label for="add-goodsCategory" class="form-label">상품
									카테고리</label>
								<div class="input-group">
									<select name="goodsCategoryId" id="add-goodsCategory"
										class="form-control" required>
										<c:forEach var="category" items="${categoryList}">
											<option value="${category.goodsCategoryid}">${category.goodsCategoryName}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="mb-3">
								<label for="add-factoryId" class="form-label">제조 아이디</label> <input
									type="text" class="form-control" name="factoryId"
									id="add-factoryId" required />
							</div>
							<div class="mb-3">
								<label for="add-goodsCostPrice" class="form-label">상품 원가</label>
								<input type="text" class="form-control" name="goodsCostPrice"
									id="add-goodsCostPrice" required />
							</div>
							<div class="mb-3">
								<label for="add-goodsMarketPrice" class="form-label">상품
									매가</label> <input type="text" class="form-control"
									name="goodsMarketPrice" id="add-goodsMarketPrice" required />
							</div>
							<div class="mb-3">
								<label for="add-goodsCustomerPrice" class="form-label">매장
									판매가격</label> <input type="text" class="form-control"
									name="goodsCustomerPrice" id="add-goodsCustomerPrice" required />
							</div>
							<div class="mb-3">
								<label for="add-goodsUnit" class="form-label">단위</label> <input
									type="text" class="form-control" name="goodsUnit"
									id="add-goodsUnit" required />
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
	<jsp:include page="includes/footer.jsp" />

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="js/main.js"></script>
	<script>
		function cancelAdd() {
			document.getElementById('add-form').reset();
		}
	</script>
</body>
</html>