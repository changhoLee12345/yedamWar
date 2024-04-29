package co.yedam.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResumeControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// resume.html
		// resume.do -> 페이지 재지정.
		req.getRequestDispatcher("WEB-INF/info/resume.html")//
				.forward(req, resp);

	}

}
