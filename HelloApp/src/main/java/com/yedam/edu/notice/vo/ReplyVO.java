package com.yedam.edu.notice.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {
	private int replyNo;
	private int bno;
	private String content;
	private String writer;
	private Date createDate;
}
