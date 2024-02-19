<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../includes/header.jsp"></jsp:include>
<jsp:include page="../includes/menu.jsp"></jsp:include>

<h3>상세조회("${board.boardNo }")</h3>


<a href="boardList.do?page=${search.page }&searchCondition=${search.type }&keyword=${search.keyword }">목록으로</a>

<jsp:include page="../includes/footer.jsp"></jsp:include>
