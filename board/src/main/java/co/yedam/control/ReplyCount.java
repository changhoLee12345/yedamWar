package co.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.ReplyService;
import co.yedam.service.ReplyServiceImpl;

public class ReplyCount implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bno = req.getParameter("bno");

		ReplyService svc = new ReplyServiceImpl();
		int totalCount = svc.getReplyCount(Integer.parseInt(bno));

		// json포맷. {"totalCount": 24}
		resp.getWriter().print("{\"totalCount\": " + totalCount + "}");

	}

}
