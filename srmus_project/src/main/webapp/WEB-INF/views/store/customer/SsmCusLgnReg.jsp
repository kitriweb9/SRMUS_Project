<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
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

    .login-card .register-submit {
        background-color: #007bff;
    }

    .login-card .register-submit:hover {
        background-color: #0056b3;
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
<script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.2/rollups/aes.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/js-sha256/0.9.0/sha256.min.js"></script>
<script>
    function encryption() {
        let pwTemp = null;

        let pwd = document.querySelector("#pwd");
        var name = document.getElementById("name").value;
        var address = document.getElementById("address").value;
        var contact = document.getElementById("contact").value;
        var email = document.getElementById("email").value;
        
        var key = "TKATLQDLQKDLXMZL32KEYVMFKDLQPDLX";
        var IV = key.substring(0, 16);
        
        function encToHex(data, key, iv){
            // 암호화
            let encrypted = CryptoJS.AES.encrypt(data, CryptoJS.enc.Utf8.parse(key), {
                iv: CryptoJS.enc.Utf8.parse(iv),
                mode: CryptoJS.mode.CBC,
                padding: CryptoJS.pad.Pkcs7
            });
            return encrypted.toString();
        }
        
        pwTemp = sha256(pwd.value);
        pwd.value = pwTemp;
        
        document.getElementById("name").value = encToHex(name, key, IV);
        document.getElementById("address").value = encToHex(address, key, IV);
        document.getElementById("contact").value = encToHex(contact, key, IV);
        document.getElementById("email").value = encToHex(email, key, IV);
        
        confirm("회원가입 하시겠습니까?");
        document.getElementById('registrationForm').submit();
    };
</script>
</head>
<body class="login-body">
    <div class="login-card">
        <h4>회원 가입</h4>
        <form id="registrationForm" method="post" action="${pageContext.request.contextPath}/register">
            <input type="text" name="id" placeholder="아이디 입력" maxlength="20" required>
            <input type="password" name="pwd" id="pwd" placeholder="비밀번호 입력" maxlength="20" required>
            <input type="text" name="name" id="name" placeholder="이름 입력" required>
            <input type="text" name="address" id="address" placeholder="주소 입력" required>
            <input type="text" name="contact" id="contact" placeholder="연락처 입력" required>
            <input type="text" name="email" id="email" placeholder="이메일 입력" required>
            <input type="hidden" name="grade" value="D">
            <button type="button" class="register-submit" onclick="encryption()">회원 가입</button>
        </form>
    </div>

    <!-- 공용 푸터 -->
    <footer class="login-footer">
        <small class="text-muted">Font: Yejeong, Ham / Back: Yejeong, Ham</small><br>
        <small class="text-muted">&copy; 2024 Kitri Team Project. All rights reserved.</small>
    </footer>
</body>
</html>
