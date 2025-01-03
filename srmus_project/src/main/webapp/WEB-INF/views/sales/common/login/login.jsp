<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<jsp:include page="/WEB-INF/views/includes/common.jsp" />
<meta charset="UTF-8">
<title>Login</title>
	<style>
	.login-container {
		height: 100vh;
	}
	
	.login-box {
		max-width: 400px;
		width: 100%;
		background-color: #fff;
		border: 1px solid #e0e0e0;
		border-radius: 8px;
		padding: 30px;
		margin: auto;
	}
	
	.login-title {
		font-size: 24px;
		margin-bottom: 20px;
	}
	
	.error-message {
		font-size: small;
		color: red;
		text-align: center;
	}
	
	</style>
	
	<script>
	    document.addEventListener("DOMContentLoaded", function() {
	    	const loginForm = document.getElementById("loginForm");
	        const password = document.getElementById("userPw");
	        	loginForm.addEventListener("submit", function(event) {
	        	event.preventDefault();
	        	password.value = sha256(password.value);
	        	console.log(password.value);
	            loginForm.submit();
	        });
	    });
	</script>
</head>
<body>
	<div
		class="container login-container d-flex flex-column justify-content-center align-items-center">
		<div class="login-box">
			<form id="loginForm" method="post" action="login">
				<ul class="nav nav-tabs mb-3" id="loginTabs" role="tablist">
					<li class="nav-item" role="presentation"
						style="margin-bottom: 5px; font-weight: bold;">본부로그인</li>
				</ul>
				<div class="mb-3">
					<label for="userId" class="form-label">아이디</label>
					<input
						type="text" class="form-control" id="userId" name="employeeId"
						placeholder="아이디를 입력하세요" required />
				</div>
				<div class="mb-3">
					<label for="userPw" class="form-label">패스워드</label>
					<input
						type="password" class="form-control" id="userPw" name="employeePassword"
						placeholder="패스워드를 입력하세요" required />
				</div>
				<button type="submit" class="btn btn-primary w-100">로그인</button>
			</form>
			<div class="error-message">
				<!-- Login Result Message -->
				<c:if test="${not empty message}">
					<div class="alert alert-danger">${message}</div>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>