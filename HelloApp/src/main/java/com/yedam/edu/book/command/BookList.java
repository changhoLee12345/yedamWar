package com.yedam.edu.book.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.edu.book.service.BookService;
import com.yedam.edu.book.service.impl.BookServiceImpl;
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

		BookService service = new BookServiceImpl();
		service.selectBooks(null);

		return "book/bookList.tiles";
	}

}
