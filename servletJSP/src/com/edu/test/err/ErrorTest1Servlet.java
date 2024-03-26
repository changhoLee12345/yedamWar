package com.edu.test.err;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/errorTest1")
public class ErrorTest1Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		String getQuery = req.getQueryString();
		out.print("Query : " + getQuery + "<br>");
		out.print("Query 길이 : " + getQuery.length() + "<br>");
		out.print("Done");

		out.close();
	}
}
