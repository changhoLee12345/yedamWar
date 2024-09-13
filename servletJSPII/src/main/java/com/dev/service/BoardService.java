package com.dev.service;

import java.util.List;

import com.dev.common.SearchDTO;
import com.dev.vo.BoardVO;

public interface BoardService {
	List<BoardVO> boardList(SearchDTO search);
	BoardVO getBoard(int bno);
	boolean addBoard(BoardVO board);
	boolean modifyBoard(BoardVO board);
	boolean removeBoard(int bno);
}
