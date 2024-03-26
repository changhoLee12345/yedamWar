<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example14.jsp</title>
</head>
<body>
	<%
	String path = "example13.jsp";
	//path = request.getParameter("page");
	request.setAttribute("path", path);
	%>
	<jsp:forward page="${param.page }"></jsp:forward>
</body>
</html>