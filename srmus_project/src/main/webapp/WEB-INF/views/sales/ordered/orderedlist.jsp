<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>통합 발주 화면</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="/WEB-INF/views/includes/header.jsp" />
	<div class="d-flex">
		<jsp:include page="/WEB-INF/views/includes/sidebar.jsp" />
		<div class="main-content p-4">
			<div class="container-fluid px-0">
				<div class="my-3">
<c:if test="${not empty result}">
<script type="text/javascript">
 alert("${result}");
</script>
</c:if>
<form action="${pageContext.request.contextPath}/integrationserach" method="post">
날짜 <input type ="date" name="inputDate" required="required"><br/><br/>
<button type="submit">검색</button>
</form>
<c:if test="${not empty integration}">
<table class="table table-bordered project-table align-middle">
<thead class="table-light">
<tr>
<th>발주 날짜</th>
<th>상품명</th>
<th>총합</th>
</tr>
</thead>
<tbody>
<c:forEach var="integration" items="${integration}">
<tr>
<td>${integration.integrationConfirmDate}</td>
<td>${integration.goodsName}</td>
<td>${integration.totalQuantity}</td>
<td>
</td>
</tr>
</c:forEach>
</tbody>
</table>
</c:if>
</div>
</div>
</div>
</div>
<jsp:include page="/WEB-INF/views/includes/footer.jsp" />
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="js/main.js"></script>
</body>
</html>