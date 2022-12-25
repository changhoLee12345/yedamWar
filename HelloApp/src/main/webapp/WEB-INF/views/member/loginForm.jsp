<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>로그인 화면</h3>
<c:if test="${!empty message }">
	<p class="center">${message }</p>
</c:if>
<form action="memberLogin.do" method="post">
	<table class="table">
		<tr>
			<th>아이디</th>
			<td><input type="text" name="userId"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="userPw"></td>
		</tr>
		<tr>
			<td align="center"><input class="btn btn-primary" type="submit" value="로그인"></td>
			<td align="center"><input class="btn btn-danger" type="reset" value="취소"></td>
		</tr>
	</table>
</form>