<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>도서검색페이지(searchBookForm.jsp)</h3>

<form action="searchBook.do" method="get">
	<table class="table">
		<tr>
			<th>도서코드</th>
			<td><input type="text" name="code" id="code"></td>
		</tr>
		<tr>
			<th>도서명</th>
			<td><input type="text" name="title" id="title"></td>
		</tr>
		<tr>
			<th>저자</th>
			<td><input type="text" name="author" id="author"></td>
		</tr>
		<tr>
			<th>출판사</th>
			<td><input type="text" name="press" id="press"></td>
		</tr>
		<tr>
			<th>가격</th>
			<td><input type="number" name="price1" id="price1"> ~ <input type="number" name="price2" id="price2"></td>
		</tr>
		<tr>
			<td align="center" colspan=2><input class="btn btn-primary" type="submit" value="조회"> 
			                             <input class="btn btn-danger" type="reset" value="취소">
			</td>
		</tr>
		
	</table>
</form>