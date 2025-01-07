<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
</head>
<body>
	<form action="chksal" action="${pageContext.request.contextPath}/saleslist">

		<input type="submit" value="판매 내역 확인">
	</form><br><br>
sales 기능테스트

<form name="addsales" method="post" action="/portfolio9th/salesmain">
직원 아이디	<input type="text" name="employeeId" value="testggg"><br>
구매 아이디	<input type="text" name="purchaseId" value="PC013"><br>
			  	
			  	<input type="submit" value="판매 등록">
			  	</form>
			  	

</body>
</html>