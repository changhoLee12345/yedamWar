<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="${pageContext.request.contextPath }/ckeditor/ckeditor.js"></script>
<script>
    document.addEventListener('DOMContentLoaded', function () {
        CKEDITOR.replace('desc', {
            filebrowserUploadUrl: '${pageContext.request.contextPath}/bookUpload.do'
        })
    })
</script>

<div class="container">
    <h3>상세화면(bookDetail.jsp)</h3>
    <form action="modifyBook.do" method="post">
        <table class="table">
            <tr>
                <th>도서코드</th>
                <td><input class="col-sm-6" type="text" name="code" value="${vo.bookCode }"></td>
            </tr>
            <tr>
                <th>제목</th>
                <td><input class="col-sm-6" type="text" name="title" value="${vo.bookTitle }"></td>
            </tr>
            <tr>
                <th>저자</th>
                <td><input class="col-sm-6" type="text" name="author" value="${vo.bookAuthor }"></td>
            </tr>
            <tr>
                <th>출판사</th>
                <td><input class="col-sm-6" type="text" name="press" value="${vo.bookPress }"></td>
            </tr>
            <tr>
                <th>가격</th>
                <td><input class="col-sm-6" type="text" name="price" value="${vo.bookPrice }"></td>
            </tr>
            <tr>
                <th>설명</th>
                <td><textarea class="col-sm-6" name="desc" rows="30">${vo.bookDesc }</textarea></td>
            </tr>
            <tr>
                <td align="center" colspan=2>
                    <input class="btn btn-primary" type="submit" value="수정">
                    <input class="btn btn-danger" type="reset" value="삭제"></td>
            </tr>
        </table>
    </form>
</div>