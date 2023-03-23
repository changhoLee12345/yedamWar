package com.yedam.edu.member.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.yedam.edu.common.DataSource;
import com.yedam.edu.member.mapper.MemberMapper;
import com.yedam.edu.member.service.MemberService;
import com.yedam.edu.member.vo.MemberVO;
import com.yedam.edu.member.vo.SalesParamVO;

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

	@Override
	public int insertMember(MemberVO vo) {
		return dao.insertMember(vo);
	}

	@Override
	public int deleteMember(String id) {
		return dao.deleteMember(id);
	}

	@Override
	public String createSalesInfo(List<String> carts) {
		String salesNo = dao.createSalesNo();
		System.out.println("salesNo: " + salesNo);

		int cnt = dao.createSalesInfo(salesNo);
		System.out.println("cnt: " + cnt);

		SalesParamVO vo = new SalesParamVO();
		vo.setSalesNo(salesNo);
		vo.setCartNos(carts);
		
		System.out.println(vo);

		int cnt2 = dao.createSalesLines(vo);
		System.out.println("cnt2: " + cnt2);

		return salesNo;
	}
}
