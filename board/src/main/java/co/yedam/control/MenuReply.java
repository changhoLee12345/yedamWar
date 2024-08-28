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
		map.put("/replyList.do", new MainReplyControl()); // 목록json
		map.put("/removeReply.do", new MainReplyControl()); // 삭제json
		map.put("/replyCount.do", new MainReplyControl());
		map.put("/addReply.do", new MainReplyControl());

		// 차트.
		map.put("/chartForm.do", new MainReplyControl());
		map.put("/chartJson.do", new MainReplyControl());

		// datatable.
		map.put("/datatable.do", new MainReplyControl());

		// 카트목록.
		map.put("/cartList.do", new MainReplyControl());
		// 수량변경.
		map.put("/editCart.do", new MainReplyControl());
		// 카트상품삭제.
		map.put("/delCart.do", new MainReplyControl());

		return map;
	}
}
