package com.yedam.edu.common;

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
import com.yedam.edu.book.command.BookListVue;
import com.yedam.edu.book.command.BookUpload;
import com.yedam.edu.book.command.SearchBook;
import com.yedam.edu.book.command.SearchBookForm;
import com.yedam.edu.main.CreateCenterInfo;
import com.yedam.edu.main.MainCommand;
import com.yedam.edu.member.command.JquerySample;
import com.yedam.edu.member.command.MemberForm;
import com.yedam.edu.member.command.MemberJoin;
import com.yedam.edu.member.command.MemberJoinForm;
import com.yedam.edu.member.command.MemberList;
import com.yedam.edu.member.command.MemberListAjax;
import com.yedam.edu.member.command.MemberLogin;
import com.yedam.edu.member.command.MemberLoginForm;
import com.yedam.edu.member.command.MemberLogout;
import com.yedam.edu.notice.command.DeleteNotice;
import com.yedam.edu.notice.command.NoticeList;
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
		map.put("/main.do", new MainCommand()); // 처음 보여줄 페이지 명령

		map.put("/bookList.do", new BookList()); // 책목록보기
		map.put("/searchBookForm.do", new SearchBookForm());
		map.put("/searchBook.do", new SearchBook());
		map.put("/addBookForm.do", new AddBookForm());
		map.put("/addBook.do", new AddBook());
		map.put("/bookUpload.do", new BookUpload());
		// json
		map.put("/bookListVue.do", new BookListVue());
		map.put("/bookListJson.do", new BookListJson());
		map.put("/deleteBookJson.do", new BookDelJson());
		map.put("/addBookJson.do", new BookAddJson());

		map.put("/noticeList.do", new NoticeList());
		map.put("/getNotice.do", new NoticeSearch());
		map.put("/updateNotice.do", new UpdateNotice());
		map.put("/deleteNotice.do", new DeleteNotice());

		map.put("/memberLoginForm.do", new MemberLoginForm()); // 로그인 폼 호출
		map.put("/memberLogin.do", new MemberLogin()); // 멤버로그인처리
		map.put("/memberLogout.do", new MemberLogout()); // 멤버로그인처리
		map.put("/memberJoinForm.do", new MemberJoinForm()); // 회원가입 폼 호출
		map.put("/memberJoin.do", new MemberJoin()); // 회원가입
		map.put("/memberList.do", new MemberList()); // 멤버목록보기
		map.put("/memberForm.do", new MemberForm()); // 멤버목록보기
		
		map.put("/memberListAjax.do", new MemberListAjax());

		map.put("/createCenterInfo.do", new CreateCenterInfo());
		
		// admin.
		map.put("/jquerySample.do", new JquerySample());

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

		Command command = map.get(page); // init 메소드에서 수행할 명령을 가져온다.
		String viewPage = command.exec(request, response); // 명령을 수행하고 결과를 돌려받음

		// viewResolve 파트
		if (viewPage != null && !viewPage.endsWith(".do")) {
			// ajax 처리
			if (viewPage.startsWith("ajax:")) {
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().append(viewPage.substring(5));
				return;
			}

			// 타일즈 돌아가는곳
			if (!viewPage.endsWith(".tiles")) {
				viewPage = "/WEB-INF/views/" + viewPage + ".jsp"; // 타일즈를 안태움
			}

			// tiles처리하는 곳.
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);

		} else {
			response.sendRedirect(viewPage); // *.do 로 들어올때 돌아가는 곳

		}
	}
}
