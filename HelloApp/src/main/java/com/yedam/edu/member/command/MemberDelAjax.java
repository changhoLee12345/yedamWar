package com.yedam.edu.member.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yedam.edu.common.Command;
import com.yedam.edu.member.service.MemberService;
import com.yedam.edu.member.service.impl.MemberServiceMybatis;

public class MemberDelAjax implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		MemberService service = new MemberServiceMybatis();
		int rtn = service.deleteMember(id);

		Map<String, Object> result = new HashMap<>();
		if (rtn > 0) {
			result.put("retCode", "Success");
			result.put("data", id);
		} else {
			result.put("retCode", "Fail");
			result.put("data", "처리중 에러발생");
		}
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		try {
			json = mapper.writeValueAsString(result);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "ajax:" + json;
	}

}
