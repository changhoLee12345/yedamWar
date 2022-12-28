<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>회원정보입력</title>
</head>

<body>
    <h3>회원가입</h3>
    <form action="<%=request.getContextPath() %>/memberJoin.do" enctype="multipart/form-data">
        ID: <input type="text" name="id" value="user1"><br>
        PW: <input type="password" name="passwd" value="1234"><br>
        Name: <input type="text" name="name" value="홍길동"><br>
        Mail: <input type="email" name="mail" value="email@com"><br>
        <input type="submit">
    </form>
</body>

</html>