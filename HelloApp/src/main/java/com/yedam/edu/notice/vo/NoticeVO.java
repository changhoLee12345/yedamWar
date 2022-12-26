package com.yedam.edu.notice.vo;

import java.sql.Date;

import com.yedam.edu.common.Criteria;
import com.yedam.edu.common.SearchVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class NoticeVO {
	private int noticeId;
	private String noticeWriter;
	private String noticeTitle;
	private String noticeSubject;
	private Date noticeDate;
	private int hitCount;
	private String attachFile;
	private String attachDir;

//	private Criteria cri;
}
