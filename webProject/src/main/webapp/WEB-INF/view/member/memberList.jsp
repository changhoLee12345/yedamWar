<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3>회원목록.</h3>

<table class="table">
    <thead>
        <tr>
            <th>아이디</th>
            <th>이름</th>
            <th>연락처</th>
            <th>비밀번호</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="vo" items="${mlist }">
            <tr>
                <td><c:out value="${vo.memberId }" /></td>
                <td><c:out value="${vo.memberNm }" /></td>
                <td><c:out value="${vo.phone }" /></td>
                <td><c:out value="${vo.memberPw }" /></td>
            </tr>
        </c:forEach>
    </tbody>
</table>