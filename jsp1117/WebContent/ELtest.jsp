<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>기존 get 방식</h1>
	<h3>
		requst.getParamet :
		<%=request.getParameter("elName")%></h3>

	<h1>el 방식</h1>
	<h3>param : ${param.elName}</h3>

</body>
</html>