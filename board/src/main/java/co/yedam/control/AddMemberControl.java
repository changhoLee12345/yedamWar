package co.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.MemberService;
import co.yedam.service.MemberServiceImpl;
import co.yedam.vo.MemberVO;

public class AddMemberControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("mid");
		String nm = req.getParameter("mname");
		String ph = req.getParameter("phone");
		String pw = req.getParameter("pw");

		MemberVO vo = new MemberVO();
		vo.setMemberId(id);
		vo.setMemberNm(nm);
		vo.setMemberPw(pw);
		vo.setPhone(ph);
		vo.setResponsibility("User");

		MemberService svc = new MemberServiceImpl();
		if (svc.addMember(vo)) {
			resp.sendRedirect("boardList.do");

		} else {
			resp.sendRedirect("addMemberForm.do");

		}

	}

}
