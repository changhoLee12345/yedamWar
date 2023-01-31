package com.yedam.edu.notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.edu.common.Command;

public class NoticeListJsonForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "notice/noticeListJsonForm.tiles";
	}

}
