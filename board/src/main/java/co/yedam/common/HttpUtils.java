package co.yedam.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpUtils {
	public static void forward(HttpServletRequest req, HttpServletResponse resp, String path) {
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
