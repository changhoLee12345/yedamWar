<%@page import="com.edu.beans.BookBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<%
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String publisher = request.getParameter("publisher");
		BookBean book = (BookBean) request.getAttribute("book");
	%>
	책정보전체: <%=book %><br>
	책제목: <%=book.getTitle() %><br>
	책저자: <%=author %><br>
	출판사: <%=publisher %><br>
	
	<%-- 책제목: ${book.title }<br> --%>
	<%-- 책저자: ${book.author }<br> --%>
	<%-- 출판사: ${book.publisher }<br> --%>
	${header }
</body>

</html>