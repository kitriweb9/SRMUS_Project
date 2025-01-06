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
	반품 관련 데이터 변경
	

	<br>
	<br> 입력한 return id의 return_status를 N에서 Y로 변경
	<br>

	<form name="return_modi_status" method="post"
		action="${pageContext.request.contextPath}/rtnmodirs">
		return id <input type="text" name="returnId" value="RT001"><br>

		<input type="submit" value="반품 상태 변경">
	</form>
	
	<br>
	<br> 입력한 return id의 goods_id를 변경
	<br>

	<form name="return_modi_goodsid" method="post"
		action="${pageContext.request.contextPath}/rtnmodigid">
		return id <input type="text" name="returnId" value="RT001"><br>
		goods id <input type="text" name="returnId" value="GDS001"><br>

		<input type="submit" value="반품 상품 변경">
	</form>
	
	<br>
	<br> 입력한 return id의 return_quantity를 변경
	<br>

	<form name="return_modi_goodsqty" method="post"
		action="${pageContext.request.contextPath}/rtnmodiqty">
		return id <input type="text" name="returnId" value="RT001"><br>
		return Qty <input type="text" name="returnQuantity" value="3"><br>

		<input type="submit" value="반품 수량 변경">
	</form>
		
	<br>
	<br> 입력한 return id를 삭제
	<br>

	<form name="return_delete" method="post"
		action="${pageContext.request.contextPath}/rtndel">
		return id <input type="text" name="returnId" value="RT001"><br>

		<input type="submit" value="반품 이력 삭제">
	</form>

</body>
</html>