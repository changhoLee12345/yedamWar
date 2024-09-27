<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../includes/header.jsp" />

<h3>회원정보</h3>
${list }
<c:choose>
	<c:when test="${not empty list }">
		<table border="1" class="table">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Mail</th>
				<th>Passwd</th>
			</tr>
			<c:forEach items="${list }" var="item">
				<tr>
					<td>${item.id }</td>
					<td><a href="${pageContext.request.contextPath}/member/memberControl.jsp?job=search&id=${item.id }">${item.name }</a></td>
					<td>${item.email }</td>
					<td>${item.passwd }</td>
				</tr>
			</c:forEach>
		</table>
		<h3></h3>
	</c:when>
	<c:otherwise>
		<h3>정보가 없습니다.</h3>
	</c:otherwise>
</c:choose>
<jsp:include page="home.jsp" />

<jsp:include page="../includes/footer.jsp" />
