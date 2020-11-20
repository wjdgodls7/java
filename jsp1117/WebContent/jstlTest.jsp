<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!-- prefix="c" : 태그를 사용할때 항상 앞에 c를 붙여준다. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 변수설정 : c:set -->
	<c:set var="test" value="Hello JSTL!"/>
	<h3>c:set 사용 후 => <c:out value="${test}"/></h3>
	<!-- c:if는 참일때만 실행 -->
	<c:if test="${5<10}">
	<h3>참참참</h3>
	</c:if>
	<c:if test="${5>10}">
	<h3>거짓거짓거짓</h3>
	</c:if>
	<!-- c:choose / c:when / c:otherwise -->
	<!-- 자바에서 if문과 사용하는것이 비슷 -->
	<c:choose>
		<c:when test="${10+10 == 30}">
			<h3>참이면 출력</h3>
		</c:when>
		<c:otherwise>
			<h3>10+10은 20이다.</h3>
		</c:otherwise>
	</c:choose>
	
	<!-- c:forEach for문 -->
	<c:forEach var="num" begin="1" end="10" step="2">
		${num} &nbsp;	
	</c:forEach>
</body>
</html>