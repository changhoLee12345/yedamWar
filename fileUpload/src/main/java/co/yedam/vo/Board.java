package co.yedam.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private int viewCnt;
	private Date createDate;
	private Date updateDate;

	public String showList() {
		// 게시글번호 제목 작성자 조회수 작성일시
		return "%5d   %-10s %10s %5d %15s\n";
	}
}
