<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
	.center {
		text-align: center;
	}

	.pagination {
		display: inline-block;
	}

	.pagination a {
		color: black;
		float: left;
		padding: 8px 16px;
		text-decoration: none;
		transition: background-color .3s;
		border: 1px solid #ddd;
		margin: 0 4px;
	}

	.pagination a.active {
		background-color: #4CAF50;
		color: white;
		border: 1px solid #4CAF50;
	}

	.pagination a:hover:not(.active) {
		background-color: #ddd;
	}
</style>
<h3>Notice List</h3>
<table class="table">
	<thead>
		<tr>
			<th>글번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>글내용</th>
			<th>글작성일시</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="notice" items="${list }">
			<tr>
				<td><a href="getNotice.do?num=${notice.noticeId }">${notice.noticeId }</a></td>
				<td>${notice.noticeWriter }</td>
				<td>${notice.noticeTitle }</td>
				<td>${notice.noticeSubject }</td>
				<td>${notice.noticeDate }</td>
				<td>${notice.hitCount }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<div class="center">
	<div class="pagination">

		<c:if test="${pageInfo.prev }">
			<a href="noticeList.do?page=${pageInfo.startPage-1 }">&laquo;</a>
		</c:if>
		<c:forEach var="item" begin="${pageInfo.startPage }" end="${pageInfo.endPage }">
			<c:choose>
				<c:when test="${pageInfo.cri.pageNum == item }">
					<a class="active" href="noticeList.do?page=${item }">${item }</a> </c:when>
				<c:otherwise>
					<a href="noticeList.do?page=${item }">${item }</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${pageInfo.next }">
			<a href="noticeList.do?page=${pageInfo.endPage+1 }">&raquo;</a>
		</c:if>
	</div>
</div>