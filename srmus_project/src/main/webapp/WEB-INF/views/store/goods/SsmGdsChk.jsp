<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품목록</title>
</head>
<body>
	<button type="button" onclick="location.href='customer/logout' ">로그아웃</button>
	<button type="button" onclick="location.href='userInfo' ">사용자 정보</button>
	<table>
		<tr>
			<th>상품코드</th>
			<th>상품분류</th>
			<th>상품명</th>
			<th>가격</th>
			<th>단위</th>
			<th>공장명</th>
		</tr>
		<c:forEach items="${goodsList}" var="goodsList">
		<tr>
			<td>${goodsList.id}</td>
			<td>${goodsList.category}</td>
			<td>${goodsList.name}</td>
			<td>${goodsList.price}</td>
			<td>${goodsList.unit}</td>
			<td>${goodsList.factory}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>