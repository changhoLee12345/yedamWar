package co.yedam.control;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.common.Control;
import co.yedam.service.ReplyService;
import co.yedam.service.ReplyServiceImpl;

public class ChartJson implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/json;charset=utf-8");

		ReplyService svc = new ReplyServiceImpl();

		List<Map<String, Object>> obj = svc.getCntByMember();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(obj);

		resp.getWriter().print(json);

	}

}
