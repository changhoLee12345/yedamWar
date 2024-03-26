<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:forward page="example19.jsp">
		<jsp:param value="hong" name="name" />
		<jsp:param value="100" name="age" />
	</jsp:forward>
</body>
</html>