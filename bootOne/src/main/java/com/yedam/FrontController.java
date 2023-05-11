package com.yedam;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Command;
import com.yedam.web.GitControl;
import com.yedam.web.MainCommand;

/**
 * 모든요청을 받아들이는 컨트롤러 @WebServlet("*.do")
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();
	private String enc;

	public FrontController() {
		super();
	}

	// 요청한 것을 실행하는 명령을 모아 두는 곳
	public void init(ServletConfig config) throws ServletException {

		enc = config.getInitParameter("charset");

		map.put("/main.do", new MainCommand()); // 처음 보여줄 페이지 명령

	}

	// 요청을 분석하고 실행, 결과를 돌려주는 곳
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding(enc); // 한글깨짐방지

		String uri = request.getRequestURI(); // 요청한 uri를 구함
		String contextPath = request.getContextPath(); // 루트를 구함,context path
		String page = uri.substring(contextPath.length()); // 실제 수행할 요청을 구함
		System.out.println("====> " + page);

		String viewPage = "main.do";
		RequestDispatcher dispatcher = null;

		Command command = map.get(page); // init 메소드에서 수행할 명령을 가져온다.

		if (command != null) {
			viewPage = command.exec(request, response); // 명령을 수행하고 결과를 돌려받음

			// viewResolve 파트
			if (viewPage != null && !viewPage.endsWith(".do")) {

				if (viewPage.startsWith("ajax:")) {
					// ajax 처리
					response.setContentType("text/html; charset=UTF-8");
					response.getWriter().append(viewPage.substring(5));
					return;

				} else if (viewPage.endsWith(".jsp")) {
					// jsp 처리.
					viewPage = "/WEB-INF/views/" + viewPage; // 타일즈를 안태움
				}

				// tiles처리하는 곳.
				dispatcher = request.getRequestDispatcher(viewPage);
				dispatcher.forward(request, response);
				return;
			}
		}

		response.sendRedirect(viewPage); // *.do 로 들어올때 돌아가는 곳

	}
}
