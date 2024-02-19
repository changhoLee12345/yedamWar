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
import co.yedam.vo.PageDTO;
import co.yedam.vo.SearchVO;

public class BoardListControl implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String page = request.getParameter("page");
		page = page == null ? "1" : page;
		String searchCondition = request.getParameter("searchCondition");
		String keyword = request.getParameter("keyword");

		SearchVO search = new SearchVO();
		search.setPage(Integer.parseInt(page));
		search.setType(searchCondition);
		search.setKeyword(keyword);

		BoardService svc = new BoardServiceImpl();
		List<Board> list = svc.boardList(search);

		// totalCnt=>
		int totalCnt = svc.totalCnt(search);
		PageDTO paging = new PageDTO(Integer.parseInt(page), totalCnt);

		request.setAttribute("boardList", list);
		request.setAttribute("paging", paging);
		request.setAttribute("type", searchCondition);
		request.setAttribute("keyword", keyword);

		String path = "WEB-INF/view/boardList.jsp";
		Https.forward(path, request, response);

	}

}
