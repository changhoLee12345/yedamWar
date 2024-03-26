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
	<jsp:useBean id="book" class="com.edu.beans.BookBean" />
	<jsp:setProperty property="author" name="book" param="author"/>
	<jsp:setProperty property="title" name="book" param="title"/>
	<jsp:setProperty property="publisher" name="book" param="publisher"/>
	<%-- <jsp:setProperty property="*" name="book" /> --%>

	<%
		//BookBean book = new BookBean();
		//book.setAuthor(request.getParameter("author"));
		//book.setTitle(request.getParameter("title"));
		//book.setPublisher(request.getParameter("publisher"));

		request.setAttribute("book", book);
	%>
	<jsp:forward page="bookOutput.jsp" />
</body>

</html>