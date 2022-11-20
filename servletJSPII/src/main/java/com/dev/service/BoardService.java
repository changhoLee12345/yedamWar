package com.dev.service;

import java.util.List;
import java.util.Map;

import com.dev.dao.BoardMybatisDAO;
import com.dev.vo.BoardVO;
import com.dev.vo.ReplyVO;

public class BoardService {
	private static BoardService instance = new BoardService();

	BoardMybatisDAO dao = BoardMybatisDAO.getInstance();
//	BoardDAO dao = new BoardDAO();

	private BoardService() {

	}

	public static BoardService getInstance() {
		return instance;
	}

	// 1) 원본글에 대한 답글을 보여준다.
	public List<ReplyVO> getReplyList(int bno) {
		return dao.getReplyList(bno);
	}

	// 2) 원본글에 대한 답글을 보여준다.
	public List<Map<String, Object>> getReplyMapList(int bno) {
		List<Map<String, Object>> mapList = dao.getReplyMapList(bno);
		return mapList;
	}

	// 사용자별 게시글 리스트(답글 없는 게시글만 보여준다.)
	public List<BoardVO> getBoardList(String writer) {
		return dao.getBoardList(writer);
	}

	// 원본글과 답글을 목록으로 보여준다.
	public List<BoardVO> getBoardReplyList(String writer) {
		List<BoardVO> boardList = getBoardList(writer);
		for (BoardVO board : boardList) {
			board.setReplyList(getReplyList(board.getBno()));
		}
		return boardList;
	}

}
