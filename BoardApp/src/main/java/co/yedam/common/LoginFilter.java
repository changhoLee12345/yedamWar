package co.yedam.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	List<String> excludeUri = new ArrayList<>();

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("loginfilter.init");
		excludeUri.add("/loginForm.do");
		excludeUri.add("/login.do");
		excludeUri.add("/logout.do");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		String uri = request.getRequestURI(); // 현재 페이지의 url.
		String context = request.getContextPath(); // 어플리케이션
		String path = uri.substring(context.length());

		HttpSession session = request.getSession();
		if (session.getAttribute("logid") == null && !excludeUri.contains(path)) {
			HttpServletResponse response = (HttpServletResponse) resp;
			response.sendRedirect("loginForm.do");
			return;
		}
		chain.doFilter(req, resp);

	}

}
