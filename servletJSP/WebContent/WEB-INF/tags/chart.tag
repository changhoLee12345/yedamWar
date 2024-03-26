<%@ tag body-content="scriptless" pageEncoding="UTF-8"%>

<%@ attribute name="title" required="true"%>
<%@ attribute name="color" required="true"%>

<table border="1">
	<thead>
		<tr>
			<th>${title }</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td bgcolor="${color }"><jsp:doBody /></td>
		</tr>
	</tbody>
</table>

