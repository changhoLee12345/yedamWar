<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="border-end bg-white" id="sidebar-wrapper">
	<c:choose>
		<c:when test="${not empty id }">
			<div class="sidebar-heading border-bottom bg-light">${name }${message }</div>
		</c:when>
		<c:otherwise>
			<div class="sidebar-heading border-bottom bg-light">손님입니다.</div>
		</c:otherwise>
	</c:choose>

	<div class="list-group list-group-flush">
		<c:choose>
			<c:when test="${not empty id }">
				<a class="list-group-item list-group-item-action list-group-item-light p-3"
					href="memberLogout.do">로그아웃</a>
			</c:when>
			<c:otherwise>
				<a class="list-group-item list-group-item-action list-group-item-light p-3"
					href="memberLoginForm.do">로그인</a>
			</c:otherwise>
		</c:choose>
		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="searchBookForm.do">도서검색</a>
		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="addBookForm.do">도서등록</a>
		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="bookList.do">도서목록</a>
		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="bookListVueForm.do">도서(Vue)</a>
		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="noticeList.do">공지사항</a>
		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Events</a>
		<c:if test="${responsbility == 'Admin' }">
			<a class="list-group-item list-group-item-action list-group-item-light p-3" href="memberJoinForm.do">회원등록</a>
			<a class="list-group-item list-group-item-action list-group-item-light p-3" href="memberList.do">회원목록</a>
		</c:if>
	</div>
</div>