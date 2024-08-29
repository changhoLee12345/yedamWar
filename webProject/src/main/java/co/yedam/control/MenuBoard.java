package co.yedam.control;

import java.util.HashMap;
import java.util.Map;

import co.yedam.common.Control2;

public class MenuBoard {
	private static MenuBoard instance = new MenuBoard();

	private MenuBoard() {
	}

	public static MenuBoard getInstance() {
		return instance;
	}

	public Map<String, Control2> menuMap() {

		Map<String, Control2> menu = new HashMap<>();

		// 위의 각각의 컨트롤을 만드니까 관리해야할 컨트롤이 많아져서 아래의 컨트롤로 통합함.
		// 키가 같은 값으로 등록되면 새로등록한 키값으로 컨트롤이 변경이 되니까...

		menu.put("/boardList.do", new MainBoardControl());
		menu.put("/getboard.do", new MainBoardControl());
		menu.put("/addBoardForm.do", new MainBoardControl());// 등록화면.
		menu.put("/addBoard.do", new MainBoardControl());// 등록기능.
		menu.put("/modifyForm.do", new MainBoardControl());
		menu.put("/modifyBoard.do", new MainBoardControl());
		menu.put("/removeForm.do", new MainBoardControl());
		menu.put("/removeBoard.do", new MainBoardControl());

		return menu;
	}
}
