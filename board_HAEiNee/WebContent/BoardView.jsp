<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
</style>
<head>
<meta charset="UTF-8">
<title>게시판 상세보기</title>
</head>
<body>
<form>
	<table>
		<tr>
			<th>글번호</th>
			<td>${view.bNum}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${view.getBwriter()}<input type="hidden" name="nick" value=${nick}></td>
			
		</tr>
		<tr>
			<th>제목</th>
			<td>${view.bTitle}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${view.bContent}</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${view.bDate}</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${view.bHit}</td>
		</tr>
		<tr>
			<th>파일</th>
			<td><img src="fileUpload/${view.bFile}" width="200px"><br>${view.bFile}</td>
		</tr>
	</table>
	<input type="button" onclick="location.href='Modify?bNum=${view.bNum}'" value="수정하기">
	<input type="button" onclick="location.href='paging?bNum=${view.bNum}'" value="뒤로가기">
	</form>

</body>
</html>