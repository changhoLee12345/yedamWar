<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<link rel="stylesheet" href="css/todo.css">
<script src="js/custToDo.js"></script>
<div align="center">
	<div>
		<h1>책 목록보기(JSP)</h1>
	</div>
	<div>
		<ul>
			<c:forEach items="${books }" var="b">
				<li> <span class="primary">${b.bookCode }</span> <span>${b.bookTitle }</span> <span>${b.bookAuthor
						}</span>
					<span class="close">X</span>
				</li>
			</c:forEach>
		</ul>
		<button type="button" onclick="location.href='bookInsertForm.do'">도서등록</button>
	</div>
	<hr>
	<h1>Ajax 목록보기.</h1>
	<div id="show"></div>
	<script>
		fetch('ajaxBookList.do')
			.then(resolve => resolve.json())
			.then(showList)
			.catch(err => console.log(err))

		function showList(result) {
			console.log(this.innerWidth)
			let width = this.innerWidth;
			ToDo.initData = result;
			document.getElementById('show').append(ToDo.genUL());
			// 추가 요소.
			document.querySelectorAll('#show li').forEach(li => {
				let cnt = li.children.length;
				let perWidth = width / cnt + 1;
				for (const item of li.children) {
					item.style.display = 'inline-block';
					item.style.width = 150 + 'px';
				}
				li.firstChild.className = "primary"
				let span = document.createElement('span');
				span.className = 'close'
				span.append('X')
				li.append(span)
			})
		}
	</script>
</div>