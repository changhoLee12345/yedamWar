<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example17.jsp</title>
</head>
<body>
	<jsp:useBean id="bean" class="com.edu.beans.BookBean"></jsp:useBean>
	<c:if test="${empty param }">
		<jsp:setProperty property="author" value="Hong" name="bean" />
		<jsp:setProperty property="title" value="Hong fly~~" name="bean" />
		<jsp:setProperty property="publisher" value="h&pCompany" name="bean" />
	</c:if>
	<c:if test="${not empty param }">
		<jsp:setProperty property="author" name="bean" param="author" />
		<jsp:setProperty property="title" name="bean" param="title" />
		<jsp:setProperty property="publisher" name="bean" param="publisher" />
	</c:if>
	<%-- <jsp:setProperty property="*" name="bean" /> --%>

	<jsp:getProperty property="author" name="bean" /><br>
	<jsp:getProperty property="title" name="bean" /><br>
	<jsp:getProperty property="publisher" name="bean" /><br>

</body>
</html>