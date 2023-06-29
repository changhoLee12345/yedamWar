<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<style>
    .border {
        border-radius: 5px;;
    }
</style>
<form name="myFrm" action="updateNotice.do" method="get">
    <input type="hidden" name="pageNum" value="${criInfo.pageNum }">
    <input type="hidden" name="amount" value="${criInfo.amount }">
    <input type="hidden" name="searchCondition" value="${criInfo.searchCondition }">
    <input type="hidden" name="keyword" value="${criInfo.keyWord }">
    <input type="hidden" name="num" value="${vo.noticeId }">
    <table class="table">
        <tr>
            <th>게시글번호</th>
            <td><input class="col-sm-5" type="text" disabled value="${vo.noticeId }"></td>
        </tr>
        <tr>
            <th>작성자</th>
            <td><input class="col-sm-5" type="text" name="writer" value="${vo.noticeWriter }"></td>
        </tr>
        <tr>
            <th>제목</th>
            <td><input class="col-sm-5" type="text" name="title" value="${vo.noticeTitle }"></td>
        </tr>
        <tr>
            <th>시간</th>
            <td>
                <input class="col-sm-5" type="text" name="ndate" value="<fmt:formatDate value="${vo.noticeDate }" pattern="yyyy-MM-dd hh:mm:ss" />">
            </td>
        </tr>
        <tr>
            <th>글내용</th>
            <td><textarea class="col-sm-5" rows="5" name="subject">${vo.noticeSubject }</textarea></td>
        </tr>
        <tr>
            <td align="center"><input class="btn btn-primary" type="submit" value="수정"></td>
            <td align="center"><input class="btn btn-danger" type="button" value="삭제" onclick="delFunc()"></td>
        </tr>
    </table>
</form>
<!-- 댓글부분. -->
<div class="row" style="width: 80%; margin: 5px auto 5px; border: 1px solid gray; border-radius: 5px;">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading" style="padding-bottom: 20px; height: 30px;">
				<i class="fa fa-comments fa-fw"></i>Reply
				<button id='addReplyBtn' class='btn btn-primary btn-xs pull-right'>New Reply</button>
			</div>
			<div class="panel-body">
				<ul class="chat">
					<li class="left clearfix" data-rno="12">
						<div>
							<div class="header">
								<strong class="primary-font">user00</strong>
								<small class="pull-right text-muted">2023-03-05 13:13</small>
							</div>
							<p>Good job!</p>
						</div>
					</li>
				</ul>
			</div>
			<div class="panel-footer">

			</div>
		</div>
	</div>
</div>

<script>
    function delFunc() {
        myFrm.action = "deleteNotice.do";
        myFrm.submit();
    }
</script>