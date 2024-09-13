package com.dev.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.common.Controller;
import com.dev.common.HttpUtil;
import com.dev.service.MemberServiceImpl;

public class MemberDeleteController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String id = request.getParameter("id");

		MemberServiceImpl service = MemberServiceImpl.getInstance();
		service.removeMember(id);

		HttpUtil.forward(request, response, "memberResult/memberDeleteOutput.jsp");
	}

}
