package co.yedam.control;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import co.yedam.common.Control;

public class FileUploadControl implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String upload = request.getServletContext().getRealPath("upload");
		int maxSize = 1024 * 1024 * 10;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

		DiskFileItemFactory itemFactory = new DiskFileItemFactory();
		itemFactory.setRepository(new File(upload));
		itemFactory.setSizeThreshold(maxSize);
		itemFactory.setDefaultCharset("utf-8");

		ServletFileUpload fileUpload = new ServletFileUpload(itemFactory);
		try {
			List<FileItem> items = fileUpload.parseRequest(request);
			for (FileItem item : items) {
				if (item.isFormField()) {
					System.out.println(String.format("파라미터: %s, 값: %s, 파일크기: %s", item.getFieldName(), item.getString(),
							item.getSize()));
				} else {
					System.out.println(String.format("파라미터: %s, 파일크기: %s", item.getFieldName(), item.getSize()));
					if (item.getSize() > 0) {
						String separator = File.separator;
						int idx = item.getName().lastIndexOf(separator);
						String fileName = item.getName().substring(idx + 1);
						fileName = sdf.format(new Date()) + "_" + fileName;
						File uploadFile = new File(upload + separator + fileName);

						item.write(uploadFile); // 파일아이템의 write는 복사.
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
