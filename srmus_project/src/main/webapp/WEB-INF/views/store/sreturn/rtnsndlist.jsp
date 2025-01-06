<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>반품 송신</title>
</head>
<body>

	<form name="ssmreturnsend" method="post"
		action="${pageContext.request.contextPath}/ssmrtnsnd">



		<h3>반품 송신 목록</h3>
		<table>
			<tr>
				<th>반품 아이디</th>
				<th>담당 직원</th>
				<th>반품 등록일</th>
				<th>상품명</th>
				<th>상품 수량</th>
			</tr>
			<c:forEach var="rlist" items="${rlist}">
				<tr>
					<th><input type="hidden" name="returnId" value="${rlist.returnId}" />${rlist.returnId}</th>
					<th><input type="hidden" name="employeeId" value="${rlist.employeeId}" />${rlist.employeeId}</th>
					<th><input type="hidden" name="returnRegisterDate" value="${rlist.returnRegisterDate}" />${rlist.returnRegisterDate}</th>
					<th><input type="hidden" name="goodsId" value="${rlist.goodsId}" />${rlist.goodsId}</th>
					<th><input type="hidden" name="returnQuantity" value="${rlist.returnQuantity}" />${rlist.returnQuantity}</th>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="반품 목록 보내기">
	</form>
</body>
</html>