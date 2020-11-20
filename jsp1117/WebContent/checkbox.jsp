<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table, td, tr {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="checkbox">
	<table>
		<tr>
			<td><img src="image/9919836.jpg" alt="골든리트리버" width="200px" height="200px"></td>
			<td><img src="image/KakaoTalk1.jpg" alt="이미지" width="200px" height="200px"></td>
			<td><img src="image/KakaoTalk1.jpg" alt="이미지2"  width="200px" height="200px"></td>
			<td><img src="image/KakaoTalk1.jpg" alt="이미지3"  width="200px" height="200px">
            </td>
		</tr>
		<tr>
			<td><input type="checkbox" name="pick" value="9919836.jpg"></td>
			<td><input type="checkbox" name="pick" value="KakaoTalk1.jpg"></td>
			<td><input type="checkbox" name="pick" value="KakaoTalk1.jpg"></td>
			<td><input type="checkbox" name="pick" value="KakaoTalk1.jpg"></td>
		</tr>
	</table>
	<input type = "submit" value ="선택">
</form>

</body>
</html>