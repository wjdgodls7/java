<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
</head>
<body>
	<form action="memberJoin" method="GET">
		<h1>회원가입</h1>
		<table>
			<tr>
				<td>아이디 :</td>
				<td><input type="text" name="userId"></td>
			</tr>
			<tr>
				<td>비밀번호 :</td>
				<td><input type="password" name="userPw"></td>
			</tr>
			<tr>
				<td>이름 :</td>
				<td><input type="text" name="userName"></td>
			</tr>
			<tr>
				<td>생년월일 :</td>
				<td><input type="date" name="userBirth"></td>
			</tr>
			<tr>
				<td>성별 :</td>
				<td><input type="radio" name="userGender" value="남자">남자 
				여자<input type="radio" name="userGender" value="여자"></td>

			</tr>
			<tr>
				<td>이메일 :</td>
				<td><input type="email" name="userEmail"></td>
			</tr>
			<tr>
				<td><input type="submit" value="가입완료"></td>
				<td><input type="reset" value="다시 작성하기"></td>
			</tr>


		</table>
	</form>
</body>
</html>