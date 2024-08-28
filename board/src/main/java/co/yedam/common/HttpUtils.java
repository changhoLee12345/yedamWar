package co.yedam.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpUtils {
	// 일반 forwading일 경우에는 사용.
	public static void forward(HttpServletRequest req, HttpServletResponse resp, String path) {
		try {
			req.getRequestDispatcher(path).forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	// 특정페이지로 이동하도록 지정한 경우에는 사용.
	public static void forwarding(HttpServletRequest req, HttpServletResponse resp, String path) {
		try {
			String movePath = (String) req.getAttribute("movePath");

			if (movePath == null) {
				req.getRequestDispatcher(path).forward(req, resp);
			} else {
				resp.sendRedirect(movePath);
			}

		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
