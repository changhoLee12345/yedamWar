package com.yedam.edu.main.command;

import java.util.ArrayList;
import java.util.List;

import com.yedam.edu.member.service.MemberService;
import com.yedam.edu.member.service.impl.MemberServiceMybatis;
import com.yedam.edu.member.vo.MemberVO;

public class MainExe {
	public static void main(String[] args) {
		// collection 을 활용해서 mapper 를 활용.
		List<String> slist = new ArrayList<>();

		MemberService service = new MemberServiceMybatis();
//		List<MemberVO> list = service.memberList();

//		for (MemberVO vo : list) {
//			System.out.println(vo);
//			slist.add(vo.getId());
//		}

		slist.add("1");
		slist.add("3");
		slist.add("5");

		service.createSalesInfo(slist);

	}
}
