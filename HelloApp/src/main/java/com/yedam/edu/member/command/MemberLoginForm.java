package com.yedam.edu.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.edu.common.Command;

public class MemberLoginForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
//		return "main/loginForm.tiles";
		return "main/kakaoAuth.tiles";
	}

}
