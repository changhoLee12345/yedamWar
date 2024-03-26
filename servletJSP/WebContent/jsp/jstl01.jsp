<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>jstl01.jsp</title>

<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="//cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>

<script>
	$(document).ready(function() {
		//$('#example').DataTable();
	});
</script>
</head>

<body>
	<sql:query var="rs" dataSource="jdbc/myoracle">
		select employee_id, first_name, last_name, email from employees
	</sql:query>

	<table border="1" id="example" class="display" style="width: 90%">
		<thead>
			<tr>
				<c:forEach var="columnName" items="${rs.columnNames }">
					<th><c:out value="${columnName }"></c:out></th>
				</c:forEach>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="row" items="${rs.rows }">
				<tr>
					<td><c:out value="${row.employee_Id }"></c:out></td>
					<td><c:out value="${row.first_Name }"></c:out></td>
					<td><c:out value="${row.last_Name }"></c:out></td>
					<td><c:out value="${row.email }"></c:out></td>
				</tr>
			</c:forEach>
				<tr><td colspan="4">==========================new =========================</td></tr>
			<c:forEach var="row" items="${data }">
				<tr>
					<td><c:out value="${row.employeeId }"></c:out></td>
					<td><c:out value="${row.firstName }"></c:out></td>
					<td><c:out value="${row.lastName }"></c:out></td>
					<td><c:out value="${row.email }"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>

</html>