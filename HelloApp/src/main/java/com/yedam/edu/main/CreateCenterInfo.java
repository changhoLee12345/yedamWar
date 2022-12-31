package com.yedam.edu.main;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.parser.JSONParser;

import com.yedam.edu.common.Command;
import com.yedam.edu.member.service.MemberService;
import com.yedam.edu.member.service.impl.MemberServiceMybatis;

public class CreateCenterInfo implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		int result = 0;
		try {
			ServletInputStream sis = request.getInputStream();
			byte[] bytes = sis.readAllBytes();
			String json = new String(bytes);

			JSONParser parser = new JSONParser();
			Object obj = parser.parse(json);
			ArrayList<Map<String, Object>> list = (ArrayList<Map<String, Object>>) obj;

			MemberService service = new MemberServiceMybatis();
			for (Map<String, Object> map : list) {
				Set<String> set = map.keySet();
				for (String key : set)
					System.out.println(key + " : " + map.get(key));

				System.out.println("=====================");
			}

			result = service.insertCenterInfo(list);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "ajax:{\"cnt\":" + result + "}";
	}

}
