package com.yedam.edu.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/notFoundHandler")
public class NotFoundHandlerServ extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html;charset=utf-8");
		String path = (String) req.getAttribute("errorPage");
		String str = "";
		str += "<!DOCTYPE html><html><head><meta charset=\"UTF-8\"><title>Error Page</title></head>";
		str += "<body><h3>요청한 페이지는 존재하지 않습니다.</h3>";
		str += "<p>요청페이지 정보: " + path + "</p>";
		str += "<p><a href='main.do'>첫페이지로</a></p>";
		str += "</body></html>";
		resp.getWriter().print(str);
	}
}
