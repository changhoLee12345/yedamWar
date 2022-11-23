package co.micol.prj.book.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.micol.prj.book.service.BookService;
import co.micol.prj.book.service.impl.BookServiceImpl;
import co.micol.prj.book.vo.BookVO;
import co.micol.prj.common.Command;

public class AjaxBookModify implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String code = request.getParameter("bcode");
		String title = request.getParameter("btitle");
		String author = request.getParameter("bauthor");
		String press = request.getParameter("bpress");
		String price = request.getParameter("bprice");

		BookVO vo = new BookVO();
		vo.setBookCode(code);
		vo.setBookTitle(title);
		vo.setBookAuthor(author);
		vo.setBookPress(press);
		vo.setBookPrice(Integer.parseInt(price));

		System.out.println(vo);

		BookService service = new BookServiceImpl();
		service.bookUpdate(vo);

		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		try {
			json = mapper.writeValueAsString(vo);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "ajax:" + json;

	}

}
