<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>	
<h3>예외 상황 처리(example3.jsp)</h3>
<h4>에러가 발생했습니다.</h4>
<p>exception: <%=exception %></p>
<p>에러타입: <%=exception.getClass().getName() %></p>
<p>에러메세지: <%=exception.getMessage()%>
