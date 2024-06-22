package co.yedam.member.service;

import co.yedam.common.Center;
import co.yedam.member.Member;

public interface MemberService {
	Member loginCheck(Member member);
	boolean addMember(Member member);
	int addCenter(Center[] ary);
	int delCenter(Center[] ary);
}
