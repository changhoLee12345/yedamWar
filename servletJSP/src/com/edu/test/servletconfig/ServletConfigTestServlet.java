package com.edu.test.servletconfig;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/servletConfig")
public class ServletConfigTestServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println(this.getServletContext().getContextPath() + ", " + req.getRequestURI());
//		System.out.println(req.getServletPath());

		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		String env = this.getInitParameter("charset");
		req.setCharacterEncoding(env);
		out.print("<h3>이름: " + req.getParameter("name"));
		out.close();
	}
}
