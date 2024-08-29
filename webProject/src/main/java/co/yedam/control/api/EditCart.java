package co.yedam.control.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.MemberService;
import co.yedam.service.MemberServiceImpl;
import co.yedam.vo.CartVO;

public class EditCart implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String no = req.getParameter("no");
		String qty = req.getParameter("qty");

		CartVO cvo = new CartVO();
		cvo.setNo(Integer.parseInt(no));
		cvo.setQty(Integer.parseInt(qty));

		MemberService svc = new MemberServiceImpl();
		if (svc.modifyCart(cvo)) {
			// {"retCode":"Success"}
			resp.getWriter().print("{\"retCode\":\"Success\"}");
		} else {
			resp.getWriter().print("{\"retCode\":\"Fail\"}");
		}

	}

}
