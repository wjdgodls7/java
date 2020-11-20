<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

		<h1>로그인</h1>
		<table>
			<tr>
				<td>아이디 :<%=request.getAttribute("sId") %></td>
			</tr>
			<tr>
				<td>비밀번호 :<%=request.getAttribute("sPwd") %></td>
			</tr>
		</table>

</body>
</html>