package co.yedam.member.vo;

import lombok.Data;

@Data
public class Member {
	private String id;
	private String pw;
	private String name;
	private String auth;
	private String image;
}
