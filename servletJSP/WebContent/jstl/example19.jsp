<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		div {
			display: inline-block;
			background-color: yellow;
			width: 12%;
			margin-right: 20px;
		}
	</style>
</head>

<body>
	<div>initParam: </div>${initParam }<br>
	<div>file-upload: </div>${initParam["file-upload"] }<br>
	<div>contextConfig: </div>${initParam.contextConfig }<br>
	<div>contextConfigLocation: </div>${initParam.contextConfigLocation }<br>

	<div>pageContext: </div>${pageContext }<br>
	<div>pageScore: </div>${pageScope }<br>
	<div>requestScopre: </div>${requestScope }<br>
	<div>sessionScope: </div>${sessionScope }<br>
	<div>applicationScope: </div>
	<c:forEach varStatus="sts" var="item" items="${applicationScope }">
	  <p>item: ${item }</p>
	</c:forEach> 
	${applicationScope }
	<br>
	<div>cookie: </div>${cookie }<br>
	<div>header: </div>${header }<br>
	<div>headerValues: </div>${headerValues }<br>
	<div>param: </div>${param }<br>
	<div>paramValue: </div>${paramValues }<br>

</body>

</html>