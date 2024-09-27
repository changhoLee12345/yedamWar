<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h3>Main Page</h3>
<h2>첫 페이지</h2>
<a href="member/memberView/memberInsert.jsp">회원정보생성</a><br>
<a href="member/memberView/memberSearch.jsp">회원정보검색</a><br>
<a href="<%=request.getContextPath()%>/member/memberControl.jsp">모든회원정보보기</a><br>
<a href="<%=request.getContextPath()%>/main.do">main page</a>
