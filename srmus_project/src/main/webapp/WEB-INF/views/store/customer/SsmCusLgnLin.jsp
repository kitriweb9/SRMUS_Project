<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>로그인</title>
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
    }

    .login-card .store-login {
        background-color: #007bff;
    }

    .login-card .store-login:hover {
        background-color: #0056b3;
    }

    .login-card .hq-login {
        background-color: #6c757d;
    }

    .login-card .hq-login:hover {
        background-color: #5a6268;
    }

    .login-card .register-link {
        display: inline-block;
        margin-top: 20px;
        font-size: 14px;
        color: #007bff;
        text-decoration: none;
    }

    .login-card .register-link:hover {
        text-decoration: underline;
        color: #0056b3;
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

    /* 로그인 유형 선택 부분을 아이디 입력 창 바로 위에 위치시킴 */
    .login-type-selector {
        font-size: 14px;
        color: #333;
        margin-bottom: 20px;
    }
</style>
<script>
    function setLoginAction(actionUrl, loginType) {
        const form = document.getElementById("loginForm");
        // hidden field 추가로 로그인 유형 전달
        let loginTypeField = document.createElement("input");
        loginTypeField.type = "hidden";
        loginTypeField.name = "loginType";
        loginTypeField.value = loginType;
        form.appendChild(loginTypeField);
        
        form.action = actionUrl;
        form.submit();
    }
</script>
</head>
<body class="login-body">
    <div class="login-card">
        <h4>매장 로그인</h4>
		<form action="${pageContext.request.contextPath}/customer/login" method="post">
        <!-- 로그인 유형 선택 (아이디 입력창 바로 위) -->
        <div class="login-type-selector">
            <label><input type="radio" name="loginType" value="customer" checked> 고객 로그인</label>
            <label><input type="radio" name="loginType" value="employee"> 직원 로그인</label>
        </div>

        
            <input type="text" name="id" placeholder="아이디를 입력하세요" required>
            <input type="password" name="pwd" placeholder="패스워드를 입력하세요" required>
            
            <button type="submit" class="store-login" onclick="submitLoginForm()">로그인</button>
        </form>
        <button type="button" class="hq-login" onclick="window.location.href='${pageContext.request.contextPath}/employee/login'">본부 로그인으로 이동</button>
        <a href="${pageContext.request.contextPath}/register" class="register-link">회원가입</a> <!-- 회원가입 링크 -->
    </div>

    <!-- 공용 푸터 -->
    <footer class="login-footer">
        <small class="text-muted">Font: Yejeong, Ham / Back: Yejeong, Ham</small><br>
        <small class="text-muted">&copy; 2024 Kitri Team Project. All rights reserved.</small>
    </footer>

    <script>
        function submitLoginForm() {
            const form = document.getElementById("loginForm");
            const loginType = form.querySelector('input[name="loginType"]:checked').value;

            if (loginType === 'customer') {
                setLoginAction('${pageContext.request.contextPath}/customer/login', 'customer');
            } else {
                setLoginAction('${pageContext.request.contextPath}/employee/login', 'employee');
            }
        }
    </script>
</body>
</html>
