<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script>
		//서블릿은없음..단순히 formdata를 사용하는 부분만 확인을 하기 위해서 가져옴.
		function createNewsAndEvents(e) {
			e.preventDefault();

			var frm = document.getElementById('createNewsAndEventsForm');
			frm.method = 'POST';
			frm.enctype = 'multipart/form-data';
			var fileData = new FormData(frm)

			jQuery.ajax({
				type: "POST",
				enctype: 'multipart/form-data',
				cache: false,
				url: 'restapi/createNewsAndEvents.do',
				data: fileData,
				async: false,
				contentType: false,
				processData: false,
				dataType: 'json',
				success: function (msg) {
					jQuery('#createNewsAndEventsForm')[0].reset(); //폼내용 삭제
				},
				fail: function (err) {
					console.log(err);
				}
			});

		}
	</script>
</head>

<body>
	<div id="createWindow">
		<div>
			<form id="createNewsAndEventsForm" method="post" enctype="multipart/form-data">
				<div class="form-group">
					<label for=enTitle>영문 제목</label>
					<div>
						<input id="enTitle" name="enTitle">
					</div>
				</div>
				<div class="form-group">
					<label for=files>이미지</label>
					<div>
						<input name="files" id="files" type="file" />
					</div>
				</div>
				<div>
					<button onClick="createNewsAndEvents(event)">생성</button>
				</div>
			</form>
		</div>
	</div>
</body>

</html>