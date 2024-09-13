package com.dev.controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.common.Controller;
import com.dev.common.HttpUtil;
import com.dev.service.BoardService;
import com.dev.vo.BoardVO;
import com.dev.vo.ReplyVO;

public class ReplyController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		// 요청uri값에서 /와 .do 제외한 값을 실행할 메소드의 지정.
		String methodName = Controller.getMethodName(request, response);
		try {
//					Class<?> cls =  Class.forName(this.getClass().getName()); // 클래스명 기준으로
			Method method = this.getClass().getDeclaredMethod(methodName // 메소드명
					, HttpServletRequest.class // 파라미터1
					, HttpServletResponse.class // 파라미터2
			);
			method.invoke(this, request, response); // 메소드 실행.
		} catch (Exception e) {
			e.printStackTrace();
		}

	} // end of execute.

}
