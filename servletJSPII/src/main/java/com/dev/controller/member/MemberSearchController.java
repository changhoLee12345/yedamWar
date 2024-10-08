package com.dev.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.common.Controller;
import com.dev.common.HttpUtil;
import com.dev.service.MemberServiceImpl;
import com.dev.vo.MemberVO;

public class MemberSearchController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");
		String job = request.getParameter("job");
		String path = null;

		if (job.equals("search")) {
			path = "member/memberSearch.tiles";
		} else if (job.equals("update")) {
			path = "member/memberUpdate.tiles";
		} else if (job.equals("delete")) {
			path = "member/memberDelete.tiles";
		}

		if (id.isEmpty()) {
			request.setAttribute("error", "id를 입력하세요");
			HttpUtil.forward(request, response, path);
			return;
		}

		MemberServiceImpl service = MemberServiceImpl.getInstance();
		MemberVO member = service.getMember(id);
		System.out.println(member);

		if (member == null) {
			request.setAttribute("result", "검색된 정보가 없습니다");
		}

		request.setAttribute("member", member);

		if (job.equals("search")) {
			path = "member/memberSearchOutput.tiles";
		}

		HttpUtil.forward(request, response, path);

	}

}
