<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="../includes/header.jsp" />

<h3>회원가입</h3>
<form action="<%=request.getContextPath() %>/memberInsert.do">
    <table class="table">
        <tr>
            <td>아이디</td>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <td>비밀번호</td>
            <td><input type="password" name="passwd"></td>
        </tr>
        <tr>
            <td>이름</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>이메일</td>
            <td><input type="email" name="mail"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" class="btn btn-primary"> <input type="reset" class="btn btn-warning"></td>
        </tr>
    </table>
</form>

<jsp:include page="../includes/footer.jsp" />