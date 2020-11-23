<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<body>
	<h1><a href="JoinForm.jsp">회원가입 페이지로</a></h1>
	<h1><a href="memberList">회원조회 페이지로</a></h1>
	<h1><a href="Login.jsp">로그인 페이지로</a></h1>
	<h1><a href="logout">로그아웃</a></h1>
	<hr/>
	<button onclick="joinform()">회원가입 페이지로</button>
	<button onclick="memberlist()">회원조회 페이지로</button>
</body>

<script>
	function joinform(){
		location.href="JoinForm.jsp";
	}
	
	function memberlist(){
		location.href="memberList";
	}
</script>
</html>