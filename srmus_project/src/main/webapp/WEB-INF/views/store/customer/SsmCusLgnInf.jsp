<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 정보</title>
</head>
<body>
	<table>
		<tr>
			<td>사용자 아이디</td>
			<td>${user.id}</td>
		</tr>
		<tr>
			<td>사용자 이름</td>
			<td>${user.name}</td>
		</tr>
		<tr>
			<td>사용자 주소</td>
			<td>${user.address}</td>
		</tr>
		<tr>
			<td>사용자 연락처</td>
			<td>${user.contact}</td>
		</tr>
		<tr>
			<td>사용자 이메일</td>
			<td>${user.email}</td>
		</tr>
		<tr>
			<td>사용자 등급</td>
			<td>${user.grade}</td>
		</tr>
	</table>
</body>
</html>