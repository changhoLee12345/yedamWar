package com.dev.mybatisdb;

import java.util.List;

import com.dev.vo.BoardVO;

public interface BaordMapper {

	public BoardVO getBoard(int bno);
	public List<BoardVO> getBoardList(String writer);

}
