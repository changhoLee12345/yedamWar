<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>

<body>
    <h3>회원목록 페이지</h3>
    <c:choose>
        <c:when test="${not empty list }">
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Mail</th>
                    <th>Passwd</th>
                </tr>
                <c:forEach items="${list }" var="item">
                    <tr>
                        <td>${item.id }</td>
                        <td>${item.name }</td>
                        <td>${item.email }</td>
                        <td>${item.passwd }</td>
                    </tr>
                </c:forEach>
            </table>
            <h3></h3>
        </c:when>
        <c:otherwise>
            <h3>정보가 없습니다.</h3>
        </c:otherwise>
    </c:choose>
    
    <a onclick="loginFnc()">로그인</a>
    <jsp:include page="home.jsp" />
    
    <script>
		function loginFnc() {
			 window.open("login.html", "PopupWin", "top=500,left=500,width=400,height=400");

		}
    </script>
</body>

</html>