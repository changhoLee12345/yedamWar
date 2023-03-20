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
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String press = request.getParameter("press");
		String price1 = request.getParameter("price1");
		String price2 = request.getParameter("price2");
		System.out.println(price1 + "," + price2);

		String resultPage = "";
		BookService service = new BookServiceImpl();
		BookVO vo = null;

		String from = request.getParameter("from");
		// 수정화면으로 갈지 조회화면으로 갈지 구분하기 위해서.
		if (from != null) {
			vo = service.selectBook(code);
			request.setAttribute("vo", vo);

			if (from.equals("list")) {
				resultPage = "book/searchBook.tiles";
			} else if (from.equals("search")) {
				resultPage = "book/bookDetail.tiles";
			}
			resultPage = "book/searchBook.tiles";

		} else {
			vo = new BookVO();

			if (code != null && !code.equals(""))
				vo.setBookCode(code);
			if (title != null && !title.equals(""))
				vo.setBookTitle(title);
			if (author != null && !author.equals(""))
				vo.setBookAuthor(author);
			if (press != null && !press.equals(""))
				vo.setBookPress(press);
			if (price1 != null && !price1.equals(""))
				vo.setPrice1(Integer.parseInt(price1));
			if (price2 != null && !price2.equals(""))
				vo.setPrice2(Integer.parseInt(price2));
			else
				vo.setPrice2(Integer.MAX_VALUE);

			System.out.println(vo);

			List<BookVO> list = service.selectBooks(vo);
			request.setAttribute("bookList", list);

			resultPage = "book/bookList.tiles";
		}

		return resultPage;
	}

}
