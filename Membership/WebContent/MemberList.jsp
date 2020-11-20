<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table,td,tr{
border : 1px solid black;
border-collapse: collapse;
}
</style>
<meta charset="utf-8">
<title>asdf</title>
</head>
<body>

	<table>
	<tr>
	<td>아이디</td>
	<td>비밀번호</td>
	<td>이름</td>
	<td>생일</td>
	<td>성별</td>
	<td>이메일</td>
	<td>상세조회</td>
	<td>탈퇴</td>
	</tr>
	<c:forEach items="${member1}" var = "mem" >
	<tr>
	<td>${mem.userId}</td>
	<td>${mem.userPw}</td>
	<td>${mem.userName}</td>
	<td>${mem.userBirth}</td>
	<td>${mem.userGender}</td>
	<td>${mem.userEmail}</td>
	<td>상세조회</td>
	<td>탈퇴</td>
	</tr>
	
	</c:forEach>
	
	</table>
	
	

</body>
</html>