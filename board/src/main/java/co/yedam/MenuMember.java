package co.yedam;

import java.util.HashMap;
import java.util.Map;

import co.yedam.common.Control2;
import co.yedam.control.MemberMainControl;
import co.yedam.control.api.DomForm;
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
import co.yedam.control.reply.RemoveMemberControl;

public class MenuMember {
	private static MenuMember instance = new MenuMember();

	private MenuMember() {
	}

	public static MenuMember getInstance() {
		return instance;
	}

	public Map<String, Control2> getMenuMap() {

		Map<String, Control2> map = new HashMap<>();

		// member관련.
		map.put("/loginForm.do", new MemberMainControl());
		map.put("/login.do", new MemberMainControl());
		map.put("/logout.do", new MemberMainControl());

		// 회원가입.
		map.put("/addMemberForm.do", new MemberMainControl());
		map.put("/addMember.do", new MemberMainControl());
		map.put("/memberList.do", new MemberMainControl());

		// json 데이터 생성.
		map.put("/domForm.do", new MemberMainControl());
		map.put("/memberData.do", new MemberMainControl());

		map.put("/memberForm.do", new MemberMainControl()); // 회원관리화면 Ajax처리.
		map.put("/memberAjax.do", new MemberMainControl()); // 회원목록 json 반환.
		map.put("/removeMember.do", new MemberMainControl());
		map.put("/addMemberAjax.do", new MemberMainControl());

		return map;
	}
}
