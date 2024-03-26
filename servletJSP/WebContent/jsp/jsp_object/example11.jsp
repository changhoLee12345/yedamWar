<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example11.jsp</title>
</head>
<body>
	<%
	int total = out.getBufferSize();
	out.print("첫번째 텍스트입니다");
	out.clearBuffer();
	out.print("출력버퍼의 크기: " + total);
	out.print("<br>사용하지 않은 버퍼의 크기: " + out.getRemaining());
	out.flush();
	out.print("<br>flush 후 버퍼크기: " + out.getRemaining());
	%>
	<hr>
	<%
	//out.print("10000000");
	//out.print(1000000000);
	for (int i = 0; i < 20; i++) {
		out.print("{bufferSize: " + out.getRemaining() + "}   ");
	}
	//out.print(new java.io.File("/src"));
	out.print("<br>버퍼의 크기: " + out.getRemaining());
	%>
</body>
</html>