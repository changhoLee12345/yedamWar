<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
	<h3>bookList</h3>
	<table class="table">
		<thead>
			<tr>
				<th>도서코드</th>
				<th>저자</th>
				<th>제목</th>
				<th>출판사</th>
				<th>가격</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="book" items="${bookList }">
				<tr>
					<td><a href="searchBook.do?code=${book.bookCode }">${book.bookCode }</a></td>
					<td>${book.bookAuthor }</td>
					<td>${book.bookTitle }</td>
					<td>${book.bookPress }</td>
					<td>${book.bookPrice }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="center" style="text-align: center">
		<button class="btn btn-primary">등록화면</button>
		<button class="btn btn-danger">조회화면</button>
	</div>
</div>