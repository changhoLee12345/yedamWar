package com.yedam.edu.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria extends SearchVO {
	private int pageNum;
	private int amount;

	public Criteria() {
		this.pageNum = 1;
		this.amount = 10;
	}

	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
}
