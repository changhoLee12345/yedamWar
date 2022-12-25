package com.yedam.edu.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.edu.common.Command;
import com.yedam.edu.member.service.MemberService;
import com.yedam.edu.member.service.impl.MemberServiceImpl;
import com.yedam.edu.member.vo.MemberVO;

public class MemberLogin implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String id = request.getParameter("userId");
		String pwd = request.getParameter("userPw");
		String message = "";
		String page = "";

		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPasswd(pwd);

		MemberService service = new MemberServiceImpl();
		vo = service.loginCheck(vo);

		if (vo == null) {
			message = "로그인 정보를 확인하세요.";
			page = "member/loginForm.tiles";
		} else {
			message = vo.getName() + ", 환영합니다.";
			page = "member/login.tiles";
			request.setAttribute("member", vo);

			session.setAttribute("id", vo.getId());
			System.out.println(vo.getId());
		}
		request.setAttribute("message", message);

		return page;
	}

}
