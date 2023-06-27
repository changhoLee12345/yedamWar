package com.yedam.edu.member.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.edu.member.vo.MemberVO;
import com.yedam.edu.member.vo.SaleOrderInfo;
import com.yedam.edu.member.vo.SalesParamVO;

public interface MemberMapper {

	public List<MemberVO> memberList();
	public MemberVO loginCheck(MemberVO vo);
	public MemberVO searchMember(String id);
	public int insertMember(MemberVO vo);
	public int deleteMember(String id);
	public int updateMember(MemberVO vo);

	public int insertCenterInfo(List<Map<String, Object>> list);

	// 주문번호 생성.
	public String createSalesNo();

	// 주문정보 생성.
	public int createSalesLines(SalesParamVO vo);

	// 주문합계 생성.
	public int createSalesInfo(String salesNo);

	// 주문상세 정보.
	public List<SaleOrderInfo> selectSales(String salesNo);
}
