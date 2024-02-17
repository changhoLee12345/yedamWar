<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../includes/header.jsp"></jsp:include>
<jsp:include page="../includes/menu.jsp"></jsp:include>
<h3>Board List</h3>
<table class='table'>
  <thead>
    <tr>
      <th>글번호</th>
      <th>제목</th>
      <th>작성자</th>
      <th>조회수</th>
      <th>작성일시</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="board" items="${boardList }">
      <tr>
        <td>${board.boardNo }</td>
        <td>${board.title }</td>
        <td>${board.writer }</td>
        <td>${board.viewCnt }</td>
        <td>${board.createDate }</td>
      </tr>
    </c:forEach>
  </tbody>
</table>
<jsp:include page="../includes/footer.jsp"></jsp:include>