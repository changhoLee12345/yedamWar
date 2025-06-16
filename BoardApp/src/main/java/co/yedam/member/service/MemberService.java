package co.yedam.member.service;

import java.util.List;
import java.util.Map;

import co.yedam.member.vo.Member;

public interface MemberService {
	Member loginCheck(Member member);
	boolean addMember(Member member);
	
	// chat 
	boolean addMessage(String message);
	List<Map<String, Object>> messageList(String ts);
}
