<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록 페이지</title>
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
	<h1>MemberList.jsp</h1>
	<table>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>생년월일</th>
			<th>성별</th>
			<th>이메일</th>
			<th>상세조회</th>
			<th>탈퇴</th>
		</tr>
		<c:forEach items="${member1}" var="mem">
			<tr>
				<td>${mem.userId1}</td>
				<td>${mem.userPw}</td>
				<td>${mem.userName}</td>
				<td>${mem.userBirth}</td>
				<td>${mem.userGender}</td>
				<td>${mem.userEmail}</td>
				<td><a href="memberView?userId1=${mem.userId1}">상세조회</a></td>
				<td><a href="memberDel?userId1=${mem.userId1}">회원삭제</a></td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>






