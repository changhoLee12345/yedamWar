package com.yedam.edu.member.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.edu.member.vo.MemberVO;

public interface MemberMapper {

	public List<MemberVO> memberList();
	public MemberVO loginCheck(MemberVO vo);
	public MemberVO searchMember(String id);
	public int insertMember(MemberVO vo);
	public int deleteMember(String id);
	
	public int insertCenterInfo(List<Map<String, Object>> list);
}
