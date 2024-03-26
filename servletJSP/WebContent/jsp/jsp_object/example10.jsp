<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>example10.jsp</title>
</head>

<body>
	<%
	if (request.getMethod().equals("POST")) { // 로그인 처리..

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		if (id.isEmpty() || pwd.isEmpty()) {

			request.setAttribute("error", "ID, PW 입력하세요");

			RequestDispatcher rd = request.getRequestDispatcher("logInOut.jsp");
			rd.forward(request, response);

		}

		if (session.isNew() || session.getAttribute("id") == null) {
			session.setAttribute("id", id);
			out.print("로그인 완료.");
		} else {
			out.print("이미 로그인.");
		}

	} else { // 로그아웃처리...

		if (session.getAttribute("id") != null) {
			session.invalidate();
			out.print("로그아웃 처리됨.");
		} else {
			out.print("로그인 상태가 아님.");
		}

	}
	%>
	<a href="logInOut.jsp">Log Page</a>
</body>

</html>