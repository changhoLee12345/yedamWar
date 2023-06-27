package com.yedam.edu.member.service;

import java.util.List;
import java.util.Map;

import com.yedam.edu.member.vo.MemberVO;
import com.yedam.edu.member.vo.SaleOrderInfo;

public interface MemberService {

	public List<MemberVO> memberList();
	public MemberVO loginCheck(MemberVO vo);
	public MemberVO searchMember(String id);
	public int insertMember(MemberVO vo);
	public int deleteMember(String id);
	public int modifyMember(MemberVO vo);

	// center info 반복등록.
	public int insertCenterInfo(List<Map<String, Object>> list);

	// 주문정보생성. String createSalesInfo(String[] carts)
	// 주문번호 생성 -> 주문상세&주문합계 -> 주문번호 반환.
	public String createSalesInfo(List<String> carts);
	public List<SaleOrderInfo> getSaleInfos(String saleNo);
}
