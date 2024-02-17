package co.yedam.vo;

import lombok.Data;

@Data
public class SearchVO {
	private String department;
	private int page = 1;
	private String writer;
	private String title;
}
