<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container">
    <h3>상세화면(searchBook.jsp)</h3>
    <form action="searchBook.do" method="post">
        <input type="hidden" name="from" value="search">
        <table class="table">
            <tr>
                <th>도서코드</th>
                <td><input class="col-sm-6" type="text" name="code" value="${vo.bookCode }" readonly></td>
            </tr>
            <tr>
                <th>제목</th>
                <td><input class="col-sm-6" type="text" value="${vo.bookTitle }" readonly></td>
            </tr>
            <tr>
                <th>저자</th>
                <td><input class="col-sm-6" type="text" value="${vo.bookAuthor }" readonly></td>
            </tr>
            <tr>
                <th>출판사</th>
                <td><input class="col-sm-6" type="text" value="${vo.bookPress }" readonly></td>
            </tr>
            <tr>
                <th>가격</th>
                <td><input class="col-sm-6" type="text" value="${vo.bookPrice }" readonly></td>
            </tr>
            <tr>
                <th>설명</th>
                <td>${vo.bookDesc }</td>
            </tr>
            <tr>
                <td align="center" colspan=2>
                    <input class="btn btn-primary" type="submit" value="수정">
            </tr>
        </table>
    </form>
</div>