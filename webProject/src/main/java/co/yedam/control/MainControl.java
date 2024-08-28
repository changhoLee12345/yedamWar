package co.yedam.control;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control2;

public class MainControl implements Control2 {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp, String path)
			throws ServletException, IOException {
		System.out.println("String path>> " + path); // "/main.do"

		String methodName = path.substring(1, path.length() - 3);

		try {
			Class<?> cls = Class.forName(this.getClass().getName());
			// 실행할 메소드 정의.
			Method method = cls.getDeclaredMethod(methodName // 메소드명.
					, HttpServletRequest.class // 파라미터1.
					, HttpServletResponse.class // 파라미터2.
			// ,String.class// 파라미터3.
			);
			method.invoke(this, req, resp); // 메소드 실행.

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// servletPath에서 메소드명을 추출.
	public void main(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("main/main.tiles").forward(req, resp);
	}

}
