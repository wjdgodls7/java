<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% //이 안에 Java코드를 사용 할 수 있음 %>
    <%int num =0; %>
    <%@page import="java.util.Date"%>
    <%Date time = new Date(); 
   		int a = time.getHours();
      	int b = time.getMinutes();
      	int c = time.getSeconds();
    %>
        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Num : <%= num %><br/>
	현재시간 : <%= a+"시"%><%=b+"분"%><%=c+"초"%>
</body>                                                                                                                                              
</html>