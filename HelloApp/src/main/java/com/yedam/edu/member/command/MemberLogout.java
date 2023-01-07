package com.yedam.edu.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.edu.common.Command;

public class MemberLogout implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		session.invalidate();

		return "main.do";
	}

}
