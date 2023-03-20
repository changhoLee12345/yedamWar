package com.yedam.edu.book.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.edu.book.service.BookService;
import com.yedam.edu.book.service.impl.BookServiceImpl;
import com.yedam.edu.book.vo.BookVO;
import com.yedam.edu.common.Command;

public class SearchBook implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String code = request.getParameter("code");
		BookService service = new BookServiceImpl();
		BookVO vo = service.selectBook(code);
		request.setAttribute("vo", vo);

		String from = request.getParameter("from");
		// 수정화면으로 갈지 조회화면으로 갈지 구분하기 위해서.
		if (from.equals("list")) {
			return "book/searchBook.tiles";
		} else if (from.equals("search")) {
			return "book/bookDetail.tiles";
		}

		return "book/searchBook.tiles";
	}

}
