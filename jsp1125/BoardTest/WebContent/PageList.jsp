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
	<h1>페이징처리 게시판(PageList.jsp)</h1>
	<table>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>삭제</th>
		</tr>
		<c:forEach items="${boardList}" var="board">
			<tr>
				<td>${board.bNum}</td>
				<td><a href="boardView?bNum=${board.bNum}&page=${paging.page}">${board.bTitle}</a></td>
				<td>${board.bWriter}</td>
				<td>${board.bDate}</td>
				<td><a href="boardDel?bNum=${board.bNum}">삭제</a></td>
			</tr>
		</c:forEach>

	</table>

	<!-- 페이징 처리 -->

	<!-- 현재 페이지 1페이지 이거나 1페이지보다 작은 경우 -->
	<c:if test="${paging.page<=1}">[이전]&nbsp;</c:if>

	<!-- 현재 페이지가 1페이지 보다 클 경우 -->
	<c:if test="${paging.page>1}">
		<a href="pagingList?page=${paging.page-1}">[이전]</a>&nbsp;
	</c:if>

	<!-- 현재 페이지 표시 -->
	<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i"
		step="1">
		<c:choose>
			
			<c:when test="${i eq paging.page}">
				${i}
			</c:when>
			<c:otherwise>
				<a href="pagingList?page=${i}">${i}</a>

			</c:otherwise>

		</c:choose>

	</c:forEach>
	
	<!-- 현재 페이지가 끝페이지 이거나 끝페이지보다 큰 경우 -->
		<c:if test="${paging.page >= paging.maxPage}">&nbsp;[다음]</c:if>

		<!-- 현재 페이지가 끝페이지보다 작은 경우 -->
		<c:if test="${paging.page < paging.maxPage}">
			&nbsp;<a href="pagingList?page=${paging.page+1}">[다음]</a>
		</c:if>

	<br>
	<button onclick="location.href='BoardWrite.jsp'">글쓰러 가기</button>

</body>
</html>