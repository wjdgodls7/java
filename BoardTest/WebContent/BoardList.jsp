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
	<h1>게시판(BoardList.jsp) 목록</h1>
	<table>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회</th>
			<th>삭제</th>
		</tr>
		<c:forEach items="${board}" var="board">
			<tr>
				<td>${board.bNum}</td>
				<td>${board.bTitle}</td>
				<td>${board.bWriter}</td>
				<td>${board.bDate}</td>
				<td><a href="boardView?bNum=${board.bNum}">조회</a></td>
				<td><a href="boardDel?bNum=${board.bNum}">삭제</a></td>
			</tr>
		</c:forEach>

	</table>
	<br>
	<button onclick="location.href='BoardWrite.jsp'">글쓰러 가기</button>

</body>
</html>