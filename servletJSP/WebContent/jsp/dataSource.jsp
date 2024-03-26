<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>${pageContext.servletConfig.servletContext.contextPath }</h3>
	<%
	// JNDI 서버 객체 생성	
	InitialContext ic = new InitialContext();
	// 룩업
	DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/myoracle");
	// Connection
	Connection conn = ds.getConnection();

	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery("select * from departments order by 1");

	while (rs.next()) {
		out.print("<br>" + rs.getString("department_id") + ", " + rs.getString("department_name"));
	}
	rs.close();
	stmt.close();
	conn.close();
	%>

</body>
</html>