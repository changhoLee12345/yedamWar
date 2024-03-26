<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>

<body>
    <form action="<%= application.getContextPath() %>/FileUploadServl" method="post" enctype="multipart/form-data">
        제목 : <input type="text" name="title" value="title test"><br>
        내용 : <input type="text" name="content" value="content test"><br>
        파일 설명 : <input type="text" name="description" value="file desc"><br>
        파일1 : <input type="file" name="file1"><br>
        파일2 : <input type="file" name="file2"><br>
        <input type="submit" value="전송">
    </form>
    <!-- 출처: https://dololak.tistory.com/726 [코끼리를 냉장고에 넣는 방법] -->
</body>

</html>