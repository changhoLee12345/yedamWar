package co.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.MemberService;
import co.yedam.service.MemberServiceImpl;
import co.yedam.vo.MemberVO;

public class AddMemberAjax implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mid = req.getParameter("mid");
		String mnm = req.getParameter("name");
		String phn = req.getParameter("phone");
		String mpw = req.getParameter("pass");

		MemberVO mvo = new MemberVO();
		mvo.setMemberId(mid);
		mvo.setMemberPw(mpw);
		mvo.setPhone(phn);
		mvo.setMemberNm(mnm);

		MemberService svc = new MemberServiceImpl();
		if (svc.addMember(mvo)) {
			// {"retCode": "Success"}
			resp.getWriter().print("{\"retCode\": \"Success\"}");
		} else {
			// {"retCode": "Fail"}
			resp.getWriter().print("{\"retCode\": \"Fail\"}");
		}

	}

}
