package com.dev.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dev.common.SqlMapSessionFactory;
import com.dev.mybatisdb.BaordMapper;
import com.dev.vo.BoardVO;

public class BoardMybatis {
	// sqlSessionFactory에서 sqlSession을 생성해오기 위해 ..
	SqlSessionFactory sessionFactory = SqlMapSessionFactory.getSqlSessionFactory();

	private static BoardMybatis instance = new BoardMybatis();

	private BoardMybatis() {
	}

	public static BoardMybatis getInstance() {
		return instance;
	}

	// 단건조회.
	public BoardVO getBoard(int bno) {
		try (SqlSession session = sessionFactory.openSession()) {
			BaordMapper mapper = session.getMapper(BaordMapper.class);
			BoardVO vo = mapper.getBoard(bno);
			return vo;
		}
	}

}
