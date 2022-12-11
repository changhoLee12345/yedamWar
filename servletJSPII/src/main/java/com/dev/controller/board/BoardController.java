package com.dev.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.common.Controller;
import com.dev.service.BoardServiceImpl;

public class BoardController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String bno = request.getParameter("bno");
		BoardServiceImpl service = new BoardServiceImpl();
		System.out.println(service.getBoard(Integer.parseInt(bno)));
	}

}
