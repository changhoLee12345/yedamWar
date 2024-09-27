package com.dev.controller.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.common.Controller;
import com.dev.common.HttpUtil;
import com.dev.dao.MemberJdbc;
import com.dev.dao.MemberMybatis;
import com.dev.service.MemberServiceImpl;
import com.dev.vo.MemberVO;

public class MemberListController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		MemberServiceImpl service = MemberServiceImpl.getInstance();

		List<MemberVO> list = service.memberList();
		request.setAttribute("list", list);

		HttpUtil.forward(request, response, "member/memberListOutput.tiles");
	}

}