<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../includes/header.jsp"></jsp:include>
<jsp:include page="../includes/menu.jsp"></jsp:include>

<h3>글 등록</h3>
<c:if test="${logid == null }">
    <c:redirect url="main.do"></c:redirect>
</c:if>
<p></p>
<form action="addBoard.do">
    <table class="table">
        <tr>
            <th>제목</th>
            <td><input type="text" name="title"></td>
        </tr>
        <tr>
            <th>내용</th>
            <td><textarea name="content" cols="30" rows="5"></textarea></td>
        </tr>
        <tr>
            <th>작성자</th><td><input type="text" name="writer" readonly="readonly" value="${logid }"></td>
        </tr>
        <tr align="center">
            <td colspan="2"><input type="submit" value="등록"></td>
        </tr>
    </table>
</form>

<jsp:include page="../includes/footer.jsp"></jsp:include>

<script>
    console.log('addBoard.jsp');
</script>