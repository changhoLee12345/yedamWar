package co.yedam.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control2;
import co.yedam.control.MainControl;
import co.yedam.control.MenuBoard;
import co.yedam.control.MenuMember;
import co.yedam.control.MenuReply;

// init -> service -> destroy
/*
 * FrontController의 기존 방식으로 작성한 서블릿의
 * 깃을 사용할 경우 충돌되는 문제로 인해 FrontControlMap으로 변경함.
 */
public class FrontControlMap extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// url pattern - 실행서블릿. 관리.
	Map<String, Control2> map;

	public FrontControlMap() {
		map = new HashMap<>();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {

		// url patter과 실행하는 컨트롤의 메소드와 매칭하기.
		map.put("/main.do", new MainControl()); // example...

		Map<String, Control2> map1 = MenuBoard.getInstance().menuMap();
		Map<String, Control2> map2 = MenuMember.getInstance().menuMap();
		Map<String, Control2> map3 = MenuReply.getInstance().menuMap();

		map.putAll(map1);
		map.putAll(map2);
		map.putAll(map3);

	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		String uri = req.getRequestURI();
		String context = req.getContextPath();
		String servletPath = uri.substring(context.length());
		System.out.println(servletPath);

		Control2 control = map.get(servletPath);
		control.exec(req, resp, servletPath);
	}
}
