<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../includes/header.jsp" />
<table class="table">
	<tr>
		<th>아이디</th>
		<td>${member.id }</td>
	</tr>
	<tr>
		<th>이름</th>
		<td>${member.name }</td>
	</tr>
	<tr>
		<th>이메일</th>
		<td>${member.email }</td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td>${member.passwd }</td>
	</tr>
</table>

<jsp:include page="../includes/footer.jsp" />