<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>회원로그인화면</h3>
<hr>
<form action="memberLogin.do" method="post">
	<table border='1'>
		<caption>회원로그인</caption>
		<tr>
			<th>아이디</th>
			<td><input name='mid' type='text'></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input name='passwd' type='password'></td>
		</tr>
		<tr>
			<td colspan='2' align='center'>
				<input type='submit' value='로그인'>
				<input type='reset' value='취소'>
			</td>
		</tr>
	</table>
</form>