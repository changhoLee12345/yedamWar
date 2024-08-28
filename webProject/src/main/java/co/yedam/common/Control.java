package co.yedam.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Control {
	String PREFIX = "WEB-INF/view";
	String SUFFIX = ".jsp";

	public void exec(HttpServletRequest req, HttpServletResponse resp)//
			throws ServletException, IOException;

//	public void exec(HttpServletRequest req, HttpServletResponse resp, String path)
//			throws ServletException, IOException;
}
