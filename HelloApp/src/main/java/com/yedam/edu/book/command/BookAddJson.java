package com.yedam.edu.book.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yedam.edu.book.service.BookService;
import com.yedam.edu.book.service.impl.BookServiceImpl;
import com.yedam.edu.book.vo.BookVO;
import com.yedam.edu.common.Command;

public class BookAddJson implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String bcode = request.getParameter("bookCode");
		String btitle = request.getParameter("bookTitle");
		String bauthor = request.getParameter("bookAuthor");
		String bpress = request.getParameter("bookPress");
		String bprice = request.getParameter("bookPrice");

		BookVO vo = new BookVO();
		vo.setBookAuthor(bauthor);
		vo.setBookCode(bcode);
		vo.setBookPress(bpress);
		vo.setBookPrice(Integer.parseInt(bprice));
		vo.setBookTitle(btitle);

		BookService service = new BookServiceImpl();
		int cnt = service.insertBook(vo);

		Map<String, String> result = new HashMap<>();
		String json = "";
		ObjectMapper mapper = new ObjectMapper();
		if (cnt > 0)
			result.put("retCode", "Success");
		else
			result.put("retCode", "Fail");
		try {
			json = mapper.writeValueAsString(result);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "ajax:" + json;
	}

}
