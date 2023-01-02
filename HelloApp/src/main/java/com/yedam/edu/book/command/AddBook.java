package com.yedam.edu.book.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.edu.book.service.BookService;
import com.yedam.edu.book.service.impl.BookServiceImpl;
import com.yedam.edu.book.vo.BookVO;
import com.yedam.edu.common.Command;

public class AddBook implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String code = request.getParameter("code");
		String author = request.getParameter("author");
		String title = request.getParameter("title");
		String press = request.getParameter("press");
		String price = request.getParameter("price");
		price = price.replace(",", "");

		BookVO vo = new BookVO();
		vo.setBookAuthor(author);
		vo.setBookCode(code);
		vo.setBookPress(press);
		vo.setBookPrice(Integer.parseInt(price));
		vo.setBookTitle(title);

		BookService service = new BookServiceImpl();
		service.addBook(vo);

		return "bookList.do";
	}

}
