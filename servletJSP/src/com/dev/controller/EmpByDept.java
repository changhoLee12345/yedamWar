package com.dev.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.dao.MemberDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class EmpByDept implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		MemberDAO dao = MemberDAO.getInstance();
		Map<String, Integer> map = dao.empList();

		Gson gson = new GsonBuilder().create();

		try {
			response.getWriter().print(gson.toJson(map));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
