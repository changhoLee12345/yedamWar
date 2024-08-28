package co.yedam.control;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.yedam.common.Control2;
import co.yedam.common.HttpUtils;
import co.yedam.common.PageDTO;
import co.yedam.common.SearchVO;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

/*
 * url pattern과 메소드의 이름을 같아지도록 매핑해야함.
 */
public class BoardMainControl implements Control2 {

	BoardService svc = new BoardServiceImpl();

	String modulePath = "board";
	String tiles = ".tiles";

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp, String path)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = req.getRequestURI();
		String context = req.getContextPath();
		String url = uri.substring(context.length());

		String methodName = url.substring(1, url.length() - 3);

		try {
			Class<?> cls = Class.forName(this.getClass().getName());
			// 실행할 메소드 정의.
			Method method = cls.getDeclaredMethod(methodName, //
					HttpServletRequest.class, //
					HttpServletResponse.class, //
					String.class);
			method.invoke(this, req, resp, modulePath + url.replaceAll(".do", tiles));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

//	public void urlMethod(HttpServletRequest req, HttpServletResponse resp, String path) throws ServletException, IOException { }

	// 삭제처리.
	public void removeBoard(HttpServletRequest req, HttpServletResponse resp, String path)
			throws ServletException, IOException {

		String bno = req.getParameter("bno");

		if (svc.removeBoard(Integer.parseInt(bno))) {
			resp.sendRedirect("boardList.do");

		} else {
			req.setAttribute("msg", "등록중 에러가 발생.");
			req.getRequestDispatcher("WEB-INF/view/error.jsp").forward(req, resp);

		}
	}

	// 삭제화면.
	public void removeForm(HttpServletRequest req, HttpServletResponse resp, String path)
			throws ServletException, IOException {

		String bno = req.getParameter("bno");
		req.setAttribute("bno", bno);

		HttpUtils.forward(req, resp, path);
	}

	// 수정처리.
	public void modifyBoard(HttpServletRequest req, HttpServletResponse resp, String path)
			throws ServletException, IOException {

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

	// 수정화면.
	public void modifyForm(HttpServletRequest req, HttpServletResponse resp, String path)
			throws ServletException, IOException {
		String bno = req.getParameter("bno");
		// 추가파리미터.
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");

		BoardService svc = new BoardServiceImpl();
		BoardVO bvo = svc.getBoard(Integer.parseInt(bno));

		req.setAttribute("bvo", bvo);
		req.setAttribute("page", page);
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);

		HttpUtils.forward(req, resp, path);
	}

	// 글등록 페이지.
	public void addBoardForm(HttpServletRequest req, HttpServletResponse resp, String path)
			throws ServletException, IOException {

		HttpUtils.forward(req, resp, path);
	}

	// 글등록 기능.
	public void addBoard(HttpServletRequest req, HttpServletResponse resp, String path)
			throws ServletException, IOException {
		// 생성자 매개값 1.요청정보, 2.저장경로 3.최대크기, 4.인코딩 5.리네임정책.
		String savePath = req.getServletContext().getRealPath("upload");
		int maxSize = 1024 * 1024 * 5;
		MultipartRequest multi = //
				new MultipartRequest(req, savePath, maxSize, "utf-8", new DefaultFileRenamePolicy());

		// title, content, writer 3개 파라미터.
		String tit = multi.getParameter("title");
		String con = multi.getParameter("content");
		String wri = multi.getParameter("writer");
		String img = multi.getFilesystemName("myImg");

		BoardVO vo = new BoardVO();
		vo.setTitle(tit);
		vo.setContent(con);
		vo.setWriter(wri);
		vo.setImg(img);

		BoardService svc = new BoardServiceImpl();
		if (svc.addBoard(vo)) {
			resp.sendRedirect("boardList.do");

		} else {
			req.setAttribute("msg", "등록중 에러가 발생.");
			req.getRequestDispatcher("WEB-INF/view/error.jsp").forward(req, resp);

		}
	}

	// 상세페이지.
	public void getboard(HttpServletRequest req, HttpServletResponse resp, String path)
			throws ServletException, IOException {
		System.out.println(path);

		String bno = req.getParameter("bno");
		// 추가파리미터.
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");

		// db조회 -> 페이지재지정.
		BoardVO vo = svc.getBoard(Integer.parseInt(bno));
		svc.addViewCnt(Integer.parseInt(bno));

		req.setAttribute("bvo", vo);
		req.setAttribute("page", page);
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);

		HttpUtils.forward(req, resp, path);
	}

	// 게시글 목록.
	public void boardList(HttpServletRequest req, HttpServletResponse resp, String path)
			throws ServletException, IOException {
		// board/boardList.tiles
		System.out.println(path);

		// db정보 조회 후 -> boardList.jsp 출력.
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		String page = req.getParameter("page");
		page = page == null ? "1" : page; // page파라미터 없으면 기본값: 1.

		SearchVO search = new SearchVO();
		search.setSearchCondition(sc);
		search.setKeyword(kw);
		search.setPage(Integer.parseInt(page));

		List<BoardVO> list = svc.boardList(search); // 5건씩 조회.

		// 페이징 계산.
		PageDTO dto = new PageDTO(Integer.parseInt(page), svc.getCount(search));

		req.setAttribute("blist", list);
		req.setAttribute("paging", dto);
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);

		HttpUtils.forward(req, resp, path);

	}

}
