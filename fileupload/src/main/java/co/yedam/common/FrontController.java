package co.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.control.BoardControl;
import co.yedam.control.BoardListControl;
import co.yedam.control.EmpListControl;
import co.yedam.control.FileUploadControl;
import co.yedam.control.FileUploadForm;
import co.yedam.control.MainControl;

public class FrontController extends HttpServlet {

	Map<String, Control> controls;

	public FrontController() {
		controls = new HashMap<>();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		controls.put("/main.do", new MainControl());
		controls.put("/empList.do", new EmpListControl());

		controls.put("/fileUploadForm.do", new FileUploadForm());
		controls.put("/fileUpload.do", new FileUploadControl());
		
		controls.put("/boardList.do", new BoardListControl());
		controls.put("/board.do", new BoardControl());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String context = req.getContextPath();
		String path = uri.substring(context.length());
		System.out.println("Path: " + path);

		Control control = controls.get(path);
		control.exec(req, resp);

	}
}
