<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매 승인</title>

<script>
    document.addEventListener('DOMContentLoaded', function () {
        const checkboxes = document.querySelectorAll("input[type='checkbox'][name='salesId']");    
    });

    // 폼 제출 시 체크된 체크박스만 전송
    function prepareForm() {
        const checkboxes = document.querySelectorAll("input[type='checkbox'][name='salesId']");

        checkboxes.forEach((checkbox) => {
            if (!checkbox.checked) {
                checkbox.removeAttribute('name'); // 체크되지 않은 항목은 전송되지 않음
            }
        });
    }
</script>

</head>
<body>
	<jsp:include page="/WEB-INF/views/includes2/common.jsp" />
	<jsp:include page="/WEB-INF/views/includes2/header.jsp" />

	<div class="d-flex">
		<jsp:include page="/WEB-INF/views/includes2/sidebar.jsp" />

		<div class="main-content p-4">
			<div class="container-fluid px-0">
				<h1>판매 승인</h1>
				<c:choose>
					<c:when test="${empty salList}">
					<!-- salList가 null이거나 비어 있을때  -->
                   		<br><h4>판매 승인이 필요한 내역이 없습니다.</h4>
					</c:when>
					<c:otherwise>
					<!-- salList 값이 있을때  -->
						<form method="post"
							action="${pageContext.request.contextPath}/SsmTxnSalApr"
							onsubmit="prepareForm()">
							<table class="table table-bordered align-middle">
								<thead class="table-light">
									<tr>
										<th>선택</th>
										<th>판매번호</th>
										<th>구매번호</th>
										<th>상품번호</th>
										<th>상품수량</th>
										<th>판매총액</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${salList}" var="aprsal">
										<tr>
											<td><input type="checkbox" name="salesId"
												value="${aprsal.salesId}" /></td>
											<td>${aprsal.salesId}</td>
											<td>${aprsal.purchaseId}</td>
											<td>${aprsal.goodsId}</td>
											<td>${aprsal.salesQuantity}</td>
											<td>${aprsal.salesAmount}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>


							<div style="text-align: center; margin-top: 20px;">
								<input type="submit" value="판매 승인 처리" />
							</div>
						</form>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/includes2/footer.jsp" />
</body>
</html>
