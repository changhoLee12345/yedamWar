<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form action="updateNotice.do" method="post">
    <table class="table">
        <tr>
            <th>게시글번호</th>
            <td><input class="col-sm-5" type="text" disabled name="num" value="${vo.noticeId }"></td>
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
            <th>글내용</th>
            <td><textarea class="col-sm-5" rows="5" name="subject">${vo.noticeSubject }</textarea></td>
        </tr>
        <tr>
            <td align="center"><input class="btn btn-primary" type="submit" value="수정"></td>
            <td align="center"><input class="btn btn-danger" type="button" value="삭제"></td>
        </tr>
    </table>
</form>
