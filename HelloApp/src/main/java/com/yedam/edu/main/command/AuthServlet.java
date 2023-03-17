package com.yedam.edu.main.command;

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

@WebServlet("/oauth")
public class AuthServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getParameter("code"));

		String auth_key = "2bb22c2460e07f8998d89b80b2771508";
		String req1 = "https://kapi.kakao.com/v1/payment/ready/authorize?response_type=code&client_id=708649bd2a5f285a82328c026a3c29a4&redirect_uri=http://localhost:8080/HelloApp/SomeResourceServ";
		URL url = new URL(req1);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		String line;
		while ((line = br.readLine()) != null)
			System.out.println(line);

	}
}
