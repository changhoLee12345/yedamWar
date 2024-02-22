package co.yedam.control.emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Control;
import co.yedam.common.Https;
import co.yedam.service.EmpService;
import co.yedam.service.EmpServiceImpl;
import co.yedam.vo.Member;
import co.yedam.vo.SearchVO;

public class LoginControl implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		SearchVO search = new SearchVO();
		search.setId(id);
		search.setPw(pw);

		EmpService svc = new EmpServiceImpl();
		Member member = svc.login(search);

		if (member != null) {
			// ok.
			HttpSession session = request.getSession();
			session.setAttribute("logid", member.getId());
			session.setAttribute("userName", member.getName());

			response.sendRedirect("boardList.do");
		} else {
			request.setAttribute("message", "id, pw 를 확인하세요!!");
			String path = "WEB-INF/view/logForm.jsp";
			Https.forward(path, request, response);
		}
	}

}
