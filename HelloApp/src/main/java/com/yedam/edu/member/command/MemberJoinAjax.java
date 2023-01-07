package com.yedam.edu.member.command;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.edu.common.Command;
import com.yedam.edu.member.service.MemberService;
import com.yedam.edu.member.service.impl.MemberServiceMybatis;
import com.yedam.edu.member.vo.MemberVO;

public class MemberJoinAjax implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Map<String, Object> resultMap = new HashMap<>();
		String savePath = request.getServletContext().getRealPath("/images");
		String fileName = "";
//		String fileUrl = "";
		try {
			MultipartRequest multi = new MultipartRequest(request, savePath, 1024 * 1024 * 10, "utf-8",
					new DefaultFileRenamePolicy());
			Enumeration<?> files = multi.getFileNames();
			while (files.hasMoreElements()) {
				String file = (String) files.nextElement();
				fileName = multi.getFilesystemName(file);
			}
			// id, passwd, name, email, responsibility, pfilename, ofilename, cdate
			String id = multi.getParameter("id");
			String pw = multi.getParameter("pass");
			String name = multi.getParameter("name");
			String email = multi.getParameter("email");
			String responsibility = multi.getParameter("responsibility");
			String phone = multi.getParameter("phone");
			String addr = multi.getParameter("addr");

			MemberVO vo = new MemberVO();
			vo.setId(id);
			vo.setPasswd(pw);
			vo.setEmail(email);
			vo.setName(name);
			vo.setResponsibility(responsibility);
			vo.setPhoneNumber(phone);
			vo.setPfilename(fileName);
			vo.setAddr(addr);
			
			System.out.println(vo);

			MemberService service = new MemberServiceMybatis();
			int rtn = service.insertMember(vo);

			if (rtn > 0) {
				vo = service.searchMember(vo.getId());
				resultMap.put("retCode", "Success");
				resultMap.put("data", vo);

			} else {
				resultMap.put("retCode", "Fail");

			}

			// fileUrl = request.getContextPath() + "/images/" + fileName;

		} catch (IOException e) {
			e.printStackTrace();
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
