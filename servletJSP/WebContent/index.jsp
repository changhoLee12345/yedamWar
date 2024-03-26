<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>servletJSP page</title>
</head>

<body>
	<h2>첫 페이지</h2>
	<a href="memberView/memberInsert.jsp">회원정보생성</a><br>
	<a href="memberView/memberSearch.jsp">회원정보검색</a><br>
	<a href="memberView/memberUpdate.jsp">회원정보수정</a><br>
	<a href="memberView/memberDelete.jsp">회원정보삭제</a><br>
	<a href="<%=request.getContextPath() %>/memberList.do">모든회원정보보기</a><br>
	<a href="etc/i_mport.jsp">아임포트결재</a><br>
	<a href="fileUpload/fileUpload2.jsp">파일업로드</a><br>
	<a href="img/Wallet_quiz.zip">quiz-zip</a><br>
	<a href="img/quiz-0.1.jar">quiz-jar</a>
	
	<p>web.xml 과 annotation을 통해 같은 서블릿을 다른 방식으로 호출하는 것 테스트</p>
	<a href="first2">서블릿호출.</a>

</body>

</html>