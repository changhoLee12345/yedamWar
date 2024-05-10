package co.yedam.control.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.common.PageDTO;
import co.yedam.common.SearchVO;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

public class BoardListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// db정보 조회 후 -> boardList.jsp 출력.
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		String page = req.getParameter("page");
		page = page == null ? "1" : page; // page파라미터 없으면 기본값: 1.

		SearchVO search = new SearchVO();
		search.setSearchCondition(sc);
		search.setKeyword(kw);
		search.setPage(Integer.parseInt(page));

		BoardService svc = new BoardServiceImpl();
		List<BoardVO> list = svc.boardList(search); // 5건씩 조회.

		// 페이징 계산.
		PageDTO dto = //
				new PageDTO(Integer.parseInt(page), svc.getCount(search));

		req.setAttribute("blist", list);
		req.setAttribute("paging", dto);
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);

		// 페이지재지정.
		req.getRequestDispatcher("board/boardList.tiles")//
				.forward(req, resp);
	}

}
