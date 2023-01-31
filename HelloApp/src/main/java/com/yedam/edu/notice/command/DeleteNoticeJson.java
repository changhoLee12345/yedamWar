package com.yedam.edu.notice.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yedam.edu.common.Command;
import com.yedam.edu.notice.service.NoticeService;
import com.yedam.edu.notice.service.impl.NoticeServiceImpl;

public class DeleteNoticeJson implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		NoticeService service = new NoticeServiceImpl();
		int cnt = service.deleteNotice(Integer.parseInt(id));

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);

		String json = "";
		ObjectMapper mapper = new ObjectMapper();
		if (cnt > 0) {
			map.put("retCode", "Success");
		} else {
			map.put("retCode", "Fail");
		}

		try {
			json = mapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "ajax:" + json;
	}

}
