package co.yedam.mapper;

import java.util.List;

import co.yedam.vo.Board;
import co.yedam.vo.Member;
import co.yedam.vo.SearchVO;

public interface BoardMapper {

	List<Board> selectListPaging(SearchVO search);
	List<Board> selectListPaging2(SearchVO search);
	int selectTotal(SearchVO search);

	Board selectBoard(SearchVO search);
	int updateBoardCnt(int bno);
	
	int insertBoard(Board board);

}
