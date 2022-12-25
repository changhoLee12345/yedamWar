package com.yedam.edu.notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.edu.common.Command;
import com.yedam.edu.notice.service.NoticeService;
import com.yedam.edu.notice.service.impl.NoticeServiceImpl;
import com.yedam.edu.notice.vo.NoticeVO;

public class NoticeSearch implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String num = request.getParameter("num");
		num = num == null ? "1" : num;

		NoticeService service = new NoticeServiceImpl();
		NoticeVO vo = service.searchNotice(Integer.parseInt(num));
		System.out.println(vo);

		request.setAttribute("vo", vo);

		return "notice/getNotice.tiles";
	}

}
