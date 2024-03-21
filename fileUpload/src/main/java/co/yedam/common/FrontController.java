package co.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.control.FileUploadControl;
import co.yedam.control.FileUploadForm;
import co.yedam.control.MainControl;
import co.yedam.control.board.BoardAddControl;
import co.yedam.control.board.BoardAddForm;
import co.yedam.control.board.BoardControl;
import co.yedam.control.board.BoardEditControl;
import co.yedam.control.board.BoardEditForm;
import co.yedam.control.board.BoardListControl;
import co.yedam.control.emp.EmpListControl;
import co.yedam.control.emp.LoginControl;
import co.yedam.control.emp.LoginForm;
import co.yedam.control.emp.LogoutControl;
import co.yedam.control.reply.ReplyCountControl;
import co.yedam.control.reply.ReplyListControl;

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

		controls.put("/addBoardForm.do", new BoardAddForm());
		controls.put("/addBoard.do", new BoardAddControl());

		controls.put("/editBoardForm.do", new BoardEditForm());
		controls.put("/editBoard.do", new BoardEditControl());

		controls.put("/loginForm.do", new LoginForm());
		controls.put("/login.do", new LoginControl());
		controls.put("/logout.do", new LogoutControl());
		
		// 댓글관련.
		controls.put("/replyList.do", new ReplyListControl());
		controls.put("/replyCount.do", new ReplyCountControl());

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
