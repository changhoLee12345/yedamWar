package com.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.common.Controller;

public class MemberJoinController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		ServletInputStream sis = request.getInputStream();
		byte[] buf = new byte[100];
		int readBuf = 0;
		while (true) {
			readBuf = sis.read();
			if (readBuf == -1)
				break;
			System.out.println((char) readBuf);
		}

	}

}
