<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>회원 목록</title>
</head>
<body>
<form>
<table>
	<tr>
	<td>아이디</td>
	<td>이름</td>
	<td>성별</td>
	<td>주소</td>
	<td>닉네임</td>
	<td>상세보기</td>
	<td>탈퇴</td>
	</tr>
	<c:forEach items="${list}" var = "mem" >
	<tr>
	<td>${mem.memberId}</td>
	<td>${mem.memberName}</td>
	<td>${mem.userGender}</td>
	<td>${mem.memberAdd}</td>
	<td>${mem.memberEmail}</td>
	<td><a href="memberview?name=${mem.memberName}&nick=${mem.memberEmail}">상세조회</a></td>
	<td><a href="memberdel?name=${mem.memberName}&nick=${mem.memberEmail}">탈퇴</a></td>
	</tr>
	</c:forEach>
	</table>
	<input type="button" value="게시판으로" onclick="location.href='Board_Main.jsp'">
	</form>
</body>
</html>