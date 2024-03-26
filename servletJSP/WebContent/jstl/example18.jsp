<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
  String[] strs = {"hello","nice","good"};
  request.setAttribute("str", strs);
%>
	Listerals : ${"Literals" }
	<br> Operators : ${5>3 }
	<br> Implicit Objects : ${header }
	<br> Context : ${pageContext.servletContext.contextPath }
	<br> IfCondit : ${5>3?"true":"false" }
	<br>
	
	<c:set var="myname">Lch</c:set>
	<c:out value="${myname }"></c:out>
	
    <c:forEach items="${str }" var="name">
      <p>${name }</p>
    </c:forEach>
</body>
</html>