<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원상세조회 페이지</title>
<style>
table, tr, td, th {
	border: 1px solid black;
	border-collapse: collapse;
}

tr, td, th {
	padding: 5px;
}
</style>
</head>
<body>
	<h1>MemberView.jsp</h1>
	<table>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>생년월일</th>
			<th>성별</th>
			<th>이메일</th>
			<th>회원정보 수정</th>
		</tr>
		<tr>
			<td>${memberView.userId1}</td>
			<td>${memberView.userPw}</td>
			<td>${memberView.userName}</td>
			<td>${memberView.userBirth}</td>
			<td>${memberView.userGender}</td>
			<td>${memberView.userEmail}</td>
			<td><a href="modifyForm?userId1=${memberView.userId1}">정보수정</a></td>
		</tr>


	</table>

</body>
</html>






