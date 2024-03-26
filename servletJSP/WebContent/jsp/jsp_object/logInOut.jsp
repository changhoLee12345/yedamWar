<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>logInOut.jsp</title>
</head>

<body>
	<%
	  String msg = (String) request.getAttribute("error");
	  if (msg == null) {
		msg = "";
	  }
	%>
	<%=msg %>
	<%
	  if (session.isNew() || session.getAttribute("id") == null) {
	%>
	  <form action="example10.jsp" method="post">
		ID: <input type="text" name="id"><br>
		PW: <input type="password" name="pwd"><br>
		<input type="submit" value="LogIn">
	  </form>
	<%
	  } else {
	%>
	    <a href="example10.jsp">LogOut</a>
	<%
	  }
	%>

</body>

</html>