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

public class CheckResponseFilter implements Filter {
	List<String> auths;

	public CheckResponseFilter() {
		auths = new ArrayList<>();
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("intit");
		auths.add("/addForm.do");

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub

		HttpServletRequest hsr = (HttpServletRequest) req;
		if (checkResponse(hsr))
			req.setAttribute("msg", "login");
		else
			req.setAttribute("msg", "shared");

		chain.doFilter(req, resp);

	}

	private boolean checkResponse(HttpServletRequest req) {
		String uri = req.getRequestURI();
		String context = req.getContextPath();
		String path = uri.substring(context.length());

		if (auths.contains(path)) {
			return true;
		} else {
			return false;
		}
	}

}
