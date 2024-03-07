package co.yedam.member.mapper;

import java.util.List;

import co.yedam.common.Center;
import co.yedam.member.Member;

public interface MemberMapper {
	Member selectMember(Member member);
	int insertMember(Member member);
	int insertCenter(List<Center> list);
	int insertCenterAry(Center[] array);
	int deleteCenter(List<Center> list);
	int deleteCenterAry(Center[] list);
}
