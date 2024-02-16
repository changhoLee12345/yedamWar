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
}
