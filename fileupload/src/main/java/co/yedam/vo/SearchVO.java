package co.yedam.vo;

import lombok.Data;

@Data
public class SearchVO {
	private String department;
	private int page = 1;
	private String writer;
	private String title;
	private String type; // T or W or TW
	private String keyword; //
	private int bno;
}
