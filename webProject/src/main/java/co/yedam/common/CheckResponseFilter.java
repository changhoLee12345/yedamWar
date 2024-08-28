package co.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/*
 * CheckResponseFilter 에 로그인해야하는 경로를 등록한다.
 * 해당 경로와 로그인 여부를 기준으로 이동할 경로를 지정.
 */

public class CheckResponseFilter implements Filter {
	Map<String, String> auths;

	public CheckResponseFilter() {
		auths = new HashMap<>();
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 경로, 권한을 얻어야하는 경로.
		auths.put("/addForm.do", "/loginForm.do");
		auths.put("/memberForm.do", "/loginForm.do");
		auths.put("/memberAjax.do", "/loginForm.do");
		auths.put("/removeMember.do", "/loginForm.do");
		auths.put("/addMemberAjax.do", "/loginForm.do");

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpReq = (HttpServletRequest) req;
		String movePath = checkResponse(httpReq);
		System.out.println("movePath: " + movePath);
		req.setAttribute("movePath", movePath);

		chain.doFilter(req, resp);

//		String check = (String) req.getAttribute("movePath");
//		System.out.println("check: " + check);
//		if (check != null) {
//			resp.sendRedirect(req.getContextPath() + check);
//			return;
//		}

	}

	private String checkResponse(HttpServletRequest req) {
		String uri = req.getRequestURI();
		String context = req.getContextPath();
		String path = uri.substring(context.length());

		if (auths.keySet().contains(path)) {
			return auths.get(path);
		}
		return null;
	}

}
