<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>본부 마감 등록</title>
	<jsp:include page="includes/common.jsp" />
</head>
<body>
	<jsp:include page="includes/header.jsp" />
	<div class="d-flex">
		<jsp:include page="includes/sidebar.jsp" />
		<div class="main-content p-4">
			<div class="container-fluid px-0">
				<div class="col-12">
					<h2>본부 마감 등록</h2>

					<!-- 날짜 필터 -->
					<form method="get" action="hqclose">
						<div class="row mb-3">
							<div class="col-4">
								<label for="filter-date" class="form-label">날짜 선택</label> <input
									type="date" class="form-control" id="filter-date"
									name="marketClosingDate"
									value="${param.marketClosingDate != null ? param.marketClosingDate : ''}" />
							</div>
							<div class="col-2 align-self-end">
								<button type="submit" class="btn btn-primary">필터 적용</button>
							</div>
						</div>
					</form>

					<!-- 날짜가 선택된 경우에만 매장별 마감 테이블이 나타나도록 설정 -->
					<c:if test="${not empty param.marketClosingDate}">
						<!-- 매장별 마감 테이블 -->
						<form id="hq-closing-form" method="post" action="hqClosingInsert">
							<div class="table-responsive">
								<table class="table table-striped">
									<thead>
										<tr>
											<th><input type="checkbox" id="select-all-checkbox" />
												선택</th>
											<!-- 전체 선택 체크박스 -->
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
												<td><input type="checkbox" class="closing-checkbox"
													value="${closing.marketClosingAmount}"
													data-id="${closing.marketClosingId}" /></td>
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
							</div>

							<!-- 본부 마감 총합계 표시 -->
							<div class="row mt-3">
								<div class="col-12 text-end">
									<h4>
										본부 마감 총합계: <span id="hq-closing-total">0</span> 원
									</h4>
								</div>
							</div>

							<!-- 등록 버튼 -->
							<div class="row mt-3">
								<div class="col-12 text-end">
									<input type="hidden" name="hqClosingDate"
										value="${param.marketClosingDate}" />
									<!-- 본부 마감 날짜 -->
									<input type="hidden" name="hqClosingAmount"
										id="hqClosingAmount" />
									<button type="submit" class="btn btn-success">본부 마감 등록</button>
								</div>
							</div>
						</form>
					</c:if>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="includes/footer.jsp" />
	<script>
		// 체크박스 클릭 시 총합계 계산
		document.querySelectorAll('.closing-checkbox').forEach(function(checkbox) {
			checkbox.addEventListener('change', function() {
				let total = 0;
				document.querySelectorAll('.closing-checkbox:checked').forEach(function(checkedBox) {
					total += parseFloat(checkedBox.value);
				});
				document.getElementById('hq-closing-total').textContent = total.toLocaleString();
			});
		});

		// 전체 선택 체크박스 클릭 시 모든 체크박스 선택/해제
		document.getElementById('select-all-checkbox').addEventListener('change', function() {
			const isChecked = this.checked;
			document.querySelectorAll('.closing-checkbox').forEach(function(checkbox) {
				checkbox.checked = isChecked;
			});
			// 전체 선택 시 총합 계산
			let total = 0;
			if (isChecked) {
				document.querySelectorAll('.closing-checkbox').forEach(function(checkbox) {
					total += parseFloat(checkbox.value);
				});
			}
			document.getElementById('hq-closing-total').textContent = total.toLocaleString();
		});

		// 등록 버튼 클릭 시 처리
		document.getElementById('hq-closing-form').addEventListener('submit', function(event) {
			let totalAmount = 0;
			const selectedItems = [];
			document.querySelectorAll('.closing-checkbox:checked').forEach(function(checkbox) {
				selectedItems.push(checkbox.dataset.id); // 선택된 마감 ID
				totalAmount += parseFloat(checkbox.value);
			});

			if (selectedItems.length === 0) {
				event.preventDefault(); // 아무 항목도 선택되지 않았으면 폼 제출을 막음
				alert('하나 이상의 항목을 선택해 주세요.');
			} else {
				// 합산 금액을 hidden input에 설정
				document.getElementById('hqClosingAmount').value = totalAmount;

				// 선택된 마감 ID를 본부 마감 ID로 전달하거나 추가 로직을 수행
				// 예시: console.log(selectedItems);
			}
		});
	</script>
</body>
</html>
