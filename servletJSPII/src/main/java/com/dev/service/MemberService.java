package com.dev.service;

import java.util.List;

import com.dev.vo.MemberVO;

public interface MemberService {
	List<MemberVO> memberList();
	MemberVO getMember(String id);
	boolean addMember(MemberVO member);
	boolean modifyMember(MemberVO member);
	boolean removeMember(String id);
}
