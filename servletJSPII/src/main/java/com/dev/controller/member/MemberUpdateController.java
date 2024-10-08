package com.dev.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.common.Controller;
import com.dev.common.HttpUtil;
import com.dev.service.MemberServiceImpl;
import com.dev.vo.MemberVO;

public class MemberUpdateController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");

		if (id.isEmpty() || passwd.isEmpty() || name.isEmpty() || mail.isEmpty()) {
			request.setAttribute("error", "모든 항목입력하세요!");
			HttpUtil.forward(request, response, "memberView/memberUpdate.jsp");
			return;
		}

		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPasswd(passwd);
		member.setName(name);
		member.setEmail(mail);

		MemberServiceImpl service = MemberServiceImpl.getInstance();
		service.modifyMember(member);

		request.setAttribute("id", id);
		HttpUtil.forward(request, response, "memberResult/memberUpdateOutput.jsp");

	}

}