<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header
	class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
	<div class="container-fluid">

		<a class="navbar-brand fw-bold" href="${pageContext.request.contextPath}/customer/goods"> 매장관리시스템 :
			매장ST001 </a>
		<div class="d-flex align-items-center">
			<span class="text-muted me-3"> <i class="bi bi-person-circle"></i>
				<a
				href="${pageContext.request.contextPath}/userInfo"
				class="text-decoration-none fw-bold"> 환영합니다,
					<c:choose>
						<c:when test="${sessionScope.userType == 'employee'}">
							${sessionScope.user.employeeName}님
						</c:when>
						<c:otherwise>
							${sessionScope.user.name}님
						</c:otherwise>
					</c:choose>
				</a>
			</span>

			<form method="get" action="${pageContext.request.contextPath}/customer/logout" class="m-0 p-0">
				<button type="submit" class="btn btn-sm btn-outline-danger">로그아웃</button>
			</form>
		</div>
	</div>
</header>
