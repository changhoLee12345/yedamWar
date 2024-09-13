package com.dev.common;

import lombok.Data;

@Data
public class SearchDTO {
	private String searchCondition;
	private String keyword;
	private int page;

	private String writer;// 작성자.

}
