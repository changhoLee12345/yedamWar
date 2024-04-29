package co.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

public class ModifyBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// boardNo, title, content
		String bno = req.getParameter("boardNo");
		String tit = req.getParameter("title");
		String con = req.getParameter("content");

		// 추가파리미터.
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");

		BoardVO vo = new BoardVO();
		vo.setBoardNo(Integer.parseInt(bno));
		vo.setTitle(tit);
		vo.setContent(con);

		BoardService svc = new BoardServiceImpl();
		if (svc.modifyBoard(vo)) {
			resp.sendRedirect("boardList.do?page=" + page + "&searchCondition=" + sc + "&keyword=" + kw);

		} else {
			req.setAttribute("msg", "등록중 에러가 발생.");
			req.getRequestDispatcher("WEB-INF/view/error.jsp").forward(req, resp);

		}

	}

}
