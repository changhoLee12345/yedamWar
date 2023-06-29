<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
                <input class="col-sm-5" type="text" name="ndate" pattern="yyyy-MM-dd hh:mm:ss"
                    value='<fmt:formatDate value="${vo.noticeDate }"/>'>
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
            <div class="panel-heading" style="height: 40px; background-color: rgb(230, 230, 231);">
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
                    <li class="left clearfix" data-rno="12">
                        <div>
                            <div class="header">
                                <strong class="primary-font">user01</strong>
                                <small class="pull-right text-muted">2023-03-05 13:13</small>
                            </div>
                            <p>Hello, World!</p>
                        </div>
                    </li>
                </ul>
            </div>
            <div class="panel-footer">
            </div>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"
    style="top: 20px;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">Reply Modal</h4>
            </div>
            <div class="modal-body">
                <div class='form-group'>
                    <label>Reply</label>
                    <input class='form-control' name='reply' value='New Reply!!!!'>
                </div>
                <div class='form-group'>
                    <label>Replyer</label>
                    <input class='form-control' name='replyer' value='replyer'>
                </div>
                <div class='form-group'>
                    <label>Reply Date</label>
                    <input class='form-control' name='replyDate' value='replyDate'>
                </div>
            </div>
            <div class="modal-footer">
                <button id='modalModBtn' type="button" class="btn btn-warning" data-dismiss="modal">Modify</button>
                <button id='modalRemoveBtn' type="button" class="btn btn-danger">Remove</button>
                <button id='modalRegisterBtn' type="button" class="btn btn-primary">Register</button>
                <button id='modalCloseBtn' type="button" class="btn btn-secondary">Close</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<script>
    Date.prototype.timeFormat = function () {
        console.log(this);
        let today = new Date();

        let yyyy = today.getFullYear(),
            mm = today.getMonth(),
            dd = today.getDate();

        let hh = today.getHours(),
            min = today.getMinutes(),
            ss = today.getSeconds();

        return yyyy + '-' + ('0' + mm).slice(-2) + '-' + ('0' + dd).slice(-2) + ' ' +
            ('0' + hh).slice(-2) + ':' + ('0' + mm).slice(-2) + ':' + ('0' + ss).slice(-2);
    }

    document.querySelector('button.close').addEventListener('click', function () {
        document.querySelector('#myModal').style.display = 'none';
        document.querySelector('#myModal').style.opacity = 0;

    })
    document.querySelector('#modalCloseBtn').addEventListener('click', function () {
        document.querySelector('#myModal').style.display = 'none';
        document.querySelector('#myModal').style.opacity = 0;

    })

    // 댓글등록.
    document.querySelector('#addReplyBtn').addEventListener('click', function (e) {
        document.querySelector('#myModal').style.display = 'block';
        document.querySelector('#myModal').style.opacity = 1;

        // 수정버튼, 삭제버튼 숨김.
        document.querySelector('#modalModBtn').style.display = 'none';
        document.querySelector('#modalRemoveBtn').style.display = 'none';
        document.querySelector('#modalRegisterBtn').style.display = 'block';

    })

    document.querySelectorAll('.chat li').forEach(function (item) {
        item.addEventListener('click', function () {
            document.querySelector('#myModal').style.display = 'block';
            document.querySelector('#myModal').style.opacity = 1;

            document.querySelector('#modalModBtn').style.display = 'block';
            document.querySelector('#modalRemoveBtn').style.display = 'block';
            document.querySelector('#modalRegisterBtn').style.display = 'none';

            let reply = 'Good job!';
            let replyer = 'user00';
            let replyDate = new Date();
            replyDate.timeFormat();

            document.querySelector('#myModal input[name="reply"]').value = reply;
            document.querySelector('#myModal input[name="replyer"]').value = replyer;
            document.querySelector('#myModal input[name="replyDate"]').value = replyDate.timeFormat();

        })
    })

    function delFunc() {
        myFrm.action = "deleteNotice.do";
        myFrm.submit();
    }
</script>