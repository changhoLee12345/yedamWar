<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../includes/header.jsp"></jsp:include>
<jsp:include page="../includes/menu.jsp"></jsp:include>

<h3>상세조회("${board.boardNo }")</h3>
<table class="table">
  <tr>
    <th>글번호</th>
    <td>${board.boardNo }</td>
    <th>조회수</th>
    <td>${board.viewCnt }</td>
  </tr>
  <tr>
    <th colspan="2">제목</th>
    <td colspan="2">${board.title }</td>
  </tr>
  <tr>
    <td colspan="4">${board.content }</td>
  </tr>
  <tr>
    <th>작성자</th>
    <td>${board.writer }</td>
    <th>작성일시</th>
    <td>${board.createDate }</td>
  </tr>
  <tr>
    <td colspan="4" align="center">
      <input type="submit" value="수정">
      <input type="button" value="삭제">
    </td>
  </tr>
</table>

<a href="boardList.do?page=${search.page }&searchCondition=${search.type }&keyword=${search.keyword }">목록으로</a>

<jsp:include page="../includes/footer.jsp"></jsp:include>