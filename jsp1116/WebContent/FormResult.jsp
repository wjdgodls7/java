<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
Object a = request.getAttribute("sName1");
Object b = request.getAttribute("sid1");
Object c = request.getAttribute("sInfo1");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<form action="/join " method="POST">
	<body>
		<h1>DispatcherResult</h1>
		<h2>Dispatcher방식</h2>
		이름 : <%= a %><br/>
		아이디 : <%= b %><br/>
		임의의 값 : <%= c %>
	</body>
</form>
</html>