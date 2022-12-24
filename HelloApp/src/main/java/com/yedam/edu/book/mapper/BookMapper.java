package com.yedam.edu.book.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.edu.book.vo.BookVO;

public interface BookMapper {
	public List<BookVO> selectBooks(BookVO vo);
	public List<BookVO> selectBookList(BookVO vo);
	public BookVO selectBook(BookVO vo);
	public BookVO selectColumn(@Param("column") String column, @Param("value") String value);
	public int insertBook(BookVO vo);
	public int updateBook(BookVO vo);
	public int deleteBook(BookVO vo);
}
