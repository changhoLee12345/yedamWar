package com.yedam.edu.notice.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yedam.edu.common.Command;
import com.yedam.edu.notice.service.NoticeService;
import com.yedam.edu.notice.service.impl.NoticeServiceImpl;
import com.yedam.edu.notice.vo.NoticeVO;

public class NoticeListJson implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		NoticeService service = new NoticeServiceImpl();
		List<NoticeVO> list = service.noticeList();

		ObjectMapper mapper = new ObjectMapper();

		String json = "";

		try {
			json = mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return "ajax:" + json;
	}

}
