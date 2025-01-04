<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<header
	class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
	<div class="container-fluid">
		<a class="navbar-brand fw-bold" href="layout.jsp"> 매장관리시스템 :
			영업관리본부 </a>
		<div class="d-flex align-items-center">
			<span class="text-muted me-3"> <i class="bi bi-person-circle"></i>
				<a
				href="${pageContext.request.contextPath}/employee/mypage"
				class="text-decoration-none fw-bold"> 환영합니다,
					${sessionScope.user.employeeName}님 </a>
			</span>

			<form method="get" action="login.jsp" class="m-0 p-0">
				<input type="hidden" name="act" value="logout">
				<button type="submit" class="btn btn-sm btn-outline-danger">로그아웃</button>
			</form>
		</div>
	</div>
</header>
