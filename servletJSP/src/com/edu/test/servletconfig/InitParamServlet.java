package com.edu.test.servletconfig;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitParamServlet extends HttpServlet {

	String id, passwd;

	public InitParamServlet() {
		System.out.println("서버 실행시 load_on_startup: InitParamServlet");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		id = config.getInitParameter("id");
		passwd = config.getInitParameter("password");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		System.out.println(this.getServletContext().getContextPath() + req.getRequestURI());
		System.out.println(req.getServletPath());

		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print("<h2>서블릿 초기 추출 변수</h2>");
		out.print("<h3>ID: " + id + "</h3>");
		out.print("<h3>PASSWD: " + passwd + "</h3>");
		out.close();
	}

}
