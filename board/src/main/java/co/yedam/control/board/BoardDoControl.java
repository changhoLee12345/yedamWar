package co.yedam.control.board;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;

public class BoardDoControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "boardForm.do";
		String methodName = url.substring(0, url.length() - 3);

		Object obj = new BoardDoControl();
		try {
			Class<?> cls = Class.forName(obj.getClass().getName());
			Method method = cls.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(obj, req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void boardList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("boardList");
		req.getRequestDispatcher("WEB-INF/view/boardList.jsp").forward(req, resp);
	}

	public void boardForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("boardForm");
		req.getRequestDispatcher("WEB-INF/view/boardForm.jsp").forward(req, resp);
	}

}
