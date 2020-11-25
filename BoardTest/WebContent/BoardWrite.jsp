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
</style>
</head>
<body>
	<h1>글작성(BoardWrite.jsp) 페이지</h1>
	<form action="boardWrite" name="boardWirteForm" method="POST" enctype="multipart/form-data">
		<table>

			<tr>
				<th>제목</th>
				<td><input type="text" name="bTitle" size="40"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="bWriter" size="40"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="bPassword" size="40"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="20" cols="40" name="bContent"></textarea></td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td><input type="file" name="bFile"></td>
			</tr>

			<tr style="text-align: center;">
				<td colspan="2"><button onclick="bwrite()">글작성</button> 
				<input type="button" onclick="boardList()" value="목록보기">
				<input type="button" onclick="pageList()" value="페이징처리"> 
					
			</tr>
		</table>
	</form>

</body>
<script>
	function bwrite() {
		boardWriteForm.submit();
	}

	function boardList() {
		location.href = "bList";
	}
	
	function pageList() {
		location.href = "pagingList";
	}
</script>
</html>








