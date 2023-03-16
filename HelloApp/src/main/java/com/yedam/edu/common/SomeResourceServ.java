package com.yedam.edu.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SomeResourceServ")
public class SomeResourceServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SomeResourceServ() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String auth_key = request.getParameter("code");
//		System.out.println(auth_key);

		String req1 = "https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=708649bd2a5f285a82328c026a3c29a4&redirect_uri=http://localhost:8080/HelloApp/SomeResourceServ";
		URL url = new URL(req1);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		String line;
		line = br.readLine();
		System.out.println(line);

		String reqUrl = "https://kauth.kakao.com/oauth/token?client_id=708649bd2a5f285a82328c026a3c29a4&redirect_uri=http://localhost:8080/HelloApp/SomeResourceServ&code="
				+ line + "&grant_type=authorization_code";
		url = new URL(reqUrl);
		conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

		line = br.readLine();

		// https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=${REST_API_KEY}&redirect_uri=${REDIRECT_URI}

//		while ((line = br.readLine()) != null) {
//			System.out.println(line);
//		}
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().print(line);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
