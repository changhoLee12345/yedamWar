package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/third")
public class ThirdServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 기본값값은 text/html;chartset=8859_1
		resp.setContentType("text/html;charset=utf-8");

		PrintWriter out = resp.getWriter();
		out.print("<h1>좋은 하루!</h1>");
		int i = 1;
		while (i <= 10) {
			out.print("<br>Number: " + i++);

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		out.print("<br>실행완료!");
		out.close();
	}
}
