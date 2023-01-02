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
<p>${criInfo }</p>
<form action="noticeList.do">
	<select name="searchCondition">
		<option value="">::select::</option>
		<option value="writer" ${criInfo.searchCondition=='writer'?'selected':'' }>작성자</option>
		<option value="title" ${criInfo.searchCondition=='title'?'selected':'' }>제목</option>
		<option value="subject" ${criInfo.searchCondition=='subject'?'selected':'' }>내용</option>
	</select>
	<input type="text" name="keyword" value="${criInfo.keyWord }">
	<input type="submit" value="조회">
</form>
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
				<td><a href="getNotice.do?num=${notice.noticeId }&searchCondition=${criInfo.searchCondition }&keyword=${criInfo.keyWord }&pageNum=${criInfo.pageNum }&amount=${criInfo.amount }">
						${notice.noticeId}
					</a>
				</td>
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
			<a href="noticeList.do?pageNum=${pageInfo.startPage-1 }&searchCondition=${criInfo.searchCondition }&keyword=${criInfo.keyWord }&amount=${criInfo.amount }">&laquo;</a>
		</c:if>
		<c:forEach var="item" begin="${pageInfo.startPage }" end="${pageInfo.endPage }">
			<c:choose>
				<c:when test="${pageInfo.cri.pageNum == item }">
					<a class="active" href="noticeList.do?pageNum=${item }&searchCondition=${criInfo.searchCondition }&keyword=${criInfo.keyWord }&amount=${criInfo.amount }">${item }</a> </c:when>
				<c:otherwise>
					<a href="noticeList.do?pageNum=${item }&searchCondition=${criInfo.searchCondition }&keyword=${criInfo.keyWord }&amount=${criInfo.amount }">${item }</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${pageInfo.next }">
			<a href="noticeList.do?pageNum=${pageInfo.endPage+1 }&searchCondition=${criInfo.searchCondition }&keyword=${criInfo.keyWord }&amount=${criInfo.amount }">&raquo;</a>
		</c:if>
	</div>
</div>

<script>
	console.log(decodeURI('https://archive.org/download/2020_20210726/%ED%95%9C%EC%BB%B4%EC%98%A4%ED%94%BC%EC%8A%A4%EA%B5%90%EC%9C%A1%EA%B8%B0%EA%B4%80%EC%9A%A9%202020.zip'))
</script>