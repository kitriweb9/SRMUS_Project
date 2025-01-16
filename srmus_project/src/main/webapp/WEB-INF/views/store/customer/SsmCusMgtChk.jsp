<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객 목록</title>
</head>
<body>
	<table>
		<tr>
			<th>고객 아이디</th>
			<th>고객 이름</th>
			<th>고객 주소</th>
			<th>고객 연락처</th>
			<th>고객 이메일</th>
			<th>고객 등급</th>
			<th></th>
		</tr>
		<c:forEach items="${customer}" var="customer">
		<tr>
			<td>${customer.id}</td>
			<td>${customer.name}</td>
			<td>${customer.address}</td>
			<td>${customer.contact}</td>
			<td>${customer.email}</td>
			<td>${customer.grade}</td>
			<td><button type="button" onclick="location.href='updateUserInfo?id=${customer.id}' ">정보 수정</button></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>