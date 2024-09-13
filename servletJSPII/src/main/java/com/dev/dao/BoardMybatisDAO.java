package com.dev.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dev.common.DataSource;
import com.dev.vo.BoardVO;
import com.dev.vo.ReplyVO;

public class BoardMybatisDAO {

	// sqlSessionFactory에서 sqlSession을 생성해오기 위해 ..
	SqlSessionFactory sessionFactory = DataSource.getSqlSessionFactory();

	private static BoardMybatisDAO instance = new BoardMybatisDAO();

	private BoardMybatisDAO() {
	}

	public static BoardMybatisDAO getInstance() {
		return instance;
	}

	// 글조회.
	public BoardVO getBoard(int bno) {
		SqlSession session = sessionFactory.openSession();
		BoardVO board = session.selectOne("com.dev.mybatisdb.boardMapper.getBoard", bno);
		session.close();
		return board;
	}

	// 글목록.
	public List<BoardVO> getBoardList(String writer) {
		SqlSession session = sessionFactory.openSession();
		List<BoardVO> boardList = session.selectList("com.dev.mybatisdb.boardMapper.getBoardList", writer);
		session.close();
		return boardList;
	}

	// 댓글목록.
	public List<ReplyVO> getReplyList(int bno) {
		SqlSession session = sessionFactory.openSession();
		List<ReplyVO> replyList = session.selectList("com.dev.mybatisdb.boardMapper.getReplyList", bno);
		session.close();
		return replyList;
	}

	public List<Map<String, Object>> getReplyMapList(int bno) {
		SqlSession session = sessionFactory.openSession();
		List<Map<String, Object>> mapList = session.selectList("com.dev.mybatisdb.boardMapper.getReplyMapList", bno);
		session.close();
		return mapList;
	}

}
