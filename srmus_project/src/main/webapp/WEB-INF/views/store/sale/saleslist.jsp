<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매내역 확인</title>
</head>
<body>
<h3>우리 매장 판매 내역</h3>
<table>
<tr><th>판매번호</th>
<th>구매번호</th>
<th>판매사원</th>
<th>판매액</th>
<th>판매일자</th>
</tr>
<c:forEach var="slist" items="${slist}">
<tr>
	<th>${slist.salesId}</th>
	<th>${slist.purchaseId}</th>
	<th>${slist.employeeId}</th>
	<th>${slist.salesAmount}</th>
	<th>${slist.salesDate}</th>
	<th>${slist.goodsId}</th>
	<th>${slist.salesQuantity}</th>
</tr>
</c:forEach>
</table>
<form name="updatecart" method="post" action="${pageContext.request.contextPath}/salmodi">
<input type="text" name="salesId" value="SL013"><br>
<input type="text" name="goodsId" value="GDS001"><br>
<input type="text" name="salesQuantity" value="1"><br>
		<input type="submit" value="판매 수량 변경">
</form>
</body>
</html>