package co.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.reply.Reply;
import co.yedam.reply.service.ReplyService;
import co.yedam.reply.service.ReplyServiceImpl;

public class DataTableControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bno = req.getParameter("bno");
		ReplyService svc = new ReplyServiceImpl();
		SearchVO search = new SearchVO();
		search.setBno(Integer.parseInt(bno));

		List<Reply> list = svc.replyList(search);

		Map<String, Object> map = new HashMap<>();
		map.put("data", list);
		Gson gson = new GsonBuilder().create();
		resp.getWriter().print(gson.toJson(map));

	}

}
