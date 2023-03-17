package com.yedam.edu.book.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.edu.book.service.BookService;
import com.yedam.edu.book.service.impl.BookServiceImpl;
import com.yedam.edu.book.vo.BookVO;
import com.yedam.edu.common.Command;

public class BookList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
//		String condition = request.getParameter("searchCondition");
//		String key = request.getParameter("searchKey");

		String code = request.getParameter("code");
		String author = request.getParameter("author");
		String title = request.getParameter("title");
		String press = request.getParameter("press");
		String price1 = request.getParameter("price1");
		String price2 = request.getParameter("price2");
		String orderBy = request.getParameter("orderBy");

		BookVO vo = new BookVO();
		vo.setOrderBy(orderBy);

		BookService service = new BookServiceImpl();
		List<BookVO> list = service.selectBooks(vo);
		request.setAttribute("bookList", list);

		return "book/bookList.tiles";
	}

}
