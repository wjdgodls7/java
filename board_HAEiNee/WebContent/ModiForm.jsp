<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, tr, td, th {
	border: 1px solid black;
	border-collapse: collapse;
}

td, th {
	padding: 5px;
}
body {
    background: #3d516b;
}
form {
    width: 400px;
    padding: 60px 25px 80px;
    margin: 50px auto;
    background: #f8d348;
    display: flex;
    flex-direction: column;
}
</style>
</head>
<body>
	<form action="realModi" name="boardModiForm">
		<table>
			<tr>
				<th>글번호</th>
				<td>${bNum}</td>
				<input type="hidden" value="${bNum}" name="bNum">
			</tr>
			<tr>
				<th>닉네임</th>
				<td>${nick}</td>
				<input type="hidden"name="nick" value=${nick}>
				
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text"name="bTitle" size="40"></td>
				
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="20" cols="40" name="bContent"></textarea></td>
			</tr>

			<tr style="text-align: center;">
				<td colspan="2"><button onclick="realModi">수정</button> 
				<input type="button" onclick="paging'" value="목록보기"> 
					
			</tr>
		</table>
	</form>

</body>
</html>