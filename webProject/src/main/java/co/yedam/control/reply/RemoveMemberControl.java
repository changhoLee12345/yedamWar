package co.yedam.control.reply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.MemberService;
import co.yedam.service.MemberServiceImpl;

public class RemoveMemberControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mid = req.getParameter("mid");

		MemberService svc = new MemberServiceImpl();
		if (svc.removeMember(mid)) {
			// {"retCode": "Success"}
			resp.getWriter().print("{\"retCode\": \"Success\"}");
		} else {
			// {"retCode": "Fail"}
			resp.getWriter().print("{\"retCode\": \"Fail\"}");
		}

	}

}
