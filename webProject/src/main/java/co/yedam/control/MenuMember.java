package co.yedam.control;

import java.util.HashMap;
import java.util.Map;

import co.yedam.common.Control2;

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
		map.put("/loginForm.do", new MainMemberControl());
		map.put("/login.do", new MainMemberControl());
		map.put("/logout.do", new MainMemberControl());

		// 회원가입.
		map.put("/addMemberForm.do", new MainMemberControl());
		map.put("/addMember.do", new MainMemberControl());
		map.put("/memberList.do", new MainMemberControl());

		// json 데이터 생성.
		map.put("/domForm.do", new MainMemberControl());
		map.put("/memberData.do", new MainMemberControl());

		map.put("/memberForm.do", new MainMemberControl()); // 회원관리화면 Ajax처리.
		map.put("/memberAjax.do", new MainMemberControl()); // 회원목록 json 반환.
		map.put("/removeMember.do", new MainMemberControl());
		map.put("/addMemberAjax.do", new MainMemberControl());

		return map;
	}
}
