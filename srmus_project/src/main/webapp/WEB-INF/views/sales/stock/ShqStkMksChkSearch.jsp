<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>영업관리본부: 매장별 상품 재고 조회</title>
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
					<h5>매장별 상품 재고 조회</h5>
					<div class="table-responsive mt-3">
						<table class="table table-bordered project-table align-middle">
							<thead class="table-light">
								<tr>
									<th style="max-width:20px; text-align: center;">선택</th>
									<th>매장 ID</th>
									<th>매장 이름</th>
									<th>상품 ID</th>
									<th>상품명</th>
									<th>재고 수량</th>
									<th>업데이트 일자</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="good" items="${goods}">
									<tr>
										<td style="text-align: center">
											<input type="checkbox" class="row-checkbox" />
										</td>
										<td>${good.storeId}</td>
										<td>매장 이름</td>
										<td>${good.goodsId}</td>
										<td>${good.goodsName}</td>
										<td>
											<input type="number" class="form-control inbound-qty" value="${good.qty}" 
												  data-id="${good.goodsId}" 
												  data-store-id="${good.storeId}"/>
										</td>
										<td>${good.updateDate}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="search-bar">
						<input type="text" class="form-control search-input" id="store-search" placeholder="매장 ID 검색">
						<button class="btn btn-sm btn-outline-primary" id="search-button">검색</button>
						<a href="${pageContext.request.contextPath}/store/goods/stock" class="btn btn-sm btn-outline-primary" id="search-button">전체 조회</a>
						<div class="button-bar ms-auto">
							<button class="btn btn-sm btn-outline-success" id="update-selected">선택수정</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/includes/footer.jsp" />
	<script>
	    // 행 데이터 추출 함수
	    function extractRowData(row) {
	        const formData = new FormData();
	        formData.append('goodsId', row.querySelector('.inbound-qty').dataset.id);
	        formData.append('qty', row.querySelector('.inbound-qty').value);
	        formData.append('storeId', row.querySelector('.inbound-qty').dataset.storeId);
	        return formData;
	    }
	
	    // 개별 데이터 전송 함수
	    async function sendRowData(url, formData) {
	        const response = await fetch(url, {
	            method: 'POST',
	            body: formData, // Content-Type은 자동으로 설정
	        });
	        return response.ok;
	    }
	
	    // 체크된 행이 있는지 확인하는 함수
	    function hasCheckedRows() {
	        return document.querySelectorAll('.row-checkbox:checked').length > 0;
	    }
	
	    document.addEventListener('DOMContentLoaded', function () {
	        // 수량 변경 시 체크박스 자동 체크
	        document.querySelectorAll('.inbound-qty').forEach(function (input) {
	            input.addEventListener('change', function () {
	                const row = this.closest('tr');
	                row.querySelector('.row-checkbox').checked = true;
	            });
	        });
	
	        // 선택 수정 버튼 클릭 시 체크된 행마다 개별적으로 데이터 전송
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
	                    const formData = extractRowData(row);
	                    const success = await sendRowData('${pageContext.request.contextPath}/store/goods/stock/change', formData);
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
	    });
	    
	 	//매장 검색
		document.getElementById('search-button').addEventListener('click', function () {
			const searchInput = document.getElementById('store-search').value.trim();
			if (searchInput) {
				window.location.href = '${pageContext.request.contextPath}/store/goods/stock/' + searchInput;
			} else {
				alert('검색어를 입력하세요.');
			}
		});
	</script>

</body>
</html>
