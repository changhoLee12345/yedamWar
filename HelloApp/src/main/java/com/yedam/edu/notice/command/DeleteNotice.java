package com.yedam.edu.notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.edu.common.Command;
import com.yedam.edu.notice.service.NoticeService;
import com.yedam.edu.notice.service.impl.NoticeServiceImpl;

public class DeleteNotice implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String num = request.getParameter("num");
		NoticeService service = new NoticeServiceImpl();
		service.deleteNotice(Integer.parseInt(num));
		return "noticeList.do";
	}

}
