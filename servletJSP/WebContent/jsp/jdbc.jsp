<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	Connection conn = DriverManager.getConnection(url, "hr", "hr");
	Statement stmt = conn.createStatement();
	//stmt.executeUpdate("create table test(id varchar2(5), pwd varchar2(5))");
	//stmt.executeUpdate("insert into test values('aa','11')");
	//stmt.executeUpdate("insert into test values('cc','22')");
	//stmt.executeUpdate("insert into test values('bb','33')");
	ResultSet rs = stmt.executeQuery("select * from test");
	while(rs.next()) {
		out.println(rs.getString(1) + " : " + rs.getString(2) + "<br>");
	}
	rs.close();
	stmt.close();
	conn.close();
%>