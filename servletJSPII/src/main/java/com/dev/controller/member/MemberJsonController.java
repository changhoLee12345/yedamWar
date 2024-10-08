package com.dev.controller.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.dev.common.Controller;
import com.dev.common.HttpUtil;
import com.dev.service.MemberServiceImpl;
import com.dev.vo.MemberVO;

public class MemberJsonController implements Controller {

	@SuppressWarnings("unchecked")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		response.setContentType("text/html;charset=UTF-8");

		MemberServiceImpl service = MemberServiceImpl.getInstance();
		List<MemberVO> list = service.memberList();

		JSONArray ary = new JSONArray();
		for (MemberVO vo : list) {
			JSONObject obj = new JSONObject();
			obj.put("id", vo.getId());
			obj.put("name", vo.getName());
			obj.put("ps", vo.getPasswd());
			obj.put("mail", vo.getEmail());

			ary.add(obj);

		}

		HttpUtil.json(request, response, ary);
	}

}
