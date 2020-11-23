<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
	<form action="login" method="GET">
		<h1>로그인</h1>
		<table>
			<tr>
				<td>아이디 :</td>
				<td><input type="text" name="userId"></td>
			</tr>
			<tr>
				<td>비밀번호 :</td>
				<td><input type="password" name="userPw"></td>
			</tr>
		</table>
		<input type="submit" value="로그인">
	</form>
</body>
</html>