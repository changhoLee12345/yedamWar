package com.yedam.edu.book.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yedam.edu.book.service.BookService;
import com.yedam.edu.book.service.impl.BookServiceImpl;
import com.yedam.edu.common.Command;

public class BookDelJson implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String bcode = request.getParameter("bcode");
		System.out.println("bcode" + bcode);
		BookService service = new BookServiceImpl();
		int delCnt = service.deleteBook(bcode);

		String json = "";
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> result = new HashMap<>();

		if (delCnt > 0) {
			result.put("retCode", "Success");
		} else {
			result.put("retCode", "Fail");
		}
		try {
			json = mapper.writeValueAsString(result);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "ajax:" + json;
	}

}
