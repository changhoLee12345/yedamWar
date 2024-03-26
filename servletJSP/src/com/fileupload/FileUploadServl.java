package com.fileupload;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(location = "C:\\temp", maxFileSize = -1, maxRequestSize = -1, fileSizeThreshold = 1024)
@WebServlet("/FileUploadServl")
public class FileUploadServl extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String CHARSET = "UTF-8";
	private static final String ATTACHES_DIR = "c:\\temp";

	public FileUploadServl() {
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding(CHARSET);
		PrintWriter out = response.getWriter();
		String contentType = request.getContentType();

		if (contentType != null && contentType.toLowerCase().startsWith("multipart/")) {
			Collection<Part> parts = request.getParts();

			for (Part part : parts) {
				System.out.printf("파라미터명 : %s, contentType: %s, size: %d bytes\n", part.getName(),
						part.getContentType(), part.getSize());
				String fileName = extractFileName(part.getHeader("Content-Disposition"));
				System.out.println("submittedFileName: " + part.getSubmittedFileName());
				if (part.getSize() > 0) {
					part.write(ATTACHES_DIR + File.separator + fileName);
					part.delete();
				} else {
					String formValue = request.getParameter(part.getName());
					System.out.printf("name: %s, value: %s \n", part.getName(), formValue);
				}
			}

		} else {
			out.print("<h3>multipart type이 아님</h3>");

		}

	}

	public String extractFileName(String partHeader) {
		for (String cd : partHeader.split(";")) {
			if (cd.trim().startsWith("filename")) {
				String fileName = cd.substring(cd.indexOf("=") + 1).trim().replace("\"", "");
				int index = fileName.lastIndexOf(File.separator);
				return fileName.substring(index + 1);
			}

		}
		return null;

	}

}
