package com.dev.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.dev.service.MemberService;
import com.dev.vo.MemberVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class MemberJsonController implements Controller {

	@SuppressWarnings("unchecked")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		response.setContentType("text/html;charset=UTF-8");

		MemberService service = MemberService.getInstance();
		List<MemberVO> list = service.memberList();

		JSONArray ary = new JSONArray();
		for (MemberVO vo : list) {
			JSONObject obj = new JSONObject();
			obj.put("id", vo.getId());
			obj.put("name", vo.getName());
			obj.put("ps", vo.getPasswd());
			obj.put("mail", vo.getMail());

			ary.add(obj);

		}

		Gson gson = new GsonBuilder().create();
		JsonObject jobj = new JsonObject();
		JsonArray jary = new JsonArray();
		jobj.addProperty("name", "hong");
		jary.add(jobj);
		try {
			response.getWriter().print(gson.toJson(list));
			response.getWriter().print(jary);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		try {
//			PrintWriter out = response.getWriter();
//			out.print(ary);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		HttpUtil.json(request, response, ary);
	}

}
