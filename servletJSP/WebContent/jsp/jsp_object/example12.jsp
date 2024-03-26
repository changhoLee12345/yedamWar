<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	server:
	<%=application.getServerInfo()%><br> version:
	<%=application.getMajorVersion()%>.<%=application.getMinorVersion()%><br>
	realPath: <%=application.getRealPath("/")%><br>
	contextPath:<%=application.getContextPath()%><br>
	<h3>/edu list</h3>
	<%
	  Set<String> list = application.getResourcePaths("/");
	  if (list != null) {
		Object[] ary = list.toArray();
		for (int i = 0; i < ary.length; i++) {
		  out.print(ary[i] + "<br>");
		}
	  }
	%>
</body>
</html>