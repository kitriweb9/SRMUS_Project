<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 정보 수정</title>
</head>
<body>
	<form id="editForm" action="updateUserInfo" method="post">
		<input type="hidden" name="id" id="id" value="${id}">
        이름: <input type="text" name="name" id="name" required="required"> <br />
        주소: <input type="text" name="address" id="address" required="required"> <br />
        연락처: <input type="text" name="contact" id="contact" required="required"> <br />
        이메일: <input type="text" name="email" id="email" required="required"> <br />
		
        <input type="submit" value="edit">
    </form>
</body>
</html>