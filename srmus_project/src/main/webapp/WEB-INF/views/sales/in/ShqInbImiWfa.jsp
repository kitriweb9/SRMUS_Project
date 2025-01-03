<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
<style>
    .inbound-qty {
        max-width: 100px;
    }
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/includes/header.jsp" />
	<div class="d-flex">
		<jsp:include page="/WEB-INF/views/includes/sidebar.jsp" />
		<div class="main-content p-4">
			<div class="container-fluid px-0">
				<div class="card p-3 mb-5">
					<h5>본부 입고 예정 내역 조회</h5>
					<div class="table-responsive mt-3">
						<table class="table table-bordered project-table align-middle">
							<thead class="table-light">
								<tr>
									<th style="max-width:20px; text-align: center;">선택</th>
									<th>입고예정일</th>
									<th>상품ID</th>
									<th>상품명</th>
									<th>입고수량</th>
									<th>입고상태</th>
									<th>업데이트 일자</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="good" items="${goods}">
									<tr>
										<td style="text-align: center">
											<input type="checkbox" class="row-checkbox" 
											${good.confirmStatus != 'N' ? 'disabled' : ''} />
										</td>
										<td class="inbound-date">${good.inboundDate}</td>
										<td>${good.goodsId}</td>
										<td>${good.goodsName}</td>
										<td>
											<input type="number" class="form-control inbound-qty" value="${good.inboundQty}" data-id="${good.goodsId}" 
												   ${good.confirmStatus != 'N' ? 'disabled' : ''}/>
										</td>
										<td>
											<select class="form-select confirm-status" data-id="${good.goodsId}" data-prev-status="${good.confirmStatus}"
													${good.confirmStatus != 'N' ? 'disabled' : ''}>
												<option value="Y" ${good.confirmStatus == 'Y' ? 'selected' : ''}>입고 승인</option>
												<option value="N" ${good.confirmStatus == 'N' ? 'selected' : ''}>입고 대기</option>
												<option value="C" ${good.confirmStatus == 'C' ? 'selected' : ''} disabled>출하 완료</option>
											</select>
										</td>
										<td>${good.updateDate}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="mt-3">
						<button class="btn btn-sm btn-outline-primary" id="approve-all">전체 승인</button>
						<button class="btn btn-sm btn-outline-secondary" id="approve-selected">선택 승인</button>
						<button class="btn btn-sm btn-outline-success" id="update-selected">선택수정</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/includes/footer.jsp" />
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<script>
		// 행 데이터 추출 함수
		function extractRowData(row) {
			const formData = new FormData();
			formData.append('goodsId', row.querySelector('.inbound-qty').dataset.id);
			formData.append('inboundDate', row.querySelector('.inbound-date').textContent.trim());
			formData.append('inboundQty', row.querySelector('.inbound-qty').value);
			formData.append('confirmStatus', row.querySelector('.confirm-status').value);
			return formData;
		}

		// 개별 데이터 전송 함수
		async function sendRowData(url, formData) {
			const response = await fetch(url, {
				method: 'POST',
				body: formData
			});
			return response.ok;
		}

		// 재고 업데이트 함수
		async function updateStock(goodsId, qty) {
			const formData = new FormData();
			formData.append('goodsId', goodsId);
			formData.append('qty', qty);
			const response = await fetch('${pageContext.request.contextPath}/goods/stock', {
				method: 'POST',
				body: formData
			});
			return response.ok;
		}

		// 체크된 행이 있는지 확인하는 함수
		function hasCheckedRows() {
			return document.querySelectorAll('.row-checkbox:checked').length > 0;
		}

		document.addEventListener('DOMContentLoaded', function () {
			// 수량이나 상태 변경 시 체크박스 자동 체크
			document.querySelectorAll('.inbound-qty, .confirm-status').forEach(function (element) {
				element.addEventListener('change', function () {
					const row = this.closest('tr');
					row.querySelector('.row-checkbox').checked = true;
				});
			});

			// 선택 수정 버튼 클릭 시
			document.getElementById('update-selected').addEventListener('click', async function () {
				if (!hasCheckedRows()) {
					alert('수정할 항목을 선택하세요.');
					return;
				}

				const rows = document.querySelectorAll('tbody tr');
				let allSuccess = true;

				for (const row of rows) {
					const checkbox = row.querySelector('.row-checkbox');
					if (checkbox.checked) {
						const prevStatus = row.querySelector('.confirm-status').dataset.prevStatus;
						const currentStatus = row.querySelector('.confirm-status').value;

						const formData = extractRowData(row);
						const success = await sendRowData('${pageContext.request.contextPath}/inbound/update', formData);

						if (success && prevStatus === 'N' && currentStatus === 'Y') {
							const goodsId = row.querySelector('.inbound-qty').dataset.id;
							const qty = row.querySelector('.inbound-qty').value;
							const stockUpdated = await updateStock(goodsId, qty);
							if (!stockUpdated) {
								allSuccess = false;
							}
						} else if (!success) {
							allSuccess = false;
						}
					}
				}

				if (allSuccess) {
					alert('모든 수정이 성공적으로 완료되었습니다.');
				} else {
					alert('일부 수정이 실패하였습니다.');
				}
				location.reload();
			});

			// 선택 승인 버튼 클릭 시
			document.getElementById('approve-selected').addEventListener('click', async function () {
				if (!hasCheckedRows()) {
					alert('승인할 항목을 선택하세요.');
					return;
				}

				const rows = document.querySelectorAll('tbody tr');
				let allSuccess = true;

				for (const row of rows) {
					const checkbox = row.querySelector('.row-checkbox');
					if (checkbox.checked) {
						const formData = extractRowData(row);
						const success = await sendRowData('${pageContext.request.contextPath}/inbound/approve', formData);

						if (success) {
							const goodsId = row.querySelector('.inbound-qty').dataset.id;
							const qty = row.querySelector('.inbound-qty').value;
							const stockUpdated = await updateStock(goodsId, qty);
							if (!stockUpdated) {
								allSuccess = false;
							}
						} else {
							allSuccess = false;
						}
					}
				}

				if (allSuccess) {
					alert('모든 승인이 성공적으로 완료되었습니다.');
				} else {
					alert('일부 승인이 실패하였습니다.');
				}
				location.reload();
			});

			// 전체 승인 버튼 클릭 시
			document.getElementById('approve-all').addEventListener('click', async function () {
				const rows = document.querySelectorAll('tbody tr');
				let allSuccess = true;

				for (const row of rows) {
					const formData = extractRowData(row);
					const success = await sendRowData('${pageContext.request.contextPath}/inbound/approve', formData);

					if (success) {
						const goodsId = row.querySelector('.inbound-qty').dataset.id;
						const qty = row.querySelector('.inbound-qty').value;
						const stockUpdated = await updateStock(goodsId, qty);
						if (!stockUpdated) {
							allSuccess = false;
						}
					} else {
						allSuccess = false;
					}
				}

				if (allSuccess) {
					alert('모든 승인이 성공적으로 완료되었습니다.');
				} else {
					alert('일부 승인이 실패하였습니다.');
				}
				location.reload();
			});
		});
	</script>
</body>
</html>
