<%@page import="java.util.List"%>
<%@page import="com.dev.vo.MemberVO"%>
<%@page import="com.dev.service.MemberServiceImpl"%>
<%@page import="com.dev.service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
// ${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/

String job = request.getParameter("job");
String id = request.getParameter("id");
String pw = request.getParameter("passwd");
String name = request.getParameter("name");
String email = request.getParameter("mail");

MemberService svc = MemberServiceImpl.getInstance();
MemberVO member = new MemberVO();
// String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/" + request.getContextPath();

// memberControl.jsp 를 호출하면 목록을 기본으로 보여주고 그 외에는 job에 따라서 처리한다.
if (job == null) {
	List<MemberVO> list = svc.memberList();
	request.setAttribute("list", list);

	request.getRequestDispatcher("./memberResult/memberListOutput.jsp").forward(request, response);

} else {
	if (job.equals("form")) {
		response.sendRedirect("./memberView/memberInsert.jsp");

	} else if (job.equals("insert")) {

		member.setId(id);
		member.setPasswd(pw);
		member.setName(name);
		member.setEmail(email);

		svc.addMember(member);

		response.sendRedirect("./memberControl/memberControl.jsp");

	} else if (job.equals("search")) {
		member = svc.getMember(id);
		request.setAttribute("member", member);

		request.getRequestDispatcher("./memberResult/memberInfoOutput.jsp").forward(request, response);

	} else {
		List<MemberVO> list = svc.memberList();
		request.setAttribute("list", list);

		request.getRequestDispatcher("./memberResult/memberListOutput.jsp").forward(request, response);
	}
}
%>