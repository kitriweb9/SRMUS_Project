<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>반품</title>
</head>
<body>
<h3>수정 결과</h3>

<table>
<tr><th>반품 아이디</th>
<th>담당 직원</th>
<th>반품 등록일</th>
<th>상품명</th>
<th>상품 수량</th>
</tr>
<c:forEach var="rlist" items="${rlist}">
<tr>
	<th>${rlist.returnId}</th>
	<th>${rlist.employeeId}</th>
	<th>${rlist.returnRegisterDate}</th>
	<th>${rlist.goodsId}</th>
	<th>${rlist.returnQuantity}</th>
</tr>
</c:forEach>
</table>
</body>
</html>