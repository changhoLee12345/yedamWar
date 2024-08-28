package co.yedam;

import java.util.HashMap;
import java.util.Map;

import co.yedam.common.Control2;
import co.yedam.control.ReplyMainControl;
import co.yedam.control.api.CartList;
import co.yedam.control.api.ChartForm;
import co.yedam.control.api.ChartJson;
import co.yedam.control.api.DataTable;
import co.yedam.control.api.DelCart;
import co.yedam.control.api.EditCart;
import co.yedam.control.reply.AddReply;
import co.yedam.control.reply.RemoveReply;
import co.yedam.control.reply.ReplyCount;

public class MenuReply {
	private static MenuReply instance = new MenuReply();

	private MenuReply() {
	}

	public static MenuReply getInstance() {
		return instance;
	}

	public Map<String, Control2> getMenu() {

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
