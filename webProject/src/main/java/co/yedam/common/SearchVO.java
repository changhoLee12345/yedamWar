package co.yedam.common;

import lombok.Data;

@Data
public class SearchVO {
	// page, searchCondition, keyword
	private int page;
	private String searchCondition;
	private String keyword;
	
	// 댓글관련.
	private int rpage;
	private int bno;
}
