<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
%>
<h3><%=id %></h3>
<button onclick="closeFnc()">close</button>
<script>
	function closeFnc(){
		opener.id="guest";
		console.log(this);
		setTimeout(function() {
			window.opener.name="hong";
			window.opener.username1.value = "hong123";
			window.close();		
		}, 1000)
	}
</script>