<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정페이지</title>
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
	<h1>현재 회원정보</h1>
	
	<br/>현재 아이디 : ${memberModify.userId1}
	<br/>현재 비밀번호: ${memberModify.userPw}
	<br/>현재 이름 : ${memberModify.userName}
	<br/>현재 생년월일 : ${memberModify.userBirth}
	<br/>현재 성별 : ${memberModify.userGender}
	<br/>현재 이메일 : ${memberModify.userEmail}
	
	<hr/><br/>
	<form action="modiProcess" name="modiForm">
	<br/>아이디 : ${memberModify.userId1}
	<input type="hidden" value="${memberModify.userId1}" name="userId1">
	<br/>현재 비밀번호: <input type="password" id="checkPw">
	<br/>변경할 비밀번호: <input type="password" name="userPw">
	<br/>변경할 이름 : <input type="text" name="userName">
	<br/>변경할 생년월일 : <input type="text" name="userBirth"> 
	<br/>변경할 성별 : <input type="text" name="userGender">
	<br/>변경할 이메일 : <input type="text" name="userEmail">
	</form>
	<button onclick="memberModify()">수정</button>
	
</body>
<script>
	function memberModify(){
		var passwordConfirm = document.getElementById("checkPw").value;
		var password = "${memberModify.userPw}";
		
		if(passwordConfirm == password){
			modiForm.submit();
		} else {
			alert('비밀번호가 틀립니다.');
		}
		
		
		
	}
</script>


</html>













