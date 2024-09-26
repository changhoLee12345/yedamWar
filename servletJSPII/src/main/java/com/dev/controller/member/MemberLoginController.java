package com.dev.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.common.Controller;
import com.dev.common.HttpUtil;
import com.dev.service.MemberServiceImpl;
import com.dev.vo.MemberVO;

public class MemberLoginController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String id = request.getParameter("mid");
		String pw = request.getParameter("passwd");

		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPasswd(pw);

		MemberServiceImpl service = MemberServiceImpl.getInstance();
		vo = service.login(vo);
		request.setAttribute("vo", vo);

		HttpUtil.forward(request, response, "member/memberInsertOutput.tiles");

	}

}
