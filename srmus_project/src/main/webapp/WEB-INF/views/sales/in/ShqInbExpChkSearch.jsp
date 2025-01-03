<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>영업관리본부: 매장별 입고 내역 조회</title>
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
    .search-bar {
        display: flex;
        align-items: center;
        gap: 10px;
        margin-bottom: 15px;
    }
    .search-input {
        max-width: 200px;
    }
</style>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/includes/header.jsp" />
	<div class="d-flex">
		<jsp:include page="/WEB-INF/views/includes/sidebar.jsp" />
		<div class="main-content p-4">
			<div class="container-fluid px-0">
				<div class="card p-3 mb-5">
					<h5>매장별 입고 내역 조회</h5>
					<div class="table-responsive mt-3">
						<table class="table table-bordered project-table align-middle">
							<thead class="table-light">
								<tr>
									<th style="max-width:20px; text-align: center;">선택</th>
									<th>입고 ID</th>
									<th>매장 ID</th>
									<th>매장 이름</th>
									<th>상품 ID</th>
									<th>상품 이름</th>
									<th>입고 날짜</th>
									<th>입고 수량</th>
									<th>입고 확인</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="good" items="${goods}">
									<tr>
										<td style="text-align: center">
											<input type="checkbox" class="row-checkbox" 
												   ${good.confirm == 'Y' ? 'disabled' : ''}/>
										</td>
										<td>${good.inboundId}</td>
										<td>${good.storeId}</td>
										<td>${good.storeName}</td>
										<td>${good.goodsId}</td>
										<td>${good.goodsName}</td>
										<td>
											<input type="datetime-local" class="form-control inbound-date" value="${good.inboundDate}"
											${good.confirm == 'Y' ? 'disabled' : ''}/>
										</td>
										<td>
											<input type="number" class="form-control inbound-qty" value="${good.inboundQuantity}" data-id="${good.goodsId}" 
											 	   data-store-id="${good.storeId}"
											 	   ${good.confirm == 'Y' ? 'disabled' : ''}/>
										</td>
										<td>
											<select class="form-select confirm-status" 
												    data-id="${good.goodsId}"
												    data-prev-status="${good.confirm}"
												    ${good.confirm == 'Y' ? 'disabled' : ''}>
												<option value="Y" ${good.confirm == 'Y' ? 'selected' : ''}>입고 완료</option>
												<option value="N" ${good.confirm == 'N' ? 'selected' : ''}>입고 대기</option>
											</select>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="search-bar">
						<input type="text" class="form-control search-input" id="store-search" placeholder="매장 ID 검색">
						<button class="btn btn-sm btn-outline-primary" id="search-button">검색</button>
						<a href="${pageContext.request.contextPath}/inbound/store/" class="btn btn-sm btn-outline-primary" id="search-button">전체 조회</a>
						<div class="button-bar ms-auto">
							<button class="btn btn-sm btn-outline-primary" id="approve-all">전체 입고 확인</button>
							<button class="btn btn-sm btn-outline-secondary" id="approve-selected">선택 입고 확인</button>
							<button class="btn btn-sm btn-outline-success" id="update-selected">선택수정</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/includes/footer.jsp" />
	<script>
	
		//매장 재고 수정용 변수
		function getRowData(row) {
		    const storeId = row.querySelector('.inbound-qty').dataset.storeId; 
		    const goodsId = row.querySelector('.inbound-qty').dataset.id;      
		    const quantity = row.querySelector('.inbound-qty').value;  
		
		    if (!storeId || !goodsId || !quantity) {
		        console.error('storeId, goodsId, 또는 quantity가 누락되었습니다.');
		    }
		
		    return { storeId, goodsId, quantity };
		}

		// TIMESTAMP 형식으로 변환
		function formatToTimestamp(datetimeLocal) {
		    if (!/\d{4}-\d{2}-\d{2}T\d{2}:\d{2}/.test(datetimeLocal)) {
		        throw new Error("Invalid date format. Expected format: YYYY-MM-DDTHH:mm");
		    }

		    const formattedDate = datetimeLocal.replace('T', ' ') + ":00";

		    return formattedDate;
		}

		// 행 데이터 추출
		function extractRowData(row) {
			const formData = new FormData();
			formData.append('goodsId', row.querySelector('.inbound-qty').dataset.id);
			formData.append('inboundId', row.cells[1].textContent.trim());
			const inboundDate = row.querySelector('.inbound-date').value;
			const formattedDate = formatToTimestamp(inboundDate); 
			if (formattedDate) {
				formData.append('inboundDate', formattedDate);
			} else {
				console.error('Invalid inboundDate value:', inboundDate); 
			}
			formData.append('inboundQuantity', row.querySelector('.inbound-qty').value);
			formData.append('confirm', row.querySelector('.confirm-status').value);
			return formData;
		}

		// 행별 업데이트
		async function sendRowData(url, formData) {
			const response = await fetch(url, {
				method: 'POST',
				body: formData
			});
			return response.ok;
		}


		function hasCheckedRows() {
			return document.querySelectorAll('.row-checkbox:checked').length > 0;
		}

		//변경시 자동 체크
		document.addEventListener('DOMContentLoaded', function () {
			document.querySelectorAll('.inbound-qty, .confirm-status, .inbound-date').forEach(function (element) {
				element.addEventListener('change', function () {
					const row = this.closest('tr');
					row.querySelector('.row-checkbox').checked = true;
				});
			});
	
		//재고 수정 비동기 함수		
		async function updateStoreStock(url, storeId, goodsId, quantity) {
		    const formData = new FormData();
		    formData.append('storeId', storeId);
		    formData.append('goodsId', goodsId);
		    formData.append('qty', quantity);

		    const response = await fetch(url, {
		        method: 'POST',
		        body: formData
		    });
		    return response.ok;
		}
		
		// 선택 수정 버튼 클릭 시 체크된 행 처리
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
					const success = await sendRowData('${pageContext.request.contextPath}/inbound/store/update', formData);
					if (success && prevStatus === 'N' && currentStatus === 'Y') {
						const { storeId, goodsId, quantity } = getRowData(row);
						const storeStockUpdated = await updateStoreStock('${pageContext.request.contextPath}/store/goods/stock', storeId, goodsId, quantity);
					}
					if (!success) {
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
			
			//재고 수정 요청 함수
			async function processSelectedRows(apiUrl, updateStockUrl) {
		    const rows = document.querySelectorAll('tbody tr');
		    let allSuccess = true;
		
		    for (const row of rows) {
		        const checkbox = row.querySelector('.row-checkbox');
		        if (checkbox && checkbox.checked) {
		            const formData = extractRowData(row);
		            const success = await sendRowData(apiUrl, formData);
		
		            if (success) {
		                const { storeId, goodsId, quantity } = getRowData(row);
		                const storeStockUpdated = await updateStoreStock(updateStockUrl, storeId, goodsId, quantity);
		                if (!storeStockUpdated) {
		                    allSuccess = false;
		                }
		            } else {
		                allSuccess = false;
		            }
		        }
		    }
		
		    return allSuccess;
			}


			// 선택 승인 버튼 클릭 시 체크된 행마다 개별적으로 승인 데이터 전송
			document.getElementById('approve-selected').addEventListener('click', async function () {
			    if (!hasCheckedRows()) {
			        alert('승인할 항목을 선택하세요.');
			        return;
			    }
			
			    const allSuccess = await processSelectedRows('${pageContext.request.contextPath}/inbound/store/approve', '${pageContext.request.contextPath}/store/goods/stock');
			
			    if (allSuccess) {
			        alert('모든 승인이 성공적으로 완료되었습니다.');
			    } else {
			        alert('일부 승인이 실패하였습니다.');
			    }
			    location.reload();
			});


			
			//수정 가능한 모든 행 체크
			function checkAllCheckboxes(selector, isChecked) {
			    const checkboxes = document.querySelectorAll(`${selector}:not([disabled])`);
			    checkboxes.forEach(checkbox => {
			        checkbox.checked = isChecked;
			    });
			}

			// 전체 승인 버튼 클릭 시 모든 행 데이터 전송
			document.getElementById('approve-all').addEventListener('click', async function () {
				checkAllCheckboxes('.row-checkbox', true);
				
			    setTimeout(async () => {
			        const allSuccess = await processSelectedRows('${pageContext.request.contextPath}/inbound/store/approve', '${pageContext.request.contextPath}/store/goods/stock');
			        
			        if (allSuccess) {
			            alert('모든 승인이 성공적으로 완료되었습니다.');
			        } else {
			            alert('일부 승인이 실패하였습니다.');
			        }
			        location.reload();
			    }, 0);
			});

			// 매장 검색 버튼 동작
			document.getElementById('search-button').addEventListener('click', function () {
				const searchInput = document.getElementById('store-search').value.trim();
				if (searchInput) {
					window.location.href = '${pageContext.request.contextPath}/inbound/store/' + searchInput;
				} else {
					alert('검색어를 입력하세요.');
				}
			});
		});
	</script>
</body>
</html>
