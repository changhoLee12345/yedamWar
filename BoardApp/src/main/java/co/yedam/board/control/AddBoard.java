package co.yedam.board.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.service.BoardService;
import co.yedam.board.service.BoardServiceImpl;
import co.yedam.board.vo.Board;
import co.yedam.common.Control;

public class AddBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");

		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String content = req.getParameter("content");

		Board board = new Board();
		board.setWriter(writer);
		board.setContent(content);
		board.setTitle(title);

		BoardService svc = new BoardServiceImpl();
		if (svc.addBoard(board)) {
			resp.sendRedirect("boardList.do");
		} else {
			req.setAttribute("message", "등록 중 에러가 발생했습니다.");
			String path = "WEB-INF/view/error.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
		}

	}

}
