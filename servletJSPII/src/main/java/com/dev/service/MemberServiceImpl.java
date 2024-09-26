package com.dev.service;

import java.util.List;

import com.dev.dao.MemberAction;
import com.dev.dao.MemberMybatis;
import com.dev.vo.MemberVO;

public class MemberServiceImpl implements MemberService {

//	MemberDAO dao = MemberDAO.getInstance();
	MemberAction action = MemberMybatis.getInstance();

	private static MemberServiceImpl service = new MemberServiceImpl();

	private MemberServiceImpl() {
		System.out.println("MemberServiceImpl");
	}

	public static MemberServiceImpl getInstance() {
		return service;
	}

	// login
	public MemberVO login(MemberVO vo) {
		return action.selectMember(null);
	}

	// 리스트
	public List<MemberVO> memberList() {
		System.out.println("memberList()");
		return action.selectList(null);
	}

	// 단건조회
	@Override
	public MemberVO getMember(String id) {
		return action.selectMember(id);
	}

	// 입력
	@Override
	public boolean addMember(MemberVO member) {
		return action.memberInsert(member) == 1;
	}

	// 수정
	@Override
	public boolean modifyMember(MemberVO member) {
		return action.memberUpdate(member) == 1;
	}

	// 삭제
	@Override
	public boolean removeMember(String id) {
		return action.memberDelete(id) == 1;
	}

}
