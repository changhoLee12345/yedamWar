package com.edu.test.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FlowFilterTwo implements Filter {

	String charset;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		charset = filterConfig.getInitParameter("encoding");
		System.out.println("filter two init() 호출 ...... two");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
//		req.setCharacterEncoding("UTF-8"); // <filter>에서 <init-param>으로 설정하는 것이 좋음.
		req.setCharacterEncoding(charset);
		System.out.println("filter two doFilter() 호출 전 ...... two");
		chain.doFilter(req, resp);
		System.out.println("filter two doFilter() 호출 후 ...... two");

	}

	@Override
	public void destroy() {
		System.out.println("filter two destroy() 호출 ...... two");
	}
}
