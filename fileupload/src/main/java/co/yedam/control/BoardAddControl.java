package co.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.common.Https;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.Board;

public class BoardAddControl implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 사용자의 작성정보: 제목, 내용, 작성자(로그인 정보활용)
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");

		Board board = new Board();
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);

		BoardService svc = new BoardServiceImpl();
		if (svc.addBoard(board)) {
			response.sendRedirect("boardList.do");
		} else {
			String path = "WEB-INF/view/error.jsp";
			request.setAttribute("error", "error occurred....");
			Https.forward(path, request, response);
		}

	}

}
