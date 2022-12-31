package com.yedam.edu.member.service.impl;

import java.util.List;
import java.util.Map;

import com.yedam.edu.member.dao.MemberDAO;
import com.yedam.edu.member.service.MemberService;
import com.yedam.edu.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {

	// jdbc 활용.
	MemberDAO dao = MemberDAO.getInstance();

	@Override
	public List<MemberVO> memberList() {
		// 회원목록 반환.
		return dao.memberList();
	}

	@Override
	public MemberVO loginCheck(MemberVO vo) {
		return dao.loginCheck(vo);
	}

	@Override
	public MemberVO searchMember(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertCenterInfo(List<Map<String, Object>> list) {
		// TODO Auto-generated method stub
		return dao.insertCenterInfo(list);
	}

}
