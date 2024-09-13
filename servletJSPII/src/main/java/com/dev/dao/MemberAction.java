package com.dev.dao;

import java.util.List;

import com.dev.common.SearchDTO;
import com.dev.vo.MemberVO;

public interface MemberAction {

	int memberInsert(MemberVO member);

	int memberUpdate(MemberVO member);

	int memberDelete(String id);

	List<MemberVO> selectList(SearchDTO search);

	MemberVO selectMember(String id);
}
