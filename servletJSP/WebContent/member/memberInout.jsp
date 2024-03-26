<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>

<body>
	<h3>회원가입</h3>
	<form action="memberProc.jsp" method="post">
		ID: <input type="text" name="id"><br>
		PW: <input type="password" name="passwd"><br>
		Name: <input type="text" name="name"><br>
		Mail: <input type="text" name="mail"><br>
		<input type="submit" value="Register"><input type="reset" value="Reset">
	</form>
</body>

</html>