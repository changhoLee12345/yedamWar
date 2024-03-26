package com.edu.test.stateless;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/context1")
public class ServletContextTest1Servlet extends HttpServlet {

	ServletContext sc;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config); // config 객체를 활용해서 init 처리해줘야지 된다. 안그러면.. 서블릿에서 config정보 없음..

		sc = config.getServletContext(); // 1. init()메소드를 통해 추출하는 방법.
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();

		sc = this.getServletContext(); // 2. 서블릿객체를 통해 추출하는 방법.

		String location = sc.getInitParameter("contextConfig"); // <context-param> 을 통해 init-param 지정.
		out.print("Context: " + location + "<br>");
		String persistent = sc.getInitParameter("contextConfigLocation");
		out.print("location: " + persistent);
		out.close();

	}
}
