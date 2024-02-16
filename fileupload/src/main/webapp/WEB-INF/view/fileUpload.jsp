<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>

<body>
    <form action="fileUpload.do" method="post" enctype="multipart/form-data">
        <table>
            <tbody>
                <tr>
                    <th>이름</th>
                    <th><input type="text" name="name" id=""></th>
                </tr>
                <tr>
                    <th>파일</th>
                    <th><input multiple type="file" name="image" id=""></th>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="upload">
                    </td>
                </tr>
            </tbody>
        </table>
    </form>
</body>

</html>