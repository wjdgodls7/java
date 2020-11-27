<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style type="text/css">
body {
    background: #3d516b;
}
form {
    width: 320px;
    padding: 60px 25px 80px;
    margin: 50px auto;
    background: #f8d348;
    display: flex;
    flex-direction: column;
}
table,tr,td{
text-align: left;}

</style>
</head>
<body>
<form action="memberJoin" method="POST">
<table>
	<tr>
	<td>아이디 : <input type="text" name="userId"></td>
	</tr>
	<tr>
	<td>비밀번호 : <input type="password" name="userPwd"></td>
	</tr>
	<tr>
	<td>이름 : <input type="text" name="userName"></td>
	</tr>
	<tr>
	<td>성별 : 남<input type="radio" name="userGender" value="남자">	여<input type="radio" name="userGender" value="여자"></td>
	</tr>
	<tr>
	<td>주소 : <input type="text" name="userAdd"></td>
	</tr>
	<tr>
	<td>닉네임 : <input type="text" name="userEmail"></td>
	</tr>
	<tr>
	<td><input type="submit" value="제출"></td>
	</tr>
</table>
</form>
</body>
</html>