<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<form action="../ServletParam" method="post" enctype="multipart/form-data">
		<input type="text" name="title" value="파일제목"><br>
		<input type="text" name="content" value="파일내용"><br>
		<input type="file" name="img"><br>
		<input type="submit" value="save">
	</form>
</body>

</html>