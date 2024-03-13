package co.yedam.common;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.member.service.MemberService;
import co.yedam.member.service.MemberServiceImpl;

/**
 * Servlet implementation class ChatServlet
 */
@WebServlet({ "/ChatServlet", "/send", "/get_messages" })
public class ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ChatServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ts = request.getParameter("timestamp"); // '2000-01-01 00:00:00';
		System.out.println(ts);
		MemberService svc = new MemberServiceImpl();
		List<Map<String, Object>> messages = svc.messageList(ts);

		Map<String, Object> map = new HashMap<>();
		map.put("messages", messages);
		Date timestamp = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		map.put("latest_timestamp", sdf.format(timestamp));

		Gson gson = new GsonBuilder().create();
		response.getWriter().print(gson.toJson(map));

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Enumeration<String> enu = request.getParameterNames();
		String msg = request.getParameter("message");
		String uid = request.getParameter("uid");
		System.out.println("msg:" + msg + ",uid:" + uid);
		MemberService svc = new MemberServiceImpl();
		svc.addMessage(msg);
		System.out.println("end of message");

	}

}
