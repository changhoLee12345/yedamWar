package com.dev.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {
	private int rno;
	private int bno;
	private String content;
	private String writer;
	private Date createDate;
}
