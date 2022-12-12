<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<div align="center">
		<div>
			<h3>도서등록</h3>
		</div>
		<div>
			<form id="frm" name="frm" action="bookInsert.do" method="post" enctype="multipart/form-data">
				<div>
					<table class="table">
						<tr>
							<th width="150">도서코드</th>
							<td width="250">
								<input type="text" id="bookCode" name="bookCode" value="B1201">
							</td>
						</tr>
						<tr>
							<th width="150">도서명</th>
							<td width="250">
								<input type="text" id="bookTitle" name="bookTitle" value="영일">
							</td>
						</tr>
						<tr>
							<th width="150">저자</th>
							<td width="250">
								<input type="text" id="bookAuthor" name="bookAuthor" value="영일이">
							</td>
						</tr>
						<tr>
							<th width="150">출판사</th>
							<td width="250">
								<input type="text" id="bookPress" name="bookPress" value="영일출">
							</td>
						</tr>
						<tr>
							<th width="150">가격</th>
							<td width="250">
								<input type="text" id="bookPrice" name="bookPrice" value="10000">
							</td>
						</tr>
						<tr>
							<th width="150">도서이미지1</th>
							<td width="250">
								<input type="file" id="file1" name="file1" multiple>
							</td>
						</tr>
						<tr>
							<th width="150">도서이미지2</th>
							<td width="250">
								<input type="file" id="file2" name="file2" multiple>
							</td>
						</tr>
						<tr>
							<th width="150">도서이미지3</th>
							<td width="250">
								<input type="file" id="file3" name="file3" multiple>
							</td>
						</tr>
					</table>
				</div><br>
				<div>
					<input type="submit" value="등록">
				</div>
			</form>
		</div>
	</div>

	<form id="bookFrm" action="bookInsert.do" method="post">
		bookCode: <input type="text" name="bookCode" value="이것이"><br>
		bookTitle: <input type="text" name="bookTitle" id="bookTitle" value="자바다"><br>
		File: <input type="file" id="file1" name="file1"><br>
		<input type="submit" value="book submit"><br>
	</form>

	<script>
		console.log("first")
		setTimeout(function () {
			console.log("second")

		}, 0)
		console.log("third")

		bookFrm.addEventListener('submit', function (e) {
			e.preventDefault();
			var url = "bookInsert.do";

			formDataFunc(url);
		})

		// FormData를 사용해서 업로드처리.
		function formDataFunc(url) {
			const formData = new FormData();

			formData.append("bookCode", "Groucho");
			formData.append("bookPrice", 123456); // number 123456 is immediately converted to a string "123456"

			// HTML file input, chosen by user
			var fileInputElement = document.getElementById('file1');
			formData.append("userfile", fileInputElement.files[0]);

			// JavaScript file-like object
			const content = '<q id="a"><span id="b">hey!</span></q>'; // the body of the new file…
			const blob = new Blob([content], {
				type: "text/xml"
			});

			formData.append("webmasterfile", blob);

			const request = new XMLHttpRequest();
			request.open("POST", url);
			request.send(formData);

		}

		// FormData로는 json으로 업로드 안됨. 그래서 {}로 만들어서 stringify하도록.
		function fetchJson() {
			let frmData = new FormData(this);
			var url = 'bookInsert.do';

			frmData.append("title", "이것이자바다")
			frmData.append("press", "자바출판사")

			let frmObj = {}
			for (const [key, val] of frmData) {
				frmObj[key] = val;
			}

			fetch(url, {
					method: 'post',
					headers: {
						'Content-Type': 'application/json',
					},
					body: JSON.stringify(frmObj)
				}).then(result => result.json())
				.then(result => console.log(result))
				.catch(err => console.log(err))
		}

		document.getElementById('frm').addEventListener('submit', function (e) {
			e.preventDefault();

			var url = 'bookInsert.do';
			multiUpload(url);

		})

		// json 업로드.
		function jsonUpload(url) {
			fetch(url, {
					method: 'POST', // *GET, POST, PUT, DELETE, etc.
					mode: 'cors', // no-cors, *cors, same-origin
					cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
					credentials: 'same-origin', // include, *same-origin, omit
					headers: {
						'Content-Type': 'application/json'
						// 'Content-Type': 'application/x-www-form-urlencoded',
					},
					redirect: 'follow', // manual, *follow, error
					referrerPolicy: 'no-referrer', // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url
					body: JSON.stringify(data) // body data type must match "Content-Type" header
				}).then(result => result.json())
				.then(result => console.log(resuot))
				.catch(err => console.log(err))
		}

		// FormData로 업로드.
		function fileUpload(url) {
			const formData = new FormData();
			const fileField = document.querySelector('input[type="file"]');

			formData.append('username', 'abc123');
			formData.append('avatar', fileField.files[0]);

			fetch(url, {
					method: 'PUT',
					body: formData
				})
				.then((response) => response.json())
				.then((result) => {
					console.log('Success:', result);
				})
				.catch((error) => {
					console.error('Error:', error);
				});

		}

		// multipart업로드.
		function multiUpload(url) {
			const formData = new FormData();
			const photos = document.querySelectorAll('input[type="file"][multiple]');
			console.log(photos);

			formData.append('title', 'My Vegas Vacation');
			formData.append('bookCode', document.getElementById('bookCode').value);
			formData.append('bookTitle', document.getElementById('bookTitle').value);
			formData.append('bookAuthor', document.getElementById('bookAuthor').value);
			formData.append('bookPress', document.getElementById('bookPress').value);
			formData.append('bookPrice', document.getElementById('bookPrice').value);

			let i = 0;
			for (const photo of photos) {
				for (const elem of photo.files) {
					console.log(photo)
					formData.append(`photos_` + i, elem);
					i++;
				}
			}
			for (let ent of formData.entries()) {
				console.log(ent)
			}

			fetch(url, {
					method: 'POST',
					body: formData,
				})
				.then((response) => response.json())
				.then((result) => {
					console.log('Success:', result);
				})
				.catch((error) => {
					console.error('Error:', error);
				});

		}
	</script>
</body>

</html>