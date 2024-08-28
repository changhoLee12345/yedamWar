package co.yedam;

import java.util.HashMap;
import java.util.Map;

import co.yedam.common.Control2;
import co.yedam.control.BoardMainControl;

public class MenuBoard {
	private static MenuBoard instance = new MenuBoard();

	private MenuBoard() {
	}

	public static MenuBoard getInstance() {
		return instance;
	}

	public Map<String, Control2> getMenu() {

		Map<String, Control2> menu = new HashMap<>();

		// 위의 각각의 컨트롤을 만드니까 관리해야할 컨트롤이 많아져서 아래의 컨트롤로 통합함.
		// 키가 같은 값으로 등록되면 새로등록한 키값으로 컨트롤이 변경이 되니까...

		menu.put("/boardList.do", new BoardMainControl());
		menu.put("/getboard.do", new BoardMainControl());
		menu.put("/addBoardForm.do", new BoardMainControl());// 등록화면.
		menu.put("/addBoard.do", new BoardMainControl());// 등록기능.
		menu.put("/modifyForm.do", new BoardMainControl());
		menu.put("/modifyBoard.do", new BoardMainControl());
		menu.put("/removeForm.do", new BoardMainControl());
		menu.put("/removeBoard.do", new BoardMainControl());

		return menu;
	}
}
