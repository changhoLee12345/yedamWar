package co.yedam.service;

import java.util.List;

import co.yedam.common.SearchVO;
import co.yedam.vo.BoardVO;

public interface BoardService {
	List<BoardVO> boardList(SearchVO search);
	int getCount(SearchVO search); // 전체건수.
	BoardVO getBoard(int bno);
	boolean addBoard(BoardVO vo);
	boolean modifyBoard(BoardVO vo);
	boolean removeBoard(int bno);
	boolean addViewCnt(int bno);
}
