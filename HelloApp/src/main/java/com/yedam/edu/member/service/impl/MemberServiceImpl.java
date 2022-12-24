package com.yedam.edu.member.service.impl;

import java.util.List;

import com.yedam.edu.member.dao.MemberDAO;
import com.yedam.edu.member.service.MemberService;
import com.yedam.edu.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {

	MemberDAO dao = MemberDAO.getInstance();

	@Override
	public List<MemberVO> memberList() {
		// 회원목록 반환.
		return dao.memberList();
	}

}
