package com.yedam.edu.main.command;

import java.util.ArrayList;
import java.util.List;

import com.yedam.edu.member.service.MemberService;
import com.yedam.edu.member.service.impl.MemberServiceMybatis;
import com.yedam.edu.member.vo.SaleOrderInfo;

public class MainExe {
	public static void main(String[] args) {
		// collection 을 활용해서 mapper 를 활용.
		List<String> slist = new ArrayList<>();

		MemberService service = new MemberServiceMybatis();

		slist.add("1");
		slist.add("3");
		slist.add("5");

		String saleNo = service.createSalesInfo(slist);

		for (SaleOrderInfo info : service.getSaleInfos(saleNo)) {
			System.out.println(info);
		}

	}
}
