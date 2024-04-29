package co.yedam.control;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.common.Control;
import co.yedam.service.ReplyService;
import co.yedam.service.ReplyServiceImpl;
import co.yedam.vo.ReplyVO;

public class AddReply implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");

		// TODO 댓글내용, 작성자, 게시글번호
		String reply = req.getParameter("reply");
		String replyer = req.getParameter("replyer");
		String bno = req.getParameter("bno");

		ReplyVO rvo = new ReplyVO();
		rvo.setReply(reply);
		rvo.setReplyer(replyer);
		rvo.setBoardNo(Integer.parseInt(bno));
		rvo.setReplyDate(new Date());

		ReplyService svc = new ReplyServiceImpl();

		Map<String, Object> result = new HashMap<>();
		if (svc.addReply(rvo)) {
			// {"retCode":"Success", "retVal": rvo}
			result.put("retCode", "Success");
			result.put("retVal", rvo);

		} else {
			// {"retCode":"Fail", "retVal": null}
			result.put("retCode", "Fail");
			result.put("retVal", null);

		}
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(result);

		resp.getWriter().print(json);

	}

}
