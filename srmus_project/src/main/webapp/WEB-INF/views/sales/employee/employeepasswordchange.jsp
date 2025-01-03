<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원 비밀번호 변경</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/employeepasswordchangepage" method="post">
현재 비밀번호 <input type="password" name = "employeePassword">
새로운 비밀번호 <input type="password" name = "employeeNewPassword">
<button type="submit">비밀번호 변경</button>
</form>
<c:if test = "${not empty changeresult}">
<h3>${changeresult}</h3>
</c:if>
</body>
</html>