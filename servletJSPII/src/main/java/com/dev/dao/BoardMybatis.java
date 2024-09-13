package com.dev.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dev.common.DataSource;
import com.dev.common.SearchDTO;
import com.dev.vo.BoardVO;
import com.dev.vo.ReplyVO;

public class BoardMybatis implements BoardAction {

	// sqlSessionFactory에서 sqlSession을 생성해오기 위해 ..
	SqlSessionFactory sqlSessionFactory = DataSource.getSqlSessionFactory();
	SqlSession session = sqlSessionFactory.openSession(true);

	// static instance 활용.
	private static BoardMybatis instance = new BoardMybatis();

	private BoardMybatis() {
	}

	public static BoardMybatis getInstance() {
		return instance;
	}

	// 글조회.
	public BoardVO getBoard(int bno) {
		BoardVO board = session.selectOne("com.dev.mybatisdb.boardMapper.getBoard", bno);
		session.close();
		return board;
	}

	// 댓글목록.
	public List<ReplyVO> getReplyList(int bno) {
		List<ReplyVO> replyList = session.selectList("com.dev.mybatisdb.boardMapper.getReplyList", bno);
		session.close();
		return replyList;
	}

	public List<Map<String, Object>> getReplyMapList(int bno) {
		List<Map<String, Object>> mapList = session.selectList("com.dev.mybatisdb.boardMapper.getReplyMapList", bno);
		session.close();
		return mapList;
	}

	// 글목록.
	@Override
	public List<BoardVO> boardList(SearchDTO search) {
		List<BoardVO> boardList = session.selectList("com.dev.mybatisdb.boardMapper.getBoardList", search.getWriter());
		session.close();
		return boardList;
	}

	@Override
	public boolean addBoard(BoardVO board) {
		return false;
	}

	@Override
	public boolean modifyBoard(BoardVO board) {
		return false;
	}

	@Override
	public boolean removeBoard(int bno) {
		return false;
	}

}
