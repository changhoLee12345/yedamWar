<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<a class="navbar-brand" href="main.do">Navbar</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="collapsibleNavbar">
		<ul class="navbar-nav">
			<c:if test="${not empty id }">
				<li class="nav-item"><a class="nav-link" href="memberLoginOut.do">로그아웃</a></li>
			</c:if>

			<c:if test="${empty id }">
				<li class="nav-item"><a class="nav-link" href="memberLoginForm.do">로그인</a></li>
				<li class="nav-item"><a class="nav-link" href="memberJoinForm.do">회원가입</a></li>
			</c:if>
			<!-- <li class="nav-item"><a class="nav-link" href="${pageContext.request.servletContext.contextPath }/replyList.do">댓글테스트</a></li>
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.servletContext.contextPath }/member/memberInsert.tiles">회원정보생성</a> </li>
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.servletContext.contextPath }/member/memberSearch.tiles">회원정보검색</a></li>
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.servletContext.contextPath }/member/memberUpdate.tiles">회원정보수정</a></li>
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.servletContext.contextPath }/member/memberDelete.tiles">회원정보삭제</a></li>
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.servletContext.contextPath }/memberList.do">모든회원정보</a></li> -->
			<c:choose>
				<c:when test="${empty id }">
					<li class="nav-item"><a class="nav-link" href="#" style="color: yellow;">(Guest)</a></li>
				</c:when>
				<c:otherwise>
					<li class="nav-item"><a class="nav-link" href="#" style="color: yellow;">(${id })</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</nav>