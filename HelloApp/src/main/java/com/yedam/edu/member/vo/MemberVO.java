package com.yedam.edu.member.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberVO {
	private String id;
	private String passwd;
	private String name;
	private String email;
	private String responsibility;
	private String pfilename;
	private String ofilename;
	private Date cdate;
}
