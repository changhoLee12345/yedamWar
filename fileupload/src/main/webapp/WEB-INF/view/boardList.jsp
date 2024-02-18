<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
  .center {
    text-align: center;
    margin: auto;
    width: 55%;
  }

  .pagination {
    display: inline-block;
  }

  .pagination a {
    color: black;
    float: left;
    padding: 8px 16px;
    text-decoration: none;
    /* transition: background-color .3s; */
    /* border: 1px solid #ddd; */
    /* margin: 0 4px; */
  }

  .pagination a.active {
    background-color: #4CAF50;
    color: white;
    border: 1px solid #4CAF50;
  }

  .pagination a:hover:not(.active) {
    background-color: #ddd;
  }
</style>

<jsp:include page="../includes/header.jsp"></jsp:include>
<jsp:include page="../includes/menu.jsp"></jsp:include>
<h3>Board List</h3>

<div class="center">
  <form action="boardList.do" method="get">
    <div class="row">
      <div class="col-sm-4">
        <select name="searchCondition" class="form-control">
          <option value="T">제목</option>
          <option value="C">내용</option>
          <option value="TC">제목 & 내용</option>
        </select>
      </div>
      <div class="col-sm-6">
        <input type="text" name="keyword" class="form-control">
      </div>
      <div class="col-sm-2">
        <input type="submit" value="조회" class="btn btn-primary">
      </div>
    </div>
  </form>
</div>

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

<div class="center">
  <div class="pagination">
    <a href="#">&laquo;</a>
    <a href="#">1</a>
    <a href="#" class="active">2</a>
    <a href="#">3</a>
    <a href="#">4</a>
    <a href="#">5</a>
    <a href="#">6</a>
    <a href="#">&raquo;</a>
  </div>
</div>
<hr>
<jsp:include page="../includes/footer.jsp"></jsp:include>