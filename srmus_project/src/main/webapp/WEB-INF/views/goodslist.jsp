<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
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
					<h2>상품 목록</h2>
					<table class="table table-striped">
						<thead>
							<tr>
								<th>상품 아이디</th>
								<th>상품 카테고리</th>
								<th>제조 아이디</th>
								<th>상품 이름</th>
								<th>상품 원가</th>
								<th>상품 매가</th>
								<th>매장 판매가격</th>
								<th>단위</th>
								<th>정보 수정</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="goods" items="${goods}">
								<tr id="row-${goods.goodsId}">
									<td>${goods.goodsId}</td>
									<td>${goods.goodsCategoryName}</td>
									<td>${goods.factoryId}</td>
									<td>${goods.goodsName}</td>
									<td>${goods.goodsCostPrice}원</td>
									<td>${goods.goodsMarketPrice}원</td>
									<td>${goods.goodsCustomerPrice}원</td>
									<td>${goods.goodsUnit}</td>
									<td>
										<button class="btn btn-primary"
											onclick="editProduct('${goods.goodsId}', '${goods.goodsCategoryId}', '${goods.factoryId}', '${goods.goodsName}', '${goods.goodsCostPrice}', '${goods.goodsMarketPrice}', '${goods.goodsCustomerPrice}', '${goods.goodsUnit}')">
											수정</button>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

					<!-- 수정 폼 -->
					<div id="edit-form-container" style="display: none;" class="mt-3">
						<h4>상품 정보 수정</h4>
						<form id="edit-form" method="post" action="goodsupdate">
							<input type="hidden" name="goodsId" id="edit-goodsId" />
							<div class="mb-3">
								<label for="edit-goodsName" class="form-label">상품 이름</label> <input
									type="text" class="form-control" name="goodsName"
									id="edit-goodsName" />
							</div>
							<div class="mb-3">
								<label for="edit-goodsCategory" class="form-label">상품
									카테고리</label>
								<div class="input-group">
									<select name="goodsCategoryId" id="edit-goodsCategory"
										class="form-control">
										<c:forEach var="category" items="${categoryList}">
											<option value="${category.goodsCategoryid}">${category.goodsCategoryName}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="mb-3">
								<label for="edit-factoryId" class="form-label">제조 아이디</label> <input
									type="text" class="form-control" name="factoryId"
									id="edit-factoryId" />
							</div>
							<div class="mb-3">
								<label for="edit-goodsCostPrice" class="form-label">상품
									원가</label> <input type="text" class="form-control"
									name="goodsCostPrice" id="edit-goodsCostPrice" />
							</div>
							<div class="mb-3">
								<label for="edit-goodsMarketPrice" class="form-label">상품
									매가</label> <input type="text" class="form-control"
									name="goodsMarketPrice" id="edit-goodsMarketPrice" />
							</div>
							<div class="mb-3">
								<label for="edit-goodsCustomerPrice" class="form-label">매장
									판매가격</label> <input type="text" class="form-control"
									name="goodsCustomerPrice" id="edit-goodsCustomerPrice" />
							</div>
							<div class="mb-3">
								<label for="edit-goodsUnit" class="form-label">단위</label> <input
									type="text" class="form-control" name="goodsUnit"
									id="edit-goodsUnit" />
							</div>
							<button type="submit" class="btn btn-success">저장</button>
							<button type="button" class="btn btn-secondary"
								onclick="cancelEdit()">취소</button>
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
    function editProduct(goodsId, goodsCategoryId, factoryId, goodsName, goodsCostPrice, goodsMarketPrice, goodsCustomerPrice, goodsUnit) {
        document.getElementById('edit-goodsId').value = goodsId;
        document.getElementById('edit-goodsId').readOnly = true;
        document.getElementById('edit-goodsName').value = goodsName;
        document.getElementById('edit-goodsCategory').value = goodsCategoryId; 
        document.getElementById('edit-factoryId').value = factoryId;
        document.getElementById('edit-goodsCostPrice').value = goodsCostPrice;
        document.getElementById('edit-goodsMarketPrice').value = goodsMarketPrice;
        document.getElementById('edit-goodsCustomerPrice').value = goodsCustomerPrice;
        document.getElementById('edit-goodsUnit').value = goodsUnit;

        document.getElementById('edit-form-container').style.display = 'block';
    }

    function cancelEdit() {
        document.getElementById('edit-form-container').style.display = 'none';
        document.getElementById('edit-form').reset();
    }

</script>
</body>
</html>