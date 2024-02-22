package co.yedam.control.reply;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.common.Control;
import co.yedam.service.ReplyService;
import co.yedam.service.ReplyServiceImpl;
import co.yedam.vo.Reply;
import co.yedam.vo.SearchVO;

public class ReplyListControl implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/json;charset=utf-8");

		String rpage = request.getParameter("rpage");
		String bno = request.getParameter("bno");

		SearchVO search = new SearchVO();
		search.setBno(Integer.parseInt(bno));
		search.setRpage(Integer.parseInt(rpage));

		ReplyService svc = new ReplyServiceImpl();
		List<Reply> list = svc.selectList(search);

		try {
			Gson gson = new GsonBuilder().create();
			String json = gson.toJson(list);

			response.getWriter().print(json);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
