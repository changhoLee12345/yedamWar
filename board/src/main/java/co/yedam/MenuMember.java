package co.yedam;

import java.util.HashMap;
import java.util.Map;

import co.yedam.common.Control;
import co.yedam.control.CartList;
import co.yedam.control.ChartForm;
import co.yedam.control.ChartJson;
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

public class MenuMember {
	private static MenuMember instance = new MenuMember();

	private MenuMember() {
	}

	public static MenuMember getInstance() {
		return instance;
	}

	public Map<String, Control> getMenu() {
		Map<String, Control> map = new HashMap<>();
		// member관련.
		map.put("/loginForm.do", new LoginFormControl());
		map.put("/login.do", new LoginControl());
		map.put("/logout.do", new LogoutControl());

		// 회원가입.
		map.put("/addMemberForm.do", new AddMemberForm());
		map.put("/addMember.do", new AddMemberControl());
		map.put("/memberList.do", new MemberListControl());

		// json 데이터 생성.
		map.put("/domForm.do", new DomForm());
		map.put("/memberData.do", new MemberDataControl());

		map.put("/memberForm.do", new MemberForm()); // 회원관리화면 Ajax처리.
		map.put("/memberAjax.do", new MemberAjax()); // 회원목록 json 반환.
		map.put("/removeMember.do", new RemoveMemberControl());
		map.put("/addMemberAjax.do", new AddMemberAjax());

		map.put("/replyList.do", new ReplyList()); // 목록json
		map.put("/removeReply.do", new RemoveReply()); // 삭제json
		map.put("/replyCount.do", new ReplyCount());
		map.put("/addReply.do", new AddReply());

		// 차트.
		map.put("/chartForm.do", new ChartForm());
		map.put("/chartJson.do", new ChartJson());

		// datatable.
		map.put("/datatable.do", new DataTable());

		// 카트목록.
		map.put("/cartList.do", new CartList());
		// 수량변경.
		map.put("/editCart.do", new EditCart());
		// 카트상품삭제.
		map.put("/delCart.do", new DelCart());
		return map;
	}
}
