package co.yedam.control.reply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.ReplyService;
import co.yedam.service.ReplyServiceImpl;

public class ReplyCountControl implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bno = request.getParameter("bno");

		ReplyService svc = new ReplyServiceImpl();
		int cnt = svc.replyCount(Integer.parseInt(bno));

		// {"totalCount": 3}
		String json = "{\"totalCount\": " + cnt + "}";

		response.getWriter().println(json);

	}

}
