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
import com.yedam.edu.member.vo.MemberVO;

public class MemberJoin implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		// id, passwd, name, email, responsibility, pfilename, ofilename, cdate
		String id = request.getParameter("id");
		String pw = request.getParameter("passwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String responsibility = request.getParameter("responsibility");
//		String pw = request.getParameter("passwd");

		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPasswd(pw);
		vo.setEmail(email);
		vo.setName(name);
		vo.setResponsibility(responsibility);

		MemberService service = new MemberServiceMybatis();
		int rtn = service.insertMember(vo);

		Map<String, Object> resultMap = new HashMap<>();
		if (rtn > 0) {
			vo = service.searchMember(vo.getId());
			resultMap.put("retCode", "Success");
			resultMap.put("result", vo);

		} else {
			resultMap.put("retCode", "Fail");

		}
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		try {
			json = mapper.writeValueAsString(resultMap);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "ajax:" + json;
	}

}
