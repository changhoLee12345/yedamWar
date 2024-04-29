package co.yedam.service;

import java.util.List;

import co.yedam.vo.CartVO;
import co.yedam.vo.MemberVO;

public interface MemberService {
	public MemberVO loginCheck(MemberVO mvo);

	public boolean addMember(MemberVO mvo);

	public List<MemberVO> memberList();

	public boolean removeMember(String mid);

	// 상품목록.

	// 카트관련.
	public List<CartVO> cartList();
	public boolean modifyCart(CartVO cvo);
	public boolean removeCart(int no);

}
