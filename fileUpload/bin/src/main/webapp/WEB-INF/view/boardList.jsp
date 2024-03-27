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
          <option value="">선택하세요.</option>
          <option value="T" ${type == 'T' ? 'selected' : '' }>제목</option>
          <option value="W" ${type == 'W' ? 'selected' : '' }>작성자</option>
          <option value="TW" ${type == 'TW' ? 'selected' : '' }>제목 작성자</option>
        </select>
      </div>
      <div class="col-sm-6">
        <input type="text" name="keyword" class="form-control" value="${keyword }">
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
        <td><a href="board.do?bno=${board.boardNo }&page=${paging.page }&searchCondition=${type }&keyword=${keyword }">${board.title }</a></td>
        <td>${board.writer }</td>
        <td align="center">${board.viewCnt }</td>
        <td>${board.createDate }</td>
      </tr>
    </c:forEach>
  </tbody>
</table>

<p>${paging }</p>

<div class="center">
  <div class="pagination">
  <c:if test="${paging.prev }">
    <a href="boardList.do?page=${paging.startPage - 1 }&searchCondition=${type}&keyword=${keyword}">&laquo;</a>
  </c:if>
  <c:forEach var="page" begin="${paging.startPage }" end="${paging.endPage }">
    <a href="boardList.do?page=${page }&searchCondition=${type}&keyword=${keyword}" class="${page == paging.page ? 'active' : '' }">${page }</a>
  </c:forEach>
  <c:if test="${paging.next }">
    <a href="boardList.do?page=${paging.endPage + 1 }&searchCondition=${type}&keyword=${keyword}">&raquo;</a>
  </c:if>
  </div>
</div>
<hr>
<jsp:include page="../includes/footer.jsp"></jsp:include>
<script>
  //var type = '${type}';
  //document.querySelector('select[name="searchCondition"]').value = type; 
</script>
