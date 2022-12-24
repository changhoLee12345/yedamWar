package com.yedam.edu.book.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.edu.book.mapper.BookMapper;
import com.yedam.edu.book.service.BookService;
import com.yedam.edu.book.vo.BookVO;
import com.yedam.edu.common.DataSource;

public class BookServiceImpl implements BookService {
	SqlSession session = DataSource.getInstance().openSession(true); // SqlSession 을 통해 쿼리.
	BookMapper mapper = session.getMapper(BookMapper.class);

	@Override
	public BookVO selectBook(BookVO vo) {
		return mapper.selectBook(vo);
	}

	@Override
	public BookVO selectColumn(String column, String value) {
		return mapper.selectColumn(column, value);
	}

	@Override
	public List<BookVO> selectBooks(BookVO vo) {
		return mapper.selectBooks(vo);
	}

}
