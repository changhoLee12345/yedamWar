<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h3>회원리스트</h3>

<table class="table">
    <thead>
        <tr>
            <th>아이디</th>
            <th>이름</th>
            <th>이메일</th>
            <th>권한</th>
            <th>등록일</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="member" items="${members }">
            <tr>
                <td><a href="memberForm.do?id=${member.id }">${member.id }</a></td>
                <td>${member.name }</td>
                <td>${member.email }</td>
                <td>${member.responsibility }</td>
                <td>${member.cdate }</td>
            </tr>
        </c:forEach>
    </tbody>
</table>