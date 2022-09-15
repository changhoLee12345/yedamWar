<%@page import="com.dev.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h3>회원정보 수정</h3>
	${error }

	<form action="<%=request.getContextPath() %>/memberSearch.do" method="post">
		ID: <input type="text" name="id" />
		 <input type="hidden" name="job" value="update" /> 
		 <input type="submit" value="Search" />
	</form>

	<c:if test="${!empty member }" >
		<h3>회원정보수정</h3>
		<form action="<%=request.getContextPath() %>/memberUpdate.do" method="post">
			ID: <input type="text" name="id" readonly value="${member.id }"><br>
			PW: <input type="password" name="passwd" value="${member.passwd }"><br>
			Name: <input type="text" name="name" value="${member.name }"><br>
			Mail: <input type="email" name="mail" value="${member.mail }"><br>
			<input type="submit" value="Modify">
		</form>
	</c:if>

	<c:if test="${empty member }">
		<p>${result }</p>
	</c:if>

	<script>
		let varia = "${member.id}";
		console.log(varia)
	</script>
</body>
</html>