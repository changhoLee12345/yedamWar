package com.dev.controller;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.common.Controller;
import com.dev.common.HttpUtil;

public class MainController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		// 요청uri값에서 /와 .do 제외한 값을 실행할 메소드의 지정.
		String methodName = Controller.getMethodName(request, response);
		try {
//			Class<?> cls =  Class.forName(this.getClass().getName()); // 클래스명 기준으로
			Method method = this.getClass().getDeclaredMethod(methodName // 메소드명
					, HttpServletRequest.class // 파라미터1
					, HttpServletResponse.class // 파라미터2
			);
			method.invoke(this, request, response); // 메소드 실행.
		} catch (Exception e) {
			e.printStackTrace();
		}

	} // end of execute.

	public void main(HttpServletRequest request, HttpServletResponse response) {
		HttpUtil.forward(request, response, "main/main.tiles");
	}

	public void cart(HttpServletRequest request, HttpServletResponse response) {
		HttpUtil.forward(request, response, "cart/cart.jsp");
	}

	public void spec(HttpServletRequest request, HttpServletResponse response) {
		HttpUtil.forward(request, response, "WEB-INF/spec.jsp");
	}

	public void table(HttpServletRequest request, HttpServletResponse response) {
		HttpUtil.forward(request, response, "main/table.tiles");
	}
}
