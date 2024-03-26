package com.fileupload;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/FileUploadServ")
public class FileUploadServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FileUploadServ() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();

		boolean isMulti = ServletFileUpload.isMultipartContent(request);

		if (isMulti) {

			// multipart request => request, save_dir, max_size, encoding, rename policy;
			String saveDir = getServletContext().getRealPath("upload");
			String encoding = "UTF-8";
			int maxSize = 1024 * 1024 * 5;

			MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding,
					new DefaultFileRenamePolicy());

			String title = multi.getParameter("title");
			String content = multi.getParameter("content");
			String fileName = multi.getFilesystemName("imgProfile");
			String oriName = multi.getOriginalFileName("imgProfile");

			System.out.printf("title %s, content %s, fileName %s, origName %s", title, content, fileName, oriName);
			System.out.println();
			out.println("<h3>업로드성공.</h3>");

		} else {
			
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			System.out.printf("title %s, content %s ", title, content);
			System.out.println();
			out.println("<h3>요청정보성공.</h3>");

		}

	}

}
