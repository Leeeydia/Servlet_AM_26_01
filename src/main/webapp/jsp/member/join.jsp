<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

	<h1>회원가입</h1>

	<form action="doJoin" method="POST">
		<div>
			<input type="text" name="loginId" placeholder="아이디 입력">
		</div>

		<div>
			<input type="password" name="loginPw" placeholder="비밀번호 입력">
		</div>

		<div>
			<input type="submit" value="로그인">
		</div>
	</form>

	<a href="/home/main">메인으로</a>

</body>
</html>
