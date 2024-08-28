package co.yedam.control;

import java.util.HashMap;
import java.util.Map;

import co.yedam.common.Control2;

public class MenuReply {
	private static MenuReply instance = new MenuReply();

	private MenuReply() {
	}

	public static MenuReply getInstance() {
		return instance;
	}

	public Map<String, Control2> getMenuMap() {

		Map<String, Control2> map = new HashMap<>();
		map.put("/replyList.do", new ReplyMainControl()); // 목록json
		map.put("/removeReply.do", new ReplyMainControl()); // 삭제json
		map.put("/replyCount.do", new ReplyMainControl());
		map.put("/addReply.do", new ReplyMainControl());

		// 차트.
		map.put("/chartForm.do", new ReplyMainControl());
		map.put("/chartJson.do", new ReplyMainControl());

		// datatable.
		map.put("/datatable.do", new ReplyMainControl());

		// 카트목록.
		map.put("/cartList.do", new ReplyMainControl());
		// 수량변경.
		map.put("/editCart.do", new ReplyMainControl());
		// 카트상품삭제.
		map.put("/delCart.do", new ReplyMainControl());

		return map;
	}
}
