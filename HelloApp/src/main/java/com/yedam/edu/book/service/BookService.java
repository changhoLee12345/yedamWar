package com.yedam.edu.book.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.edu.book.vo.BookVO;

public interface BookService {
	public BookVO selectBook(String bookCode);
	public BookVO selectColumn(@Param("column") String column, @Param("value") String value);
	public List<BookVO> selectBooks(BookVO vo);
	public int addBook(BookVO vo);
	public int modBook(BookVO vo);
	
	// json data
	public List<BookVO> bookList();
	public int deleteBook(String bcode);
	public int insertBook(BookVO vo);
}
