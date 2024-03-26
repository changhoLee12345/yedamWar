package com.edu.test.stateless;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dispatcher1")
public class DispatcherTest1Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print("<h3>Dispatcher Test 1</h3>");
		ServletContext sc = this.getServletContext();
		RequestDispatcher rd;
//		rd = sc.getNamedDispatcher("com.edu.test.DispatcherTest2Servlet");
		rd = sc.getRequestDispatcher("/dispatcher2");
//		rd.forward(req, resp);
		rd.include(req, resp);
		out.close();
	}
}
