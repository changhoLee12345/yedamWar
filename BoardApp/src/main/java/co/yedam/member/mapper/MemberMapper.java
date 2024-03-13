package co.yedam.member.mapper;

import java.util.List;
import java.util.Map;

import co.yedam.member.Member;

public interface MemberMapper {
	Member selectMember(Member member);
	int insertMember(Member member);

	int insertMessage(String message);
	List<Map<String, Object>> getMessages(String ts);
}
