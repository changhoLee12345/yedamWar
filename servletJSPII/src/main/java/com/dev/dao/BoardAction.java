package com.dev.dao;

import java.util.List;

import com.dev.common.SearchDTO;
import com.dev.vo.BoardVO;

public interface BoardAction {

	// 글목록.
	List<BoardVO> boardList(SearchDTO search);

	// 단건조회.
	BoardVO getBoard(int bno);

	// 등록.
	boolean addBoard(BoardVO board);

	// 수정.
	boolean modifyBoard(BoardVO board);

	// 삭제.
	boolean removeBoard(int bno);

}
