package com.yedam.edu.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.edu.common.Command;
import com.yedam.edu.member.service.MemberService;
import com.yedam.edu.member.service.impl.MemberServiceMybatis;
import com.yedam.edu.member.vo.MemberVO;

public class MemberForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");

		MemberService service = new MemberServiceMybatis();
		MemberVO vo = service.searchMember(id);

		request.setAttribute("member", vo);

		return "member/memberForm.tiles";
	}

}
