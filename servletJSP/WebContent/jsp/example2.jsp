<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h3>JSP 프로그래밍</h3>
<%
	Date d = new Date();
%>
<%=d.toString()%>