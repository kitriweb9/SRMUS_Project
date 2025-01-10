<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>구매 취소 목록</title>    
</head>
<body>
    <jsp:include page="/WEB-INF/views/includes2/common.jsp" />
    <jsp:include page="/WEB-INF/views/includes2/header.jsp" />

    <div class="d-flex">
        <jsp:include page="/WEB-INF/views/includes2/sidebar.jsp" />
        
        <div class="main-content p-4">
            <div class="container-fluid px-0">
                <h1>구매 취소 목록</h1>
                
                <c:choose>
                	<c:when test="${empty purList}">
                	<!-- purList가 null이거나 비어 있을때  -->
                   		 <h3>구매 취소한 내역이 없습니다.</h3>
                    </c:when>
                    <c:otherwise>
                	<!-- purList 값이 있을때  -->
	                    <table class="table table-bordered align-middle">
	                        <thead class="table-light">
	                            <tr>
	                                <th>구매번호</th>
	                                <th>취소일</th>
	                                <th>상품명</th>
	                                <th>구매수량</th>
	                                <th>총액</th>
	                            </tr>
	                        </thead>
	                        <tbody>
	                            <c:forEach items="${purList}" var="canpur">
	                                <tr>
	                                    <td>${canpur.purchaseId}</td>
	                                    <td>${canpur.purchaseDate}</td>
	                                    <td>${canpur.goodsName}</td>
	                                    <td>${canpur.purchaseQuantity}</td>
	                                    <td>${canpur.purchaseAmount}</td>
	                                </tr>
	                            </c:forEach>
	                        </tbody>
	                    </table>
                  </c:otherwise>
               </c:choose>
            </div>
        </div>
    </div>

    <jsp:include page="/WEB-INF/views/includes2/footer.jsp" />
</body>
</html>
