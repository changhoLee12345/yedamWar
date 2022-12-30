package com.yedam.edu.member.mapper;

import java.util.List;

import com.yedam.edu.member.vo.MemberVO;

public interface MemberMapper {

	public List<MemberVO> memberList();
	public MemberVO loginCheck(MemberVO vo);
}
