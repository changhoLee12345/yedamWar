<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table border='1'>
	<thead>
		<tr><th>원본글</th><th>글제목</th><th>작성자</th><th>댓글번호</th><th>댓글내용</th><th>답글자</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="item" items="${boardReplyList }">
			<tr><td>${item.bno }</td><td>${item.title }</td><td>${item.writer }</td>
			<c:choose>
				<c:when test="${item.replyList.size() gt 0 }">
					<td colspan="3">댓글목록</td>
					<c:forEach var="reply" items="${item.replyList }">
						<tr><td colspan="3"></td><td>${reply.rno }</td><td>${reply.content }</td><td>${reply.writer }</td></tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
						<td></td><td></td><td></td>
				</c:otherwise>
			</c:choose>
			</tr>
		</c:forEach>
	</tbody>
</table>
