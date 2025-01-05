<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>발주 등록</title>
</head>
<body>
    <!-- 공통 헤더 포함 -->
    <jsp:include page="/WEB-INF/views/includes2/common.jsp" />
    <jsp:include page="/WEB-INF/views/includes2/header.jsp" />

    <div class="d-flex">
        <!-- 사이드바 포함 -->
        <jsp:include page="/WEB-INF/views/includes2/sidebar.jsp" />

        <div class="main-content p-4">
            <h1>발주 등록</h1>
            <form action="${pageContext.request.contextPath}/SsmOrdGdoReg/reg" method="post" class="form-inline">
                <div class="mb-3">
                    <label for="goodsId" class="form-label">상품 ID:</label>
                    <input type="text" id="goodsId" name="goodsId" class="form-control" />
                </div>
                <div class="mb-3">
                    <label for="orderQuantity" class="form-label">수량:</label>
                    <input type="number" id="orderQuantity" name="orderQuantity" class="form-control" />
                </div>
                <input type="submit" value="등록" class="btn btn-primary" />
            </form>
        </div>
    </div>

    <!-- 공통 푸터 포함 -->
    <jsp:include page="/WEB-INF/views/includes2/footer.jsp" />
</body>
</html>
