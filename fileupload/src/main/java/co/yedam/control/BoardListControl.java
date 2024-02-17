package co.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.common.Https;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.Board;
import co.yedam.vo.SearchVO;

public class BoardListControl implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String page = request.getParameter("page");
		page = page == null ? "1" : page;

		SearchVO search = new SearchVO();
		search.setPage(Integer.parseInt(page));

		BoardService svc = new BoardServiceImpl();
		List<Board> list = svc.boardList(search);
		
		request.setAttribute("boardList", list);

		String path = "WEB-INF/view/boardList.jsp";
		Https.forward(path, request, response);

	}

}
