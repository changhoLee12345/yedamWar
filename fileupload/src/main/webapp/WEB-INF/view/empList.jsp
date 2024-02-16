<%@page import="co.yedam.vo.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../includes/header.jsp"></jsp:include>
<jsp:include page="../includes/menu.jsp"></jsp:include>
<h3>사원목록</h3>
<ul>
	<c:forEach var="emp" items="${list }">
		<li>사번: ${emp.empNo } 이름: ${emp.empName }</li>
	</c:forEach>
</ul>
<jsp:include page="../includes/footer.jsp"></jsp:include>