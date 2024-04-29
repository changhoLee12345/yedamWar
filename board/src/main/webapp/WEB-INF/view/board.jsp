<%@page import="co.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="//cdn.datatables.net/2.0.3/css/dataTables.dataTables.min.css" rel="stylesheet">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.2/moment.min.js"></script>
<script src="//cdn.datatables.net/2.0.3/js/dataTables.min.js"></script>

<style>
  div.reply div {
    margin: auto;
  }

  div.reply ul {
    list-style-type: none;
    margin-top: 10px;
  }

  div.reply li {
    padding-top: 1px;
    padding-bottom: 1px;
  }

  div.reply span {
    display: inline-block;
  }
</style>

<style>
  .center {
    text-align: center;
  }

  .pagination {
    display: inline-block;
  }

  .pagination a {
    color: black;
    float: left;
    padding: 8px 16px;
    text-decoration: none;
    transition: background-color .3s;
    border: 1px solid #ddd;
    margin: 0 4px;
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

<h3>상세페이지</h3>
<form name="notUse"></form>
<form name="submitForm" action="modifyForm.do">
  <input type="hidden" name="bno" value="${bvo.boardNo }">
  <input type="hidden" name="page" value="${page }">
  <input type="hidden" name="searchCondition" value="${searchCondition }">
  <input type="hidden" name="keyword" value="${keyword }">
  <table class="table">
    <tr>
      <th>글번호</th>
      <td>
        <c:out value="${bvo.boardNo }" />
      </td>
      <th>조회수</th>
      <td>
        <c:out value="${bvo.viewCnt }" />
      </td>
    </tr>
    <tr>
      <th>글내용</th>
      <td colspan="3">
        <c:out value="${bvo.content }" />
      </td>
    </tr>
    <tr>
      <th>작성자</th>
      <td>
        <c:out value="${bvo.writer }" />
      </td>
      <th>작성일시</th>
      <td>
        <c:out value="${bvo.createDate }" />
      </td>
    </tr>
    <tr>
      <td colspan="4">
        <c:if test="${not empty bvo.img }"><img src="upload/${bvo.img }" width="200px"></c:if>
      </td>
    </tr>
    <tr>
      <td colspan="4" align="center">
        <button type="submit" class="btn btn-primary">수정</button>
        <button type="button" ${logId !=bvo.writer ? 'disabled' : '' } class="btn btn-warning"
          onclick="deleteFormFunc()">삭제</button>
      </td>
    </tr>
  </table>
</form>
<div class="container reply">
  <!-- 등록. -->
  <div class="header">
    <input class="col-sm-8" id="reply">
    <button class="col-sm-3" id="addReply">댓글등록</button>
  </div>
</div>
<table id="example" class="display" style="width: 100%">
  <thead>
    <tr>
      <th>댓글번호</th>
      <th>내용</th>
      <th>작성자</th>
      <th>작성일시</th>
      <th>삭제</th>
    </tr>
  </thead>
  <tfoot>
    <tr>
      <th>댓글번호</th>
      <th>내용</th>
      <th>작성자</th>
      <th>작성일시</th>
      <th>삭제</th>
    </tr>
  </tfoot>
</table>
<p><button id="button">Delete selected row</button></p>

<!-- <script src="js/boardService.js"></script> -->
<script>
  const logId = "${logId}";
  const writer = "${bvo.writer}";
  const bno = "${bvo.boardNo }";

  const table = new DataTable('#example', {
    ajax: 'datatable.do?bno=' + bno,
    columns: [{ data: 'replyNo' },
      { data: 'reply' },
      { data: 'replyer' },
      { data: 'replyDate' }
    ],
    lengthMenu: [
      [5, 10, 25, -1],
      [5, 10, 25, 'All']
    ],
    order: [
      [0, 'desc']
    ],
    columnDefs: [{
        render: (data, type, row) => "<button onclick=''>Delete</button>",
        targets: 4
      },
      //{ visible: false, targets: [3] }
    ]
  });
  let selectedNo = -1; // 선택한 tr의 댓글번호를 담아놓기 위한 변수.
  table.on('click', 'tbody tr', (e) => {

    if (selectedNo == -1) {
      selectedNo = e.currentTarget.children[0].innerText;
    } else {
      selectedNo = -1;
    }

    let classList = e.currentTarget.classList;

    if (classList.contains('selected')) {
      classList.remove('selected');
    } else {
      table.rows('.selected').nodes().each((row) => row.classList.remove('selected'));
      classList.add('selected');
    }

    if (e.target.nodeName == 'BUTTON') {
      deleteRow(e);
    }
  });

  function addNewRow(reply = {}) {
    table.row
      .add({
        replyNo: reply.replyNo,
        reply: reply.reply,
        replyer: reply.replyer,
        replyDate: reply.replyDate
      })
      .draw(false);

  } // end of addNewRow().

  // addReply 를 클릭하면...ajax호출...성공: 화면에 row추가.
  document.querySelector('#addReply').addEventListener('click', function (e) {
    let reply = document.querySelector('#reply').value;
    if (!logId) {
      alert("로그인하세요...");
      return;
    }
    if (!reply) {
      alert("댓글입력하세요...");
      return;
    }
    // ajax호출.
    fetch('addReply.do', {
        method: 'post',
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: 'bno=' + bno + '&reply=' + reply + '&replyer=' + logId
      })
      .then(result => result.json())
      .then(result => {
        console.log(result);
        if (result.retCode == 'Success') {
          alert('등록성공!!!');
          addNewRow(result.retVal);
        }
        document.querySelector('#reply').value = '';
      })
      .catch(err => console.error(err));
  }); // 등록버튼 이벤트.

  document.querySelector('#button').addEventListener('click', deleteRow); // 삭제이벤트.

  function deleteRow(e) {
    e.stopPropagation();
    fetch('removeReply.do?rno=' + selectedNo)
      .then(result => result.json())
      .then(result => {
        if (result.retCode == 'Success') {
          alert('삭제성공!!');
          table.row('.selected').remove().draw(false);
          selectedNo = -1;
        } else {
          alert('삭제할 댓글을 선택하세요.')
        }
      })
      .catch(err => console.error(err))
  }
</script>