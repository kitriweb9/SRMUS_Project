<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>재고 조회 및 수정</title>
</head>
<body>
    <!-- 공통 요소 포함 -->
    <jsp:include page="/WEB-INF/views/includes2/common.jsp" />
    <jsp:include page="/WEB-INF/views/includes2/header.jsp" />

    <div class="d-flex">
        <!-- 사이드바 포함 -->
        <jsp:include page="/WEB-INF/views/includes2/sidebar.jsp" />

        <div class="main-content p-4">
            <div class="container-fluid px-0">
                <h1>재고 목록</h1>

                <!-- 재고 목록 테이블 -->
                <div class="table-responsive mt-3">
                    <table class="table table-bordered align-middle">
                        <thead class="table-light">
                            <tr>
                                <th>Goods ID</th>
                                <th>Store ID</th>
                                <th>Stock Quantity</th>
                                <th>Safety Quantity</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="stock" items="${stockList}">
                                <tr>
                                    <td>${stock.goodsId}</td>
                                    <td>${stock.storeId}</td>
                                    <td>${stock.stockQuantity}</td>
                                    <td>${stock.stockSafetyQuantity}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>

                <hr/>

                <!-- 재고 수정 폼 -->
                <h2>재고 수정</h2>
                <form action="${pageContext.request.contextPath}/SsmStkMgtChg/update" method="post" class="mt-3">
                    <div class="mb-3">
                        <label for="goodsId" class="form-label">Goods ID:</label>
                        <input type="text" id="goodsId" name="goodsId" class="form-control" required />
                    </div>
                    <div class="mb-3">
                        <label for="storeId" class="form-label">Store ID:</label>
                        <input type="text" id="storeId" name="storeId" class="form-control" required />
                    </div>
                    <div class="mb-3">
                        <label for="stockQuantity" class="form-label">Stock Quantity:</label>
                        <input type="number" id="stockQuantity" name="stockQuantity" class="form-control" min="0" required />
                    </div>
                    <div class="mb-3">
                        <label for="stockSafetyQuantity" class="form-label">Safety Quantity:</label>
                        <input type="number" id="stockSafetyQuantity" name="stockSafetyQuantity" class="form-control" min="0" required />
                    </div>
                    <button type="submit" class="btn btn-primary">재고 수정</button>
                </form>

                <hr/>
            </div>
        </div>
    </div>

    <!-- 푸터 포함 -->
    <jsp:include page="/WEB-INF/views/includes2/footer.jsp" />
</body>
</html>
