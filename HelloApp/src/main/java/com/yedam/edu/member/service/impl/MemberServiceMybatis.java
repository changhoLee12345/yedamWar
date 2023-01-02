package com.yedam.edu.member.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.yedam.edu.common.DataSource;
import com.yedam.edu.member.mapper.MemberMapper;
import com.yedam.edu.member.service.MemberService;
import com.yedam.edu.member.vo.MemberVO;

public class MemberServiceMybatis implements MemberService {
	// mybatis 활용.
	SqlSession session = DataSource.getInstance().openSession(true);
	MemberMapper dao = session.getMapper(MemberMapper.class);

	@Override
	public List<MemberVO> memberList() {
		return dao.memberList();
	}

	@Override
	public MemberVO loginCheck(MemberVO vo) {
		return dao.loginCheck(vo);
	}

	@Override
	public MemberVO searchMember(String id) {
		return dao.searchMember(id);
	}

	@Override
	public int insertCenterInfo(List<Map<String, Object>> list) {
		return dao.insertCenterInfo(list);
	}

}
