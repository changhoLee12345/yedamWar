package com.yedam.edu.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	private int pageNum;
	private int cntPerPage;

	public Criteria() {
		this.pageNum = 1;
		this.cntPerPage = 10;
	}

	public Criteria(int pageNum, int cntPerPage) {
		this.pageNum = pageNum;
		this.cntPerPage = cntPerPage;
	}
}
