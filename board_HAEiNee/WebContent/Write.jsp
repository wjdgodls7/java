<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
table,tr,td{
border: 1px solid black;
border-collapse: collapse;}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Write" name="boardWirteForm" method="POST" enctype="multipart/form-data">
		<table>
			<tr>
				<th>제목</th>
				<td><input type="text" name="Title" size="40"></td>
			</tr>
			<tr>
				<th>닉네임</th>
				<td>${nick}</td>
				<input type="hidden" name="nick" value="${nick}">
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="20" cols="40" name="Content"></textarea></td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td><input type="file" name="File"></td>
			</tr>

			<tr style="text-align: center;">
				<td colspan="2"><button onclick="location.href='Write'">글 작성</button>
				<input type="button" onclick="location.href='paging'" value="목록보기">
					</td>
			</tr>
		</table>
	</form>

</body>
</html>