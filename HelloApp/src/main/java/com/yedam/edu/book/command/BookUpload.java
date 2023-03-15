package com.yedam.edu.book.command;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.edu.common.Command;

public class BookUpload implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String savePath = request.getServletContext().getRealPath("/resources/bookImages");
		String fileName = "";
		String fileUrl = "";
		try {
			MultipartRequest multi = new MultipartRequest(request, savePath, 1024 * 1024 * 10, "utf-8",
					new DefaultFileRenamePolicy());
			Enumeration<?> files = multi.getFileNames();
			while (files.hasMoreElements()) {
				String file = (String) files.nextElement();
				fileName = multi.getFilesystemName(file);
			}
			fileUrl = request.getContextPath() + "/resources/bookImages/" + fileName;

		} catch (IOException e) {
			e.printStackTrace();
		}

		JsonObject json = new JsonObject();
		json.addProperty("uploaded", 1);
		json.addProperty("fileName", fileName);
		json.addProperty("url", fileUrl);

		System.out.println(json);

		return "ajax:" + json;
	}

}
