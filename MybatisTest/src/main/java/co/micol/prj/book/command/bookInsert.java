package co.micol.prj.book.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.micol.prj.book.service.BookService;
import co.micol.prj.book.service.impl.BookServiceImpl;
import co.micol.prj.book.vo.BookFileVO;
import co.micol.prj.book.vo.BookVO;
import co.micol.prj.common.Command;

public class bookInsert implements Command {

	public boolean isMulti(HttpServletRequest request) {
		String contentType = request.getHeader("Content-Type");
		if (contentType != null && contentType.indexOf("multipart/form-data") != -1) {
			return true;
		}
		return false;
	}

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 도서 등록
		BookService service = new BookServiceImpl();
		BookVO bookVO = new BookVO();
		BookFileVO bookFileVO = new BookFileVO();
		String savePath = request.getServletContext().getRealPath("/upload/book/");
		System.out.println("savePath: " + savePath);

		ObjectMapper objectMapper = new ObjectMapper(); // list ==> json
		String json = null;
		Map<String, Object> map = new HashMap<>();
		Map<String, String> fileList = new HashMap<>();

		try {

			if (!isMulti(request)) { // JSON파일 처리하는것.
				String body = null;
				StringBuilder stringBuilder = new StringBuilder();
				BufferedReader bufferedReader = null;

				try {
					InputStream inputStream = request.getInputStream();
					if (inputStream != null) {
						bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
						char[] charBuffer = new char[128];
						int bytesRead = -1;
						while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
							stringBuilder.append(charBuffer, 0, bytesRead);
						}
					}
				} catch (IOException ex) {
					throw ex;
				} finally {
					if (bufferedReader != null) {
						try {
							bufferedReader.close();
						} catch (IOException ex) {
							throw ex;
						}
					}
				}

				body = stringBuilder.toString();
				return "ajax:" + body;
			}

			// Multipart 처리하는 것.
			MultipartRequest multi = new MultipartRequest(request, savePath, 1024 * 1024 * 100, "utf-8",
					new DefaultFileRenamePolicy());

			String bookCode = multi.getParameter("bookCode");
			String bookTitle = multi.getParameter("bookTitle");
			String bookAuthor = multi.getParameter("bookAuthor");
			String bookPress = multi.getParameter("bookPress");
			String bookPrice = multi.getParameter("bookPrice");

			bookVO.setBookCode(bookCode);
			bookVO.setBookTitle(bookTitle);
			bookVO.setBookAuthor(bookAuthor);
			bookVO.setBookPress(bookPress);
			bookVO.setBookPrice(Integer.valueOf(bookPrice));

			// {bookCode:?, bookTitle:?, bookAuthor:?, bookPress:?, bookPrice:?, fileList: {file1:?, file2:?, file3:?}}
			map.put("bookCode", bookCode);
			map.put("bookTitle", bookTitle);
			map.put("bookAuthor", bookAuthor);
			map.put("bookPress", bookPress);
			map.put("bookPrice", bookPrice);

			// 저장하고
			// 시퀀스 값 찾아오는 쿼리 실행
			int n = service.bookCode();

			int i = 1;
			Enumeration<?> fileNames = multi.getFileNames();

			while (fileNames.hasMoreElements()) {
				String file = (String) fileNames.nextElement();

				if (multi.getOriginalFileName(file) == null) { // file객체에 파일이 존재하지 않으면 다음객체 읽음
					continue;
				}

				bookFileVO.setBookCode(bookVO.getBookCode());
				bookFileVO.setBookImage(multi.getFilesystemName(file));
				bookFileVO.setBookPath("upload/book/" + multi.getOriginalFileName(file));
				service.bookInsertImage(bookFileVO); // 이미지 테이블 파일을 업로드

				fileList.put("file" + i++, multi.getFilesystemName(file));
			}

			service.bookInsert(bookVO); // 내용테이블 내용을 업로드
			map.put("fileList", fileList);

			try {
				json = objectMapper.writeValueAsString(map);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return "ajax:" + json;

		// return "bookList.do";

	}

}
