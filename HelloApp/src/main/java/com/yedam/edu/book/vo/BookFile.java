package com.yedam.edu.book.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BookFile {
	private int fileNo;
	private String bookCode;
	private String bookImage;
	private String bookPath;
}
