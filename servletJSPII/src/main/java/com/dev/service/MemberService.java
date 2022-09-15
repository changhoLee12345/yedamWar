package com.dev.service;

import java.util.List;

import com.dev.dao.MemberDAO;
import com.dev.dao.MemberMybatisDAO;
import com.dev.vo.MemberVO;

public class MemberService {

	private static MemberService service = new MemberService();
//	MemberDAO dao = MemberDAO.getInstance();
	MemberMybatisDAO dao = MemberMybatisDAO.getInstance();

	private MemberService() {

	}

	public static MemberService getInstance() {
		return service;
	}

	// 리스트
	public List<MemberVO> memberList() {
		return dao.memberList();
	}

	// 단건조회
	public MemberVO memberSearch(String id) {
		MemberVO member = dao.memberSearch(id);
		return member;
	}

	// 입력
	public void memberInsert(MemberVO member) {
		dao.memberInsert(member);
	}

	// 수정
	public void memberUpdate(MemberVO member) {
		dao.memberUpdate(member);
	}

	// 삭제
	public void memberDelete(String id) {
		dao.memberDelete(id);
	}

}
