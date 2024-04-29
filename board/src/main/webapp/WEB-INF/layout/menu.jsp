<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="border-end bg-white" id="sidebar-wrapper">
    <div class="sidebar-heading border-bottom bg-light">Start Bootstrap(${logId == null ? 'Guest' : logId })</div>
    <div class="list-group list-group-flush">
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="boardList.do">글목록</a>
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="addForm.do">글등록</a>
        <c:choose>
            <c:when test="${empty logId}">
                <a class="list-group-item list-group-item-action list-group-item-light p-3" href="loginForm.do">로그인</a>
            </c:when>
            <c:otherwise>
                <a class="list-group-item list-group-item-action list-group-item-light p-3" href="logout.do">로그아웃</a>
            </c:otherwise>
        </c:choose>
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="addMemberForm.do">회원가입</a>
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="domForm.do">DOM연습</a>
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="memberForm.do">Member(Ajax)</a>
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="memberForm.do">게시글(Ajax)</a>
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="chartForm.do">사용자별건수(차트)</a>
    </div>
</div>