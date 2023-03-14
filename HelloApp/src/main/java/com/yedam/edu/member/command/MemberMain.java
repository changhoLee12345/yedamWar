package com.yedam.edu.member.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.edu.common.Command;
import com.yedam.edu.member.service.MemberService;
import com.yedam.edu.member.service.impl.MemberServiceMybatis;
import com.yedam.edu.member.vo.MemberVO;

public class MemberMain implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		MemberService service = new MemberServiceMybatis();
		List<MemberVO> list = service.memberList();
		request.setAttribute("members", list);

		return "member/member.tiles";
	}

}
