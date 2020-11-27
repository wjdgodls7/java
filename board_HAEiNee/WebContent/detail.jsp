<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
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
</style>
<meta charset="UTF-8">
<title>회원 자세히 보기</title>
</head>
<body>
<form>
<h1>회원정보 상세보기</h1>
	<table>
		<tr>
			<th>아이디</th>
			<td>${userId}</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>${userPwd}</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${userName}</td>
		</tr>
		<tr>
			<th>성별</th>
			<td>${userGender}</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>${userAdd}</td>
		</tr>
		<tr>
			<th>닉네임</th>
			<td>${userEmail}</td>
		</tr>
		</table>
				<input type ="button" value="뒤로" onclick="location.href='MemberList'">
		</form>

</body>
</html>