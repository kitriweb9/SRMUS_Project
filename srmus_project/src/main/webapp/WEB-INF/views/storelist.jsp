<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>콘텐츠</title>
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
					<h2>매장 목록</h2>
					<table class="table table-striped">
						<thead>
							<tr>
								<th>매장 아이디</th>
								<th>매장 이름</th>
								<th>관리 사원 정보</th>
								<th>매장 주소</th>
								<th>매장 연락처</th>
								<th>정보 수정</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="store" items="${stores}">
								<tr id="row-${store.storeId}">
									<td>${store.storeId}</td>
									<td>${store.storeName}</td>
									<td>${store.employeeId}</td>
									<td>${store.storeAddress}</td>
									<td>${store.storeContact}</td>
									<td>
										<c:if test="${canEdit}">
											<button class="btn btn-primary"
												onclick="editStore('${store.storeId}', '${store.storeName}', '${store.employeeId}', '${store.storeAddress}', '${store.storeContact}')">
												수정</button>
										</c:if>
										 
										<c:if test="${!canEdit}">
											<button class="btn btn-primary" disabled>수정</button>
										</c:if>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

					<!-- 수정 폼 -->
					<div id="edit-form-container" style="display: none;" class="mt-3">
						<h4>매장 정보 수정</h4>
						<form id="edit-form" method="post" action="storeupdate">
							<input type="hidden" name="storeId" id="edit-storeId" />
							<div class="mb-3">
								<label for="edit-storeName" class="form-label">매장 이름</label> <input
									type="text" class="form-control" name="storeName"
									id="edit-storeName" />
							</div>
							<div class="mb-3">
								<label for="edit-employeeId" class="form-label">관리 사원 정보</label>
								<input type="text" class="form-control" name="employeeId"
									id="edit-employeeId" />
							</div>
							<div class="mb-3">
								<label for="edit-storeAddress" class="form-label">매장 주소</label>
								<input type="text" class="form-control" name="storeAddress"
									id="edit-storeAddress" />
							</div>
							<div class="mb-3">
								<label for="edit-storeContact" class="form-label">매장 연락처</label>
								<input type="text" class="form-control" name="storeContact"
									id="edit-storeContact" />
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
    // 수정 폼에 데이터 설정
    function editStore(storeId, storeName, employeeId, storeAddress, storeContact) {
        // 매장 아이디는 읽기 전용으로 설정
        const storeIdInput = document.getElementById('edit-storeId');
        storeIdInput.value = storeId;
        storeIdInput.readOnly = true; // 매장 아이디 수정 불가

        // 나머지 필드에 데이터 설정
        document.getElementById('edit-storeName').value = decodeURIComponent(storeName);
        document.getElementById('edit-employeeId').value = decodeURIComponent(employeeId);
        document.getElementById('edit-storeAddress').value = decodeURIComponent(storeAddress);
        document.getElementById('edit-storeContact').value = decodeURIComponent(storeContact);

        // 수정 폼 표시
        document.getElementById('edit-form-container').style.display = 'block';
    }

    // 수정 취소
    function cancelEdit() {
        // 수정 폼 숨기기 및 초기화
        document.getElementById('edit-form-container').style.display = 'none';
        document.getElementById('edit-form').reset();
    }
</script>
</body>
</html>