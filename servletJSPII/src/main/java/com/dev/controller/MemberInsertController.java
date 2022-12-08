package com.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.common.Controller;
import com.dev.common.HttpUtil;
import com.dev.service.MemberService;
import com.dev.vo.MemberVO;

public class MemberInsertController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");

		if (id.isEmpty() || passwd.isEmpty() || name.isEmpty() || mail.isEmpty()) {
			request.setAttribute("error", "모든 항목입력하세요!");
			HttpUtil.forward(request, response, "member/memberInsert.tiles");
			return;
		}

		MemberVO member = new MemberVO();
		member.setId(id);
		member.setName(name);
		member.setPasswd(passwd);
		member.setEmail(mail);

		MemberService service = MemberService.getInstance();
		service.memberInsert(member);

		request.setAttribute("id", id);
		HttpUtil.forward(request, response, "member/memberInsertOutput.tiles");
	}

}