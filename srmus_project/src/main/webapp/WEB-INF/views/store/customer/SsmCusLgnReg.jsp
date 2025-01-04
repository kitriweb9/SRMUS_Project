<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.kitri.system.encryption.EncAesUtil" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.2/rollups/aes.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/js-sha256/0.9.0/sha256.min.js"></script>
</head>
<body>
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
	
	<form id="registrationForm" action="register" method="post">
        아이디: <input type="text" maxlength='20' name="id" required="required"> <br />
        비밀번호: <input type="password" maxlength='20' name="pwd" id="pwd" required="required"> <br />
        이름: <input type="text" name="name" id="name" required="required"> <br />
        주소: <input type="text" name="address" id="address" required="required"> <br />
        연락처: <input type="text" name="contact" id="contact" required="required"> <br />
        이메일: <input type="text" name="email" id="email" required="required"> <br />
        <input type="hidden" name="grade" value="D">
		
        <input type="submit" onclick="encryption()" value="register">
    </form>
</body>
</html>