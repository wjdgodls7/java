<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
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
	<h1>게시판(BoardView.jsp)상세보기</h1>
	<table>
		<tr>
			<th>글번호</th>
			<td>${view.bNum}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${view.bWriter}</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>${view.bPassword}</td>
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
	<button onclick="location.href='bModify?bNum=${view.bNum}'">수정하기</button>

</body>
</html>