package com.yedam.edu.member.command;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.edu.common.Command;
import com.yedam.edu.member.service.MemberService;
import com.yedam.edu.member.service.impl.MemberServiceMybatis;
import com.yedam.edu.member.vo.MemberVO;

public class ImageUpload implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		String savePath = request.getServletContext().getRealPath("resources/images");
		String fileName = "";
//		String fileUrl = "";
		try {
			MultipartRequest multi = //
					new MultipartRequest(request, savePath, 1024 * 1024 * 10, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<?> files = multi.getFileNames();
			while (files.hasMoreElements()) {
				String file = (String) files.nextElement();
				fileName = multi.getFilesystemName(file);
			}
			// id, passwd, name, email, responsibility, pfilename, ofilename, cdate
			String id = multi.getParameter("id");

			MemberVO vo = new MemberVO();
			vo.setId(id);
			vo.setPfilename(fileName);

			MemberService service = new MemberServiceMybatis();
			int rtn = service.modifyMember(vo);

			if (rtn > 0) {
				// {"retCode":"Success", "image": }
				return "ajax:" + "{\"retCode\":\"Success\", \"image\": \"" + fileName + "\"}";
			}

			// fileUrl = request.getContextPath() + "/images/" + fileName;

		} catch (

		IOException e) {
			e.printStackTrace();
		}

		return "ajax:" + "{\"retCode\":\"Fail\"}";
	}

}
