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
sales 기능테스트
입력한 sales id의 sales_status를 N에서 Y로 변경

<form name="form1" method="post" action="/portfolio9th/salapr">
sales status	<input type="text" name="salesId" value="SL001"><br>
			  	
			  	<input type="submit" value="판매 상태 변경">
			  	</form>
</body>
</html>