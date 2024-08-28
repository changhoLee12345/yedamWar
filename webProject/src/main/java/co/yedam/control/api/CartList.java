package co.yedam.control.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.common.Control;
import co.yedam.service.MemberService;
import co.yedam.service.MemberServiceImpl;
import co.yedam.vo.CartVO;

public class CartList implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/json;charset=utf-8");
		
		System.out.println(req.getRemoteAddr());

//		HttpSession session = req.getSession();
//		Object info = session.getAttribute("logId");
//		if (info == null) {
//			return;
//		}
//		if (!req.getRemoteAddr().equals("0:0:0:0:0:0:0:1")) {
//			return;
//		}
		MemberService svc = new MemberServiceImpl();
		List<CartVO> list = svc.cartList();
		System.out.println(list);

		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(list);
		System.out.println(json);

		resp.getWriter().print(json);

	}

}
