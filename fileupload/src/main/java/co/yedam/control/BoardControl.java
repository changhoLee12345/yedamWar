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
import co.yedam.vo.SearchVO;

public class BoardControl implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 단건조회의 정보를 위한 파라미터.
		String bno = request.getParameter("bno");

		// 목록으로 이동하기 위한 파리미터.
		String type = request.getParameter("searchCondition");
		String keyword = request.getParameter("keyword");
		String page = request.getParameter("page");

		SearchVO search = new SearchVO();
		search.setBno(Integer.parseInt(bno));
		search.setType(type);
		search.setKeyword(keyword);
		search.setPage(Integer.parseInt(page));

		BoardService svc = new BoardServiceImpl();
		Board board = svc.getBoard(search);

		request.setAttribute("board", board);
		request.setAttribute("search", search);

		String path = "WEB-INF/view/board.jsp";
		Https.forward(path, request, response);

	}

}
