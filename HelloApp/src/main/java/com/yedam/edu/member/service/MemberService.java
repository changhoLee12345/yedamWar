package com.yedam.edu.member.service;

import java.util.List;

import com.yedam.edu.member.vo.MemberVO;

public interface MemberService {
	public List<MemberVO> memberList();
	public MemberVO loginCheck(MemberVO vo);
	public MemberVO searchMember(String id);
}
