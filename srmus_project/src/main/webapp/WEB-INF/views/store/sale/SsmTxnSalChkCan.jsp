<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>판매 취소 내역</title>    
</head>
<body>
    <jsp:include page="/WEB-INF/views/includes2/common.jsp" />
    <jsp:include page="/WEB-INF/views/includes2/header.jsp" />

    <div class="d-flex">
        <jsp:include page="/WEB-INF/views/includes2/sidebar.jsp" />
        
        <div class="main-content p-4">
            <div class="container-fluid px-0">
                <h1>판매 취소 내역</h1>
                
                <c:choose>
                	<c:when test="${empty salList}">
                	<!-- salList가 null이거나 비어 있을때  -->
                   		 <h3>판매 취소된 내역이 없습니다.</h3>
                    </c:when>
                    <c:otherwise>
                	<!-- salList 값이 있을때  -->
	                    <table class="table table-bordered align-middle">
	                        <thead class="table-light">
	                            <tr>
									<th>판매번호</th>
									<th>구매번호</th>
									<th>상품번호</th>
									<th>상품수량</th>
									<th>판매총액</th>
									<th>판매승인일</th>
									<th>담당직원</th>
	                            </tr>
	                        </thead>
	                        <tbody>
	                            <c:forEach items="${salList}" var="aprsal">
	                                <tr>
										<td>${aprsal.salesId}</td>
										<td>${aprsal.purchaseId}</td>
										<td>${aprsal.goodsId}</td>
										<td>${aprsal.salesQuantity}</td>
										<td>${aprsal.salesAmount}</td>
										<td>${aprsal.salesDate}</td>
										<td>${aprsal.employeeId}</td>
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
