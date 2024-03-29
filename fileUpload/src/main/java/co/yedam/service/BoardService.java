package co.yedam.service;

import java.util.List;

import co.yedam.vo.Board;
import co.yedam.vo.Member;
import co.yedam.vo.SearchVO;

public interface BoardService {
	List<Board> boardList(SearchVO search);
	int totalCnt(SearchVO search);
	
	Board getBoard(SearchVO search);
	
	boolean addBoard(Board board);
	
}
