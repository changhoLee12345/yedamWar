package com.dev.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.controller.CartController;
import com.dev.controller.MainController;
import com.dev.controller.MemberJoinController;
import com.dev.controller.MemberJoinFormController;
import com.dev.controller.MemberLoginController;
import com.dev.controller.MemberLoginFormController;
import com.dev.controller.SpecialController;
import com.dev.controller.TilesTableController;
import com.dev.controller.board.BoardController;
import com.dev.controller.board.ReplyListController;
import com.dev.controller.member.MemberDeleteController;
import com.dev.controller.member.MemberInsertController;
import com.dev.controller.member.MemberJsonController;
import com.dev.controller.member.MemberListController;
import com.dev.controller.member.MemberSearchController;
import com.dev.controller.member.MemberUpdateController;

public class FrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	String charset = null;
	HashMap<String, Controller> list = null;

	@Override
	public void init(ServletConfig config) throws ServletException {

//		getServletConfig().getInitParameter("charset");
		charset = config.getInitParameter("charset");

		list = new HashMap<String, Controller>();
		list.put("/main.do", new MainController());

		list.put("/memberJoinForm.do", new MemberJoinFormController());
		list.put("/memberJoin.do", new MemberJoinController());
		list.put("/memberLoginForm.do", new MemberLoginFormController());
		list.put("/memberLogin.do", new MemberLoginController());

		list.put("/memberDelete.do", new MemberDeleteController());
		list.put("/memberInsert.do", new MemberInsertController());
		list.put("/memberList.do", new MemberListController());
		list.put("/memberSearch.do", new MemberSearchController());
		list.put("/memberUpdate.do", new MemberUpdateController());
		list.put("/memberJson.do", new MemberJsonController());

		list.put("/board.do", new BoardController());
		list.put("/replyList.do", new ReplyListController());

		list.put("/spec.do", new SpecialController());
		list.put("/table.do", new TilesTableController());
		list.put("/cart.do", new CartController());

	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(charset);

		String url = req.getRequestURI();
		String contextPath = req.getContextPath();
		String path = url.substring(contextPath.length());
		System.out.println(path);

		Controller subControl = list.get(path);
		subControl.execute(req, resp);

	}

}
