<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<sql:query var="rs" dataSource="jdbc/myoracle">
	select * from employees
</sql:query>

<table border="1">
	<tr>
		<c:forEach var="columnName" items="${rs.columnNames }">
			<th>
				<c:out value="${columnName }" />
			</th>
		</c:forEach>
	</tr>
</table>

<a href="examList.jsp">리스트</a>