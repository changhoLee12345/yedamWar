package co.yedam.common;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Control2 {
	// jsp 실행일 경우..
	String PREFIX = "WEB-INF/view";
	String SUFFIX = ".jsp";

	// tiles 실행일 경우..
	String module = "board";
	String tiles = ".tiles";

	public void exec(HttpServletRequest req, HttpServletResponse resp, String path)
			throws ServletException, IOException;
}
