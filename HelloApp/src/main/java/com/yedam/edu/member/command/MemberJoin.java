package com.yedam.edu.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.edu.common.Command;

public class MemberJoin implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		// id, passwd, name, email, responsibility, pfilename, ofilename, cdate
		String id = request.getParameter("id");
		String pw = request.getParameter("passwd");
		return null;
	}

}
