package co.yedam.member.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Control;
import co.yedam.member.service.MemberService;
import co.yedam.member.service.MemberServiceImpl;
import co.yedam.member.vo.Member;

public class LoginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");

		Member member = new Member();
		member.setId(id);
		member.setPw(pw);

		MemberService svc = new MemberServiceImpl();
		member = svc.loginCheck(member);

		if (member != null) { // 아이디, 비번 => 로그인 정상.
			HttpSession session = req.getSession(); // 사용자별로 다른 세션값.
			session.setAttribute("logid", id); // 세션의 attribute를 활용.
			session.setAttribute("logName", member.getName());

			resp.sendRedirect("boardList.do");
		} else {
			req.setAttribute("message", "아이디와 비번을 확인하세요.");
			String path = "WEB-INF/view/member/loginForm.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
		}

	}

}
