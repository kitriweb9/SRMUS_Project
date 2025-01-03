<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>영업관리본부: 출하 등록</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
<style>
    .outbound-qty {
        max-width: 100px; /* 숫자 3자리 정도만 표시 */
    }
    .dynamic-store {
        margin-bottom: 10px;
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
					<h5>본부 출하 등록</h5>
					<div class="table-responsive mt-3">
						<table class="table table-bordered project-table align-middle">
							<thead class="table-light">
								<tr>
									<th style="max-width:30px; text-align: center;">선택</th>
									<th>입고날짜</th>
									<th>상품명</th>
									<th>입고수량</th>
									<th>출하 매장별 수량</th>
									<th>매장 입고 예정일</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="good" items="${goods}">
									<tr>
										<td style="text-align: center">
											<input type="checkbox" class="row-checkbox" />
										</td>
										<td>${good.inboundDate}</td>
										<td data-id="${good.goodsId}">${good.goodsId}</td>
										<td class="inbound-qty">${good.inboundQty}</td>
										<td>
											<div class="dynamic-stores">
												<div class="dynamic-store">
													<input type="text" class="form-control store-id" placeholder="매장 ID 입력" />
													<input type="number" class="form-control store-qty" placeholder="수량 입력" />
												</div>
											</div>
											<button class="btn btn-sm btn-outline-secondary add-store" type="button">매장 추가</button>
										</td>
										<td>
											<input type="date" class="form-control outbound-date"/>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="mt-3">
						<button class="btn btn-sm btn-outline-primary" id="submit-outbound">출하 입력</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/includes/footer.jsp" />
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<script>
	async function sendOutboundStoreData(url, goodsId, storeId, quantity, outboundDate, inboundDate) {
	    const formData = new FormData();
	    formData.append('goodsId', goodsId);
	    formData.append('storeId', storeId);
	    formData.append('inboundQuantity', quantity);
	    formData.append('inboundDate', outboundDate);
	    formData.append('hqInboundDate', inboundDate);

	    const response = await fetch(url, {
	        method: 'POST',
	        body: formData
	    });
	    return response.ok;
	}

/* 	async function updateStoreStock(url, storeId, goodsId, quantity) {
	    const formData = new FormData();
	    formData.append('storeId', storeId);
	    formData.append('goodsId', goodsId);
	    formData.append('qty', quantity);

	    const response = await fetch(url, {
	        method: 'POST',
	        body: formData
	    });
	    return response.ok;
	} */

	async function updateTotalStock(url, goodsId, quantity) {
	    const formData = new FormData();
	    formData.append('goodsId', goodsId);
	    formData.append('qty', -quantity); // 수량을 음수로 변경

	    const response = await fetch(url, {
	        method: 'POST',
	        body: formData
	    });
	    return response.ok;
	}

	document.addEventListener('DOMContentLoaded', function () {
	    const dateInputs = document.querySelectorAll('.outbound-date');

	    const today = new Date();
	    today.setHours(today.getHours() + 9);

	    const formattedDate = today.toISOString().split('T')[0];

	    dateInputs.forEach(function (input) {
	        input.value = formattedDate;
	    });

	    document.querySelectorAll('.add-store').forEach(function (button) {
	        button.addEventListener('click', function () {
	            const dynamicStores = this.closest('td').querySelector('.dynamic-stores');
	            const newStoreInput = document.createElement('div');
	            newStoreInput.classList.add('dynamic-store');
	            newStoreInput.innerHTML = `
	                <input type="text" class="form-control store-id" placeholder="매장 ID 입력" />
	                <input type="number" class="form-control store-qty" placeholder="수량 입력" />
	            `;
	            dynamicStores.appendChild(newStoreInput);
	        });
	    });

	    document.querySelectorAll('.store-id, .store-qty, .outbound-date').forEach(function (input) {
	        input.addEventListener('input', function () {
	            const row = this.closest('tr');
	            row.querySelector('.row-checkbox').checked = true;
	        });
	    });

	    document.getElementById('submit-outbound').addEventListener('click', async function () {
	        const rows = document.querySelectorAll('tbody tr');
	        let allSuccess = true;

	        for (const row of rows) {
	            const checkbox = row.querySelector('.row-checkbox');
	            if (checkbox.checked) {
	                const goodsIdElement = row.querySelector('td[data-id]');
	                const goodsId = goodsIdElement ? goodsIdElement.dataset.id : null;
	                const inboundQty = parseInt(row.querySelector('.inbound-qty').textContent, 10);
	                const inboundDate = row.querySelector('td:nth-child(2)').textContent.trim();
	                const dynamicStores = row.querySelectorAll('.dynamic-store');

	                let totalQty = 0;
	                for (const store of dynamicStores) {
	                    const storeQty = parseInt(store.querySelector('.store-qty').value || 0, 10);
	                    totalQty += storeQty;
	                }

	                if (totalQty !== inboundQty) {
	                    alert('출하 수량 합계가 입고 수량과 일치하지 않는 상품이 있습니다');
	                    return;
	                }

	                const outboundDate = row.querySelector('.outbound-date').value;
	                for (const store of dynamicStores) {
	                    const storeId = store.querySelector('.store-id').value;
	                    const quantity = parseInt(store.querySelector('.store-qty').value || 0, 10);

	                    if (storeId && quantity > 0) {
	                        const success = await sendOutboundStoreData('${pageContext.request.contextPath}/inbound/ship/create', goodsId, storeId, quantity, outboundDate, inboundDate);

	                        if (success) {
	                            /* const storeStockUpdated = await updateStoreStock('${pageContext.request.contextPath}/store/goods/stock', storeId, goodsId, quantity); */
	                            const totalStockUpdated = await updateTotalStock('${pageContext.request.contextPath}/goods/stock', goodsId, quantity);

	                            if (!totalStockUpdated) {
	                                alert(`재고 수정 중 오류가 발생했습니다 (상품 ID: ${goodsId}, 매장 ID: ${storeId}).`);
	                                allSuccess = false;
	                            }
	                        } else {
	                            allSuccess = false;
	                        }
	                    }
	                }
	            }
	        }

	        if (allSuccess) {
	            alert('모든 출하 입력이 성공적으로 완료되었습니다.');
	            location.reload();
	        }
	    });
	});

	</script>
</body>
</html>
