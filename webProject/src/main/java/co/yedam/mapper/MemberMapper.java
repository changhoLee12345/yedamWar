package co.yedam.mapper;

import java.util.List;

import co.yedam.vo.CartVO;
import co.yedam.vo.MemberVO;

public interface MemberMapper {
	public MemberVO selectMember(MemberVO mvo);
	public int insertMember(MemberVO mvo);
	public List<MemberVO> selectMembers();
	public int deleteMember(String mid);
	// 상품목록.
	
	// 카트관련.
	public List<CartVO> selectList();
	public int updateCart(CartVO cvo);
	public int deleteCart(int no);
}
