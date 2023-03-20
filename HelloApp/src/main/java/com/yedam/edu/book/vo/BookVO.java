package com.yedam.edu.book.vo;

import com.yedam.edu.common.SearchVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BookVO extends SearchVO {
	private String bookCode;
	private String bookTitle;
	private String bookAuthor;
	private String bookPress;
	private int bookPrice;
	private String bookDesc;

	// 조회조건의 price1 ~ price2
	private int price1;
	private int price2;

	// query 정렬조건을 위해.
	private String orderBy;
}
