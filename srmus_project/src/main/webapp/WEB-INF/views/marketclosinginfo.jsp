<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>매장별 마감 관리</title>
	<jsp:include page="includes/common.jsp" />
</head>
<body>
	<jsp:include page="includes/header.jsp" />
	<div class="d-flex">
		<jsp:include page="includes/sidebar.jsp" />
		<div class="main-content p-4">
			<div class="container-fluid px-0">
				<div class="col-12">
					<h2>매장별 마감 내역</h2>
					<!-- 날짜 필터 -->
					<form method="get" action="marketcloseinfo">
						<div class="row mb-3">
							<div class="col-4">
								<label for="filter-date" class="form-label">날짜 선택</label> <input
									type="date" class="form-control" id="filter-date"
									name="marketClosingDate" />
							</div>
							<div class="col-2 align-self-end">
								<button type="submit" class="btn btn-primary">필터 적용</button>
							</div>
						</div>
					</form>

					<!-- 매장별 마감 테이블 -->
					<table class="table table-striped">
						<thead>
							<tr>
								<th>마감 ID</th>
								<th>매장 ID</th>
								<th>매장 이름</th>
								<th>관리 사원 ID</th>
								<th>관리 사원 이름</th>
								<th>마감 날짜</th>
								<th>마감 금액</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="closing" items="${marketClosingList}">
								<tr id="row-${closing.marketClosingId}">
									<td>${closing.marketClosingId}</td>
									<td>${closing.storeId}</td>
									<td>${closing.storeName}</td>
									<td>${closing.employeeId}</td>
									<td>${closing.employeeName}</td>
									<td>${closing.marketClosingDate}</td>
									<td><fmt:formatNumber value="${closing.marketClosingAmount}" pattern="#,###" />원</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

					<!-- 수정 폼 -->
					<div id="edit-form-container" style="display: none;" class="mt-3">
						<h4>마감 정보 수정</h4>
						<form id="edit-form" method="post" action="marketClosingUpdate">
							<input type="hidden" name="marketClosingId"
								id="edit-marketClosingId" />
							<div class="mb-3">
								<label for="edit-storeId" class="form-label">매장 ID</label> <input
									type="text" class="form-control" name="storeId"
									id="edit-storeId" readonly />
							</div>
							<div class="mb-3">
								<label for="edit-storeName" class="form-label">매장 이름</label> <input
									type="text" class="form-control" name="storeName"
									id="edit-storeName" readonly />
							</div>
							<div class="mb-3">
								<label for="edit-employeeId" class="form-label">관리 사원 ID</label>
								<input type="text" class="form-control" name="employeeId"
									id="edit-employeeId" readonly />
							</div>
							<div class="mb-3">
								<label for="edit-employeeName" class="form-label">관리 사원
									이름</label> <input type="text" class="form-control" name="employeeName"
									id="edit-employeeName" readonly />
							</div>
							<div class="mb-3">
								<label for="edit-marketClosingDate" class="form-label">마감
									날짜</label> <input type="date" class="form-control"
									name="marketClosingDate" id="edit-marketClosingDate" />
							</div>
							<div class="mb-3">
								<label for="edit-marketClosingAmount" class="form-label">마감
									금액</label> <input type="number" class="form-control"
									name="marketClosingAmount" id="edit-marketClosingAmount" />
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
	<script>
    // 수정 폼에 데이터 설정
    function editClosing(marketClosingId, storeId, marketClosingDate, marketClosingAmount) {
        document.getElementById('edit-marketClosingId').value = marketClosingId;
        document.getElementById('edit-storeId').value = storeId;
        document.getElementById('edit-marketClosingDate').value = marketClosingDate;
        document.getElementById('edit-marketClosingAmount').value = marketClosingAmount;

        document.getElementById('edit-form-container').style.display = 'block';
    }

    // 수정 취소
    function cancelEdit() {
        document.getElementById('edit-form-container').style.display = 'none';
        document.getElementById('edit-form').reset();
    }
	</script>
</body>
</html>