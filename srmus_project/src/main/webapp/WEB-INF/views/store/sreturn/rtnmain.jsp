<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
</head>
<body>
	ssm return 기능테스트
<!-- 
	<form action="chkpur" method="post"
		action="${pageContext.request.contextPath}/rtnlist">
		<input type="submit" value="반품 조회">
	</form>
	 -->
	<form name="return_reg_test" method="post"
		action="${pageContext.request.contextPath}/addrtn">
		직원 아이디 <input type="text" name="employeeId" value="testggg"><br>
		반품 상품 코드 <input type="text" name="goodsId" value="GDS001"><br>
		반품 수량 <input type="text" name="returnQuantity" value="2"><br>

		<input type="submit" value="반품 등록">
	</form>


</body>
</html>