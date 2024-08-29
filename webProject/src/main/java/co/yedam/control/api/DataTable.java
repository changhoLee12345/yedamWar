package co.yedam.control.api;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

public class DataTable implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// json 작성ㅂ.
		String bno = req.getParameter("bno");
		SearchVO search = new SearchVO();
		search.setBno(Integer.parseInt(bno));

		ReplyService svc = new ReplyServiceImpl();
		List<ReplyVO> list = svc.replyList(search);
		Map<String, Object> map = new HashMap<>();
		map.put("data", list);

		Gson gson = new GsonBuilder().create();
		resp.getWriter().print(gson.toJson(map));

	}

}
