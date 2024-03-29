<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<!-- <script src="${pageContext.request.contextPath }/ckeditor/ckeditor.js"></script> -->
	<script src="https://cdn.ckeditor.com/4.20.2/standard-all/ckeditor.js"></script>
	<script>
		document.addEventListener('DOMContentLoaded', function () {
			CKEDITOR.replace('desc', {
				filebrowserUploadUrl: '${pageContext.request.contextPath}/bookUpload.do'
			})
		})
	</script>
</head>

<body>

	<div class="container">
		<h3>도서등록화면(addBookForm.jsp)</h3>
		<form action="${pageContext.request.contextPath}/addBook.do" method="post">
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
					<th>설명</th>
					<td><textarea class="col-sm-6" name="desc"></textarea></td>
				</tr>
				<tr>
					<td align="center" colspan=2>
						<input class="btn btn-primary" type="submit" value="등록">
						<input class="btn btn-danger" type="reset" value="취소"></td>
				</tr>
			</table>
		</form>
	</div>


</body>

</html>