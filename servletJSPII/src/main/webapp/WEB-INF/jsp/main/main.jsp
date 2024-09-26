<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h3>Main Page</h3>
<h2>첫 페이지</h2>
<a href="memberView/memberInsert.jsp">회원정보생성</a><br>
<a href="memberView/memberSearch.jsp">회원정보검색</a><br>
<a href="memberView/memberUpdate.jsp">회원정보수정</a><br>
<a href="memberView/memberDelete.jsp">회원정보삭제</a><br>
<a href="<%=request.getContextPath()%>/memberList.do">모든회원정보보기</a><br>
<a href="<%=request.getContextPath()%>/main.do">main page</a>
