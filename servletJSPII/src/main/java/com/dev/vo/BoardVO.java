package com.dev.vo;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class BoardVO {
	private int bno;
	private String title;
	private String content;
	private String writer;
	private Date createDate;
	private int clickCnt;

	private List<ReplyVO> replyList;
}
