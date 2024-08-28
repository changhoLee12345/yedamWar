package co.yedam.vo;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {
	private String memberId;
	private String memberPw;
	private String memberNm;
	private String responsibility;
	private Date createDate;
	private String phone;
}
