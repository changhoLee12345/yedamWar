package co.yedam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.control.CartList;
import co.yedam.control.ChartForm;
import co.yedam.control.ChartJson;
import co.yedam.control.DataForm;
import co.yedam.control.DataTable;
import co.yedam.control.DelCart;
import co.yedam.control.DomForm;
import co.yedam.control.EditCart;
import co.yedam.control.board.AddBoard;
import co.yedam.control.board.AddBoardForm;
import co.yedam.control.board.BoardControl;
import co.yedam.control.board.BoardMainControl;
import co.yedam.control.board.BoardListControl;
import co.yedam.control.board.ModifyBoard;
import co.yedam.control.board.ModifyBoardForm;
import co.yedam.control.board.RemoveBoard;
import co.yedam.control.board.RemoveBoardForm;
import co.yedam.control.member.AddMemberAjax;
import co.yedam.control.member.AddMemberControl;
import co.yedam.control.member.AddMemberForm;
import co.yedam.control.member.LoginControl;
import co.yedam.control.member.LoginFormControl;
import co.yedam.control.member.LogoutControl;
import co.yedam.control.member.MemberAjax;
import co.yedam.control.member.MemberDataControl;
import co.yedam.control.member.MemberForm;
import co.yedam.control.member.MemberListControl;
import co.yedam.control.reply.AddReply;
import co.yedam.control.reply.RemoveMemberControl;
import co.yedam.control.reply.RemoveReply;
import co.yedam.control.reply.ReplyCount;
import co.yedam.control.reply.ReplyList;

// init -> service -> destroy
/*
 * FrontController의 기존 방식으로 작성한 서블릿의
 * 깃을 사용할 경우 충돌되는 문제로 인해 FrontControlMap으로 변경함.
 */
public class FrontControlMap extends HttpServlet {

	// url pattern - 실행서블릿. 관리.
	Map<String, Control> map;

	public FrontControlMap() {
		map = new HashMap<>();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {

		Map<String, Control> map1 = MenuBoard.getInstance().getMenu();
		Map<String, Control> map2 = MenuMember.getInstance().getMenu();

		map.putAll(map1);
		map.putAll(map2);

	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		resp.setContentType("text/html;charset=utf-8");

		String uri = req.getRequestURI();
		String context = req.getContextPath();
		String path = uri.substring(context.length());

		System.out.println("uri: " + uri + ", contxt: " + context + ", path: " + path);
		Control control = map.get(path);
		control.exec(req, resp);
	}
}
