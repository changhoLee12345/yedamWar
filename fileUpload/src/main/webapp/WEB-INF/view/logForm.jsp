<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../includes/header.jsp"></jsp:include>
<jsp:include page="../includes/menu.jsp"></jsp:include>

<c:if test="${not empty message }">
<p>${message }</p>
</c:if>

<form action="login.do" method="post">
    <table class="table">
        <tr>
            <th>아이디</th>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <th>비밀번호</th>
            <td><input type="password" name="pw"></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="로그인">
                <input type="reset" value="취소">
            </td>
        </tr>
    </table>
</form>

<jsp:include page="../includes/footer.jsp"></jsp:include>