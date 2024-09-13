package com.dev.service;

import java.util.List;
import java.util.Map;

import com.dev.common.SearchDTO;
import com.dev.dao.BoardMybatis;
import com.dev.vo.BoardVO;
import com.dev.vo.ReplyVO;

public class BoardServiceImpl implements BoardService {

//	BoardDAO dao = new BoardDAO();
	BoardMybatis action = BoardMybatis.getInstance();

	// Singleton 객체.
	private static BoardServiceImpl instance = new BoardServiceImpl();

	private BoardServiceImpl() {
	}

	public static BoardServiceImpl getInstance() {
		return instance;
	}

	// 1) 원본글에 대한 답글을 보여준다.
	public List<ReplyVO> getReplyList(int bno) {
		return action.getReplyList(bno);
	}

	// 2) 원본글에 대한 답글을 보여준다.
	public List<Map<String, Object>> getReplyMapList(int bno) {
		List<Map<String, Object>> mapList = action.getReplyMapList(bno);
		return mapList;
	}

	// 게시글 리스트(답글 없는 게시글만 보여준다.)
	@Override
	public List<BoardVO> boardList(SearchDTO search) {
		return action.boardList(search);
	}

	// 원본글과 답글을 목록으로 보여준다.
	public List<BoardVO> getBoardReplyList(String writer) {
		List<BoardVO> boardList = null;// getBoardList(writer);
		for (BoardVO board : boardList) {
			board.setReplyList(getReplyList(board.getBoardNo()));
		}
		return boardList;
	}

	@Override
	public BoardVO getBoard(int bno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addBoard(BoardVO board) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyBoard(BoardVO board) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeBoard(int bno) {
		// TODO Auto-generated method stub
		return false;
	}

}
