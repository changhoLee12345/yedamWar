package com.yedam.edu;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.edu.book.command.AddBook;
import com.yedam.edu.book.command.AddBookForm;
import com.yedam.edu.book.command.BookAddJson;
import com.yedam.edu.book.command.BookDelJson;
import com.yedam.edu.book.command.BookList;
import com.yedam.edu.book.command.BookListJson;
import com.yedam.edu.book.command.BookListVueForm;
import com.yedam.edu.book.command.ModifyBook;
import com.yedam.edu.book.command.BookUpload;
import com.yedam.edu.book.command.SearchBook;
import com.yedam.edu.book.command.SearchBookForm;
import com.yedam.edu.common.Command;
import com.yedam.edu.main.command.AdminMain;
import com.yedam.edu.main.command.CreateCenterInfo;
import com.yedam.edu.main.command.MainCommand;
import com.yedam.edu.member.command.ImageUpload;
import com.yedam.edu.member.command.JquerySample;
import com.yedam.edu.member.command.MemberDelAjax;
import com.yedam.edu.member.command.MemberForm;
import com.yedam.edu.member.command.MemberJoin;
import com.yedam.edu.member.command.MemberJoinAjax;
import com.yedam.edu.member.command.MemberJoinForm;
import com.yedam.edu.member.command.MemberList;
import com.yedam.edu.member.command.MemberListAjax;
import com.yedam.edu.member.command.MemberListJquery;
import com.yedam.edu.member.command.MemberLogin;
import com.yedam.edu.member.command.MemberLoginForm;
import com.yedam.edu.member.command.MemberLogout;
import com.yedam.edu.member.command.MemberMain;
import com.yedam.edu.notice.command.DeleteNotice;
import com.yedam.edu.notice.command.DeleteNoticeJson;
import com.yedam.edu.notice.command.NoticeList;
import com.yedam.edu.notice.command.NoticeListJson;
import com.yedam.edu.notice.command.NoticeListJsonForm;
import com.yedam.edu.notice.command.NoticeSearch;
import com.yedam.edu.notice.command.UpdateNotice;

/**
 * 모든요청을 받아들이는 컨트롤러
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();

	public FrontController() {
		super();
	}

	// 요청한 것을 실행하는 명령을 모아 두는 곳
	public void init(ServletConfig config) throws ServletException {

		config.getInitParameter("");

		map.put("/main.do", new MainCommand()); // 처음 보여줄 페이지 명령

		// 도서정보관련.
		map.put("/bookList.do", new BookList()); // 책목록보기
		map.put("/searchBookForm.do", new SearchBookForm()); // 책 검색.
		map.put("/searchBook.do", new SearchBook()); // 책 조회 결과 페이지. 1.조회, 2.수정 페이지로 이동.
		map.put("/addBookForm.do", new AddBookForm());
		map.put("/addBook.do", new AddBook());
		map.put("/bookUpload.do", new BookUpload());
		map.put("/modifyBook.do", new ModifyBook());
		// json
		map.put("/bookListVueForm.do", new BookListVueForm());
		map.put("/bookListJson.do", new BookListJson());
		map.put("/deleteBookJson.do", new BookDelJson());
		map.put("/addBookJson.do", new BookAddJson());

		// 공지사항관련.
		map.put("/noticeList.do", new NoticeList()); // 공지사항목록.
		map.put("/noticeListJsonForm.do", new NoticeListJsonForm()); // 공지사항등록폼(json)
		map.put("/noticeListJson.do", new NoticeListJson());
		map.put("/deleteNoticeJson.do", new DeleteNoticeJson());
		map.put("/getNotice.do", new NoticeSearch());
		map.put("/updateNotice.do", new UpdateNotice());
		map.put("/deleteNotice.do", new DeleteNotice());

		// 회원관련.
		map.put("/memberLoginForm.do", new MemberLoginForm()); // 로그인 폼 호출
		map.put("/memberLogin.do", new MemberLogin()); // 멤버로그인처리
		map.put("/memberLogout.do", new MemberLogout()); // 멤버로그인처리
		map.put("/memberJoinForm.do", new MemberJoinForm()); // 회원가입 폼 호출
		map.put("/memberJoin.do", new MemberJoin()); // 회원가입
		map.put("/memberList.do", new MemberList()); // 멤버목록보기
		map.put("/memberForm.do", new MemberForm()); // 멤버목록보기
		map.put("/imageUpload.do", new ImageUpload());

		map.put("/memberMain.do", new MemberMain());

		map.put("/memberListAjax.do", new MemberListAjax());
		map.put("/memberJoinAjax.do", new MemberJoinAjax()); // 회원가입
		map.put("/memberDelAjax.do", new MemberDelAjax());
		map.put("/memberListJquery.do", new MemberListJquery());

		// 기타 (스트림 연습).
		map.put("/createCenterInfo.do", new CreateCenterInfo()); // json 포맷을 활용하도록.

		// 기타 (스타일연습).
		// admin.
		map.put("/jquerySample.do", new JquerySample());
		map.put("/admin.do", new AdminMain());

//		// ajax를 사용해보기 위해 만든 컨트롤. 2022.11.23
//		map.put("/ajaxPage.do", new AjaxJquery()); // ajax페이지.
//		map.put("/ajaxBookList.do", new AjaxBookList()); // ajax목록
//		map.put("/ajaxBookAdd.do", new AjaxBookAdd()); // ajax입력
//		map.put("/ajaxBookMod.do", new AjaxBookModify()); // ajax수정
//		map.put("/ajaxBookDel.do", new AjaxBookRemove()); // ajax삭제

	}

	// 요청을 분석하고 실행, 결과를 돌려주는 곳
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8"); // 한글깨짐방지
		String uri = request.getRequestURI(); // 요청한 uri를 구함
		String contextPath = request.getContextPath(); // 루트를 구함,context path
		String page = uri.substring(contextPath.length()); // 실제 수행할 요청을 구함
		System.out.println("====> " + page);

		String viewPage = "main.do";
		RequestDispatcher dispatcher = null;

		Command command = map.get(page); // init 메소드에서 수행할 명령을 가져온다.

		if (command != null) {
			viewPage = command.exec(request, response); // 명령을 수행하고 결과를 돌려받음

			// viewResolve 파트
			if (viewPage != null && !viewPage.endsWith(".do")) {

				if (viewPage.startsWith("ajax:")) {
					// ajax 처리
					response.setContentType("text/html; charset=UTF-8");
					response.getWriter().append(viewPage.substring(5));
					return;

				} else if (viewPage.endsWith(".jsp")) {
					// jsp 처리.
					viewPage = "/WEB-INF/views/" + viewPage; // 타일즈를 안태움
				}

				// tiles처리하는 곳.
				dispatcher = request.getRequestDispatcher(viewPage);
				dispatcher.forward(request, response);
				return;
			}
		}

		response.sendRedirect(viewPage); // *.do 로 들어올때 돌아가는 곳

	}
}
