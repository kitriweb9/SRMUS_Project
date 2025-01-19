<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<script src="https://cdnjs.cloudflare.com/ajax/libs/js-sha256/0.9.0/sha256.min.js"></script>
<title>본부 로그인</title>
<style>
    .login-body {
        font-family: Arial, sans-serif;
        background-color: #f7f9fc;
        margin: 0;
        padding: 0;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
        box-sizing: border-box;
    }

    .login-card {
        background-color: #ffffff;
        border: 1px solid #ddd;
        border-radius: 10px;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        padding: 40px;
        width: 400px;
        text-align: center;
    }

    .login-card h4 {
        margin-bottom: 20px;
        font-size: 24px;
        color: #333;
    }

    .login-card input[type="text"],
    .login-card input[type="password"] {
        width: calc(100% - 20px);
        padding: 12px;
        margin-bottom: 20px;
        border: 1px solid #ccc;
        border-radius: 5px;
        font-size: 14px;
        outline: none;
    }

    .login-card button {
        width: 100%;
        padding: 12px;
        border: none;
        border-radius: 5px;
        color: #fff;
        font-size: 16px;
        cursor: pointer;
        margin-bottom: 10px;
        background-color: #007bff;
    }
	.login-card .store-login {
		background-color: #6c757d;
	}

	.login-card .store-login:hover {
		background-color: #5a6268;
	}
	
    .login-card button:hover {
        background-color: #0056b3;
    }

    .login-card .error-message {
        font-size: small;
        color: red;
        text-align: center;
    }

    .login-footer {
        width: 100%;
        background-color: #f7f9fc;
        text-align: center;
        padding: 10px 0;
        font-size: 12px;
        color: #666;
        position: relative;
        margin-top: 20px;
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
<body class="login-body">
    <div class="login-card">
        <h4>본부 로그인</h4>
        <form id="loginForm" method="post" action="login">
            <div>
                <label for="userId" class="form-label"></label>
                <input type="text" id="userId" name="employeeId" placeholder="아이디를 입력하세요" required>
            </div>
            <div>
                <label for="userPw" class="form-label"></label>
                <input type="password" id="userPw" name="employeePassword" placeholder="패스워드를 입력하세요" required>
            </div>
            <button type="submit">로그인</button>
            <button type="button" class="store-login" onclick="window.location.href='${pageContext.request.contextPath}/'">매장 로그인으로 이동</button>
            
        </form>
        <c:if test="${not empty message}">
            <div class="error-message">${message}</div>
        </c:if>
    </div>

    <!-- 공용 푸터 -->
    <footer class="login-footer">
        <small class="text-muted">Front: [Yejeong, Ham] [Ansik, Jung] [Yulkung, Kim]</small><br>
        <small class="text-muted">Back: [Yejeong, Ham] [Ansik, Jung] [Yulkung, Kim] [YoungEun, Hyun] [Eunseo, Moon] [Siyeon, Park]</small><br>
        <small class="text-muted">&copy; 2024 Kitri Team Project. All rights reserved.</small>
    </footer>
</body>
</html>
