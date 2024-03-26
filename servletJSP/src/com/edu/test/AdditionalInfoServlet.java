package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/addInfo")
public class AdditionalInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdditionalInfoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(this.getServletContext().getContextPath() + request.getRequestURI());
		System.out.println(request.getServletPath());

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>Request정보출력</title></head>");
		out.print("<body><h3>추가적인 요청정보</h3>");
		out.print("<h4>Request Mthod: " + request.getMethod() + "</h4>");
		out.print("<h4>Path Info: " + request.getPathInfo() + "</h4>");
		out.print("<h4>Path Translated: " + request.getPathTranslated() + "</h4>");
		out.print("<h4>Query String: " + request.getQueryString() + "</h4>");
		out.print("<h4>Content Length: " + request.getContentLength() + "</h4>");
		out.print("<h4>Content Type: " + request.getContentType() + "</h4>");
		out.print("</html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
