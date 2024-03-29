package com.edu.test.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FlowFilterOne implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("filter one init() 호출 ...... one");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("filter one doFilter() 호출 전 ...... one");
		chain.doFilter(req, resp);
		System.out.println("filter one doFilter() 호출 후 ...... one");

	}

	@Override
	public void destroy() {
		System.out.println("filter one destroy() 호출 ...... one");
	}

}
