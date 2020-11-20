<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<table>
			<tr>
				<c:forEach items="${images}" var="imagess">
				
					<td><img src="image/${imagess}" width="200px" height="200px" alt="이미지3"/></td>
				</c:forEach>
			</tr>
		</table>
</body>
</html>