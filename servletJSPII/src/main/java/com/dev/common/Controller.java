package com.dev.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {

	public static String getMethodName(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/json;charset=utf-8");

		String uri = request.getRequestURI();
		String context = request.getContextPath();
		String page = uri.substring(context.length());

		// 요청uri값에서 /와 .do 제외한 값을 실행할 메소드의 지정.
		String methodName = page.substring(1, page.indexOf("."));
		return methodName;
	}

	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;

}
