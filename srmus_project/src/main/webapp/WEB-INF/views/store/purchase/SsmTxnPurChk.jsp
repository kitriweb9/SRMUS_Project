<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구매목록</title>

<script>
    document.addEventListener('DOMContentLoaded', function () {
        const checkboxes = document.querySelectorAll("input[type='checkbox'][name='goodsId']");
        
        // 체크박스를 하나만 선택하도록 설정
        checkboxes.forEach((checkbox) => {
            checkbox.addEventListener('change', function () {
                if (this.checked) {
                    checkboxes.forEach((cb) => {
                        if (cb !== this) {
                            cb.checked = false; // 다른 항목의 체크박스를 해제
                        }
                    });
                }
            });
        });
    });

    // 폼 제출 시 체크된 체크박스만 전송
    function prepareForm() {
        const checkboxes = document.querySelectorAll("input[type='checkbox'][name='goodsId']");

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
				<h1>구매목록</h1>
				<c:choose>
					<c:when test="${empty purList}">
					<!-- purList가 null이거나 비어 있을때  -->
						<br><h4>구매한 내역이 없습니다.</h4>
					</c:when>
					<c:otherwise>
					<!-- purList 값이 있을때  -->
						<form method="post"
							action="${pageContext.request.contextPath}/SsmTxnPurChg"
							onsubmit="prepareForm()">
							<table class="table table-bordered align-middle">
								<thead class="table-light">
									<tr>
										<th>선택</th>
										<th>구매번호</th>
										<th>구매일</th>
										<th>상품명</th>
										<th>구매수량</th>
										<th>총액</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${purList}" var="canpur">
										<tr>
											<td><input type="checkbox" name="purchaseId"
												value="${canpur.purchaseId}" /></td>
											<td>${canpur.purchaseId}</td>
											<td>${canpur.purchaseDate}</td>
											<td>${canpur.goodsId}<input type="hidden" name="goodsId_${canpur.purchaseId}" value="${canpur.goodsId}"></td>
											<td>${canpur.goodsName}</td>
											<td>${canpur.purchaseQuantity}<input type="hidden" name="purQty_${canpur.purchaseId}" value="${canpur.purchaseQuantity}"></td>
											<td>${canpur.purchaseAmount}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>

							<!-- 고객/직원 판별 -->
							<c:choose>
								<c:when
									test="${not empty sessionScope.user and sessionScope.userType == 'employee'}">
									<!-- 직원일 경우 -->
									<input type="hidden" name="customerId" value="" />
									<script>
                                document.addEventListener('DOMContentLoaded', function() {
                                    const submitButton = document.querySelector("input[type='submit']");
                                    if (submitButton) {
                                        submitButton.disabled = true;
                                        submitButton.addEventListener('click', function() {
                                            alert("직원 계정으로는 상품을 취소할 수 없습니다.");
                                        });
                                    }
                                });
                            </script>
								</c:when>
								<c:otherwise>
									<!-- 고객일 경우 -->
									<input type="hidden" name="customerId"
										value="${sessionScope.user.id}" />
								</c:otherwise>
							</c:choose>

							<div style="text-align: center; margin-top: 20px;">
								<input type="submit" value="구매 취소 신청" />
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
