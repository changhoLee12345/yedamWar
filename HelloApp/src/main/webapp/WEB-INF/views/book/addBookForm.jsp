<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container">
	<h3>도서등록화면(addBookForm.jsp)</h3>
	<form action="addBook.do" method="post">
		<table class="table">
			<tr>
				<th>도서코드</th>
				<td><input class="col-sm-6" type="text" name="code" value="B1001"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input class="col-sm-6" type="text" name="title" value="이것은자바인가?"></td>
			</tr>
			<tr>
				<th>저자</th>
				<td><input class="col-sm-6" type="text" name="author" value="박자바"></td>
			</tr>
			<tr>
				<th>출판사</th>
				<td><input class="col-sm-6" type="text" name="press" value="자바출판사"></td>
			</tr>
			<tr>
				<th>가격</th>
				<td><input class="col-sm-6" type="text" name="price" value="20,000"></td>
			</tr>
			<tr>
				<td align="center" colspan=2>
					<input class="btn btn-primary" type="submit" value="등록">
					<input class="btn btn-danger" type="reset" value="취소"></td>
			</tr>
		</table>
	</form>
</div>