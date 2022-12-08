package com.dev.service;

import com.dev.dao.BoardMybatis;
import com.dev.vo.BoardVO;

public class BoardServiceImpl {
	public BoardVO getBoard(int bno) {
		BoardMybatis dao = BoardMybatis.getInstance();
		return dao.getBoard(bno);
	}
}
