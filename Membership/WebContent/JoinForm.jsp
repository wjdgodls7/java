<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
table,td,tr{
border : 1px solid black;
border-collapse: collapse;
text-align : left;
margin: auto;
}

</style>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="memberJoin">
<table>
	<tr>
	<td>아이디 : <input type="text" name="userId"></td>
	</tr>
	<tr>
	<td>비밀번호 : <input type="password" name="userPw"></td>
	</tr>
	<tr>
	<td>이름 : <input type="text" name="userName"></td>
	</tr>
	<tr>
	<td>생년월일 : <input type="date" name="userBirth"></td>
	</tr>
	<tr>
	<td>성별 : 남<input type="radio" name="userGender" value="남자">	여<input type="radio" name="userGender" value="여자"></td>
	</tr>
	<tr>
	<td>이메일 : <input type="email" name="userEmail"></td>
	</tr>
	<tr>
	<td><input type="submit" value="제출"></td>
	</tr>
</table>
</form>
</body>
</html>