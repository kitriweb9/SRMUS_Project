<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>상품목록</title>
    <script>
        document.addEventListener('DOMContentLoaded', function () {
            const checkboxes = document.querySelectorAll("input[type='checkbox'][name='goodsId']");
            const quantityInputs = document.querySelectorAll("input[type='number'][name='purchaseQuantity']");

            // 체크박스를 하나만 선택하도록 설정
            checkboxes.forEach((checkbox, index) => {
                checkbox.addEventListener('change', function () {
                    if (this.checked) {
                        checkboxes.forEach((cb, idx) => {
                            if (cb !== this) {
                                cb.checked = false;
                                quantityInputs[idx].disabled = true; // 다른 항목의 수량 입력 비활성화
                            }
                        });
                        quantityInputs[index].disabled = false; // 선택된 항목의 수량 활성화
                    } else {
                        quantityInputs[index].disabled = true; // 체크 해제 시 비활성화
                    }
                });
            });

            // 페이지 로드 시 모든 수량 입력 필드 비활성화
            quantityInputs.forEach(input => input.disabled = true);
        });

        // 폼 제출 시 체크된 체크박스와 수량만 전송
        function prepareForm() {
            const checkboxes = document.querySelectorAll("input[type='checkbox'][name='goodsId']");
            const quantityInputs = document.querySelectorAll("input[type='number'][name='purchaseQuantity']");

            checkboxes.forEach((checkbox, index) => {
                if (!checkbox.checked) {
                    checkbox.removeAttribute('name'); // 체크되지 않은 항목은 전송되지 않음
                    quantityInputs[index].removeAttribute('name'); // 수량 필드도 제거
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
                <h1>상품목록</h1>

                <!-- 상품 목록 폼 -->
                <form method="post" action="${pageContext.request.contextPath}/purregtest" onsubmit="prepareForm()">
                    <table class="table table-bordered align-middle">
                        <thead class="table-light">
                            <tr>
                                <th>선택</th>
                                <th>상품코드</th>
                                <th>상품분류</th>
                                <th>상품명</th>
                                <th>가격</th>
                                <th>단위</th>
                                <th>공장명</th>
                                <th>구매수량</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${goodsList}" var="goods">
                                <tr>
                                    <td>
                                        <input type="checkbox" name="goodsId" value="${goods.id}" />
                                    </td>
                                    <td>${goods.id}</td>
                                    <td>${goods.category}</td>
                                    <td>${goods.name}</td>
                                    <td>${goods.price}</td>
                                    <td>${goods.unit}</td>
                                    <td>${goods.factory}</td>
                                    <td>
                                        <input type="number" name="purchaseQuantity" value="1" min="1" style="width: 50px; text-align: center;" />
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    
                    <!-- 고객/직원 판별 -->
                    <c:choose>
                        <c:when test="${not empty sessionScope.user and sessionScope.userType == 'employee'}">
                            <!-- 직원일 경우 -->
                            <input type="hidden" name="customerId" value="" />
                            <script>
                                document.addEventListener('DOMContentLoaded', function() {
                                    const submitButton = document.querySelector("input[type='submit']");
                                    if (submitButton) {
                                        submitButton.disabled = true;
                                        submitButton.addEventListener('click', function() {
                                            alert("직원 계정으로는 상품을 구매할 수 없습니다.");
                                        });
                                    }
                                });
                            </script>
                        </c:when>
                        <c:otherwise>
                            <!-- 고객일 경우 -->
                            <input type="hidden" name="customerId" value="${sessionScope.user.id}" />
                        </c:otherwise>
                    </c:choose>
                    
                    <div style="text-align: center; margin-top: 20px;">
                        <input type="submit" value="장바구니에 담기" />
                    </div>
                </form>
            </div>
        </div>
    </div>

    <jsp:include page="/WEB-INF/views/includes2/footer.jsp" />
</body>
</html>
