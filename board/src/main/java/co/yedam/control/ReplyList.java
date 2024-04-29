package co.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.common.Control;
import co.yedam.common.SearchVO;
import co.yedam.service.ReplyService;
import co.yedam.service.ReplyServiceImpl;
import co.yedam.vo.ReplyVO;

public class ReplyList implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/json;charset=utf-8");

		// 원본글 파리미터. => 댓글목록(json)
		String bno = req.getParameter("bno");
		String page = req.getParameter("page");
		page = page == null ? "1" : page;

		SearchVO search = new SearchVO();
		search.setBno(Integer.parseInt(bno));
		search.setRpage(Integer.parseInt(page));

		ReplyService svc = new ReplyServiceImpl();
		List<ReplyVO> list = svc.replyList(search);

		Gson gson = new GsonBuilder()//
				.setDateFormat("yyyy-MM-dd HH:mm:ss")//
				.create();
		String json = gson.toJson(list);

		resp.getWriter().print(json);

	}

}
