<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- [Ctrl] + [Shift] + [/] -->
<!-- 
	(1) 지시어(Directive)
		: <%-- <%@ %> --%>로 구성되어 잇는 코드
		1) page
		2) include
		3) taglib 
	1. page 지시어
			1) language
		2) extends
		3) import
		4) session
		5) errorPage
		6) contentType
		7) pageEncoding
	2. include 지시어		페이지 3개를 합칠수잇음
	3. taglib 지시어
		-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="Head.jsp"%>
	<hr />
	<h1>여기는 body부분 입니다.</h1>
	<hr />
	<%@ include file="Footer.jsp"%>
	<hr />
</body>
</html>