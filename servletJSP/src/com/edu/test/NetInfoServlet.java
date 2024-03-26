package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/netInfo")
public class NetInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println(this.getServletContext().getContextPath() + request.getRequestURI());
		System.out.println(request.getServletPath());

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>Request 정보 출력 Servlet</title></head>");
		out.print("<body>");
		out.print("<h3>네트춰크 관련 정보 요청</h3>");
		out.print("Request  Scheme: " + request.getScheme() + "<br>");
		out.print("Server Name: " + request.getServerName() + "<br>");
		out.print("Server Address: " + request.getLocalAddr() + "<br>");
		out.print("Server Port: " + request.getServerPort() + "<br>");
		out.print("Client Address: " + request.getRemoteAddr() + "<br>");
		out.print("Client Host: " + request.getRemoteHost() + "<br>");
		out.print("Client Port: " + request.getRemotePort() + "<br>");
		out.print("</body></html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
