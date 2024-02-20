<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
  div.reply div {
    margin: auto;
  }

  div.reply span {
    display: inline-block;
  }

  div.reply ul {
    list-style-type: none;
    margin-top: 16px;
  }

  div.reply li {
    padding-top: 1px;
    padding-bottom: 1px;
  }
</style>

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

<div class="container reply" style="width: 80%">
  <div class="header">
    <input class="col-sm-8" type="text" name="reply" id="reply">
    <button class="col-sm-3" class="addReply">댓글등록</button>
  </div>
  <div class="content">
    <ul>
      <li><span class="col-sm-2">글번호</span><span class="col-sm-6">댓글내용</span><span class="col-sm-2">작성자</span><span class="col-sm-2">삭제</span></li>
      <li><hr></li>
      <li><span class="col-sm-2">12</span><span class="col-sm-6">댓글 1 </span><span class="col-sm-2">user01</span><button class="col-sm-2">삭제</button></li>
      <li><span class="col-sm-2">17</span><span class="col-sm-6">댓글 2 </span><span class="col-sm-2">user02</span><button class="col-sm-2">삭제</button></li>
      <li><span class="col-sm-2">25</span><span class="col-sm-6">댓글 3 </span><span class="col-sm-2">user03</span><button class="col-sm-2">삭제</button></li>
    </ul>
  </div>
</div>

<div style="text-align: center;"><a
    href="boardList.do?page=${search.page }&searchCondition=${search.type }&keyword=${search.keyword }">목록으로</a></div>

<jsp:include page="../includes/footer.jsp"></jsp:include>