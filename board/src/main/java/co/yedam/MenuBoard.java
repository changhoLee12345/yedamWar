package co.yedam;

import java.util.HashMap;
import java.util.Map;

import co.yedam.common.Control;
import co.yedam.control.board.AddBoard;
import co.yedam.control.board.AddBoardForm;
import co.yedam.control.board.BoardControl;
import co.yedam.control.board.BoardListControl;
import co.yedam.control.board.BoardMainControl;
import co.yedam.control.board.ModifyBoard;
import co.yedam.control.board.ModifyBoardForm;
import co.yedam.control.board.RemoveBoard;
import co.yedam.control.board.RemoveBoardForm;

public class MenuBoard {
	private static MenuBoard instance = new MenuBoard();

	private MenuBoard() {
	}

	public static MenuBoard getInstance() {
		return instance;
	}

	public Map<String, Control> getMenu() {
		Map<String, Control> menu = new HashMap<>();
		menu.put("/boardList.do", new BoardListControl());
		menu.put("/getboard.do", new BoardControl());
		menu.put("/addBoardForm.do", new AddBoardForm());// 등록화면.
		menu.put("/addBoard.do", new AddBoard());// 등록기능.
		menu.put("/modifyForm.do", new ModifyBoardForm());
		menu.put("/modifyBoard.do", new ModifyBoard());
		menu.put("/removeForm.do", new RemoveBoardForm());
		menu.put("/removeBoard.do", new RemoveBoard());

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
//		menu.put("/board.do", new BoardDoControl());

		return menu;
	}
}
