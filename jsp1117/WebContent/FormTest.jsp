<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>아이디 : <%=request.getParameter("sId")%></td>
		</tr>
			<td>비밀번호 : <%=request.getParameter("sPwd")%></td>
	</table>
</body>
</html>