<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<style>
body {
    background: #3d516b;
}
form {
    width: 500px;
    padding: 60px 25px 80px;
    margin: 50px auto;
    background: #f8d348;
    display: flex;
    flex-direction: column;
}
table,tr,td{
border: 1px solid black;
border-collapse: collapse;}
div{
width : 100%;
align-content: center;
}

</style>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
<form>	
<table>
    <tr>
    	<td>글번호</td>
        <td>제목</td>
        <td>닉네임</td>
        <td>작성시간</td>
        <td>조회수</td>
        <td>삭제</td>
    </tr>
		<c:forEach items="${boardList}" var="board">
			<tr>
				<td>${board.bNum}</td>
				<td><a href="boardView?bNum=${board.bNum}&page=${paging.page}">${board.bTitle}</a></td>
				<td>${board.getBwriter()}</td>
				<td>${board.bDate}</td>
				<td>${board.bHit}</td>
				<td><a href="boardDel?bNum=${board.bNum}">삭제</a></td>
			</tr>
		</c:forEach>
			</table>
			
<div>
	<c:if test="${paging.page<=1}">[이전]&nbsp;</c:if>

	<!-- 현재 페이지가 1페이지 보다 클 경우 -->
	<c:if test="${paging.page>1}">
		<a href="paging?page=${paging.page-1}">[이전]</a>
	</c:if>
	<!-- 현재 페이지 표시 -->
	<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i"
		step="1">
		<c:choose>			
			<c:when test="${i eq paging.page}">
				${i}
			</c:when>
			<c:otherwise>
				<a href="paging?page=${i}">${i}</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	
	<!-- 현재 페이지가 끝페이지 이거나 끝페이지보다 큰 경우 -->
		<c:if test="${paging.page >= paging.maxPage}">&nbsp;[다음]</c:if>

		<!-- 현재 페이지가 끝페이지보다 작은 경우 -->
		<c:if test="${paging.page < paging.maxPage}">
			&nbsp;<a href="paging?page=${paging.page+1}">[다음]</a>
		</c:if>

	<br>

<input type="button" value="글쓰기" onclick="location.href='Write.jsp'">
<input type="button" value="회원정보 조회" onclick="location.href='MemberList?name=${name}&nick=${nick}'">
<input type="button" value="로그아웃" onclick="location.href='login'">
</div>
</form>
</body>
<script>

</script>
</html>