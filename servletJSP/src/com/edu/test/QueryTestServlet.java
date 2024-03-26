package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/queryTest", "/queryTest2" })
public class QueryTestServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		System.out.println(this.getServletContext().getContextPath() + request.getRequestURI());
//		System.out.println(request.getServletPath());

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>Query 문자열 테스트</title></head>");
		out.print("<body><h1>Get방식 요청</h1></body>");
		get(request, response);
		out.print("</html>");
		out.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		post(request, response);
		// response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		out.print("<html><head><title>Query 문자열 테스트</title></head>");
//		out.print("<body><h1>Post방식 요청</h1></body>");
//		out.print("</html>");
//		out.close();
	}

	private void get(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("id");
		String name = request.getParameter("id");
		String[] hobbies = request.getParameterValues("id");
		String gender = request.getParameter("id");
		String religion = request.getParameter("id");
		String intro = request.getParameter("id");

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("ID: " + id + "<br>");
		out.println("비밀번호: " + pwd + "<br>");
		out.println("이름: " + name + "<br>");
		out.println("취미: ");
		for (int i = 0; i < hobbies.length; i++) {
			out.print(hobbies[i] + " ");
		}
		out.println("<br>");
		out.println("성별: " + gender + "<br>");
		out.println("종교: " + religion + "<br>");
		out.println("소개: " + intro + "<br>");
		out.print("질의문자열(get): " + request.getQueryString());
		out.close();

	}

	private void post(HttpServletRequest request, HttpServletResponse response) throws IOException {

		etc(request, response);
//		String id = request.getParameter("id");
//		String pwd = request.getParameter("id");
//		String name = request.getParameter("id");
//		String[] hobbies = request.getParameterValues("id");
//		String gender = request.getParameter("id");
//		String religion = request.getParameter("id");
//		String intro = request.getParameter("id");
//
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		out.println("ID: " + id + "<br>");
//		out.println("비밀번호: " + pwd + "<br>");
//		out.println("이름: " + name + "<br>");
//		out.println("취미: ");
//		for (int i = 0; i < hobbies.length; i++) {
//			out.print(hobbies[i] + " ");
//		}
//		out.println("<br>");
//		out.println("성별: " + gender + "<br>");
//		out.println("종교: " + religion + "<br>");
//		out.println("소개: " + intro + "<br>");
//
//		out.close();

	}

	private void etc(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>Request정보출력</title></head>");
		out.print("<body>");
		out.print("<h1>Post방식</h1>");

		ServletInputStream input = request.getInputStream();
		int len = request.getContentLength();
		byte[] buf = new byte[len];
		input.readLine(buf, 0, len);
		String str = new String(buf);
		System.out.println("질의문자열: " + str);

		out.print("질의문자열(post): " + str);
		out.print("</body></html>");
		out.close();

	}
}
