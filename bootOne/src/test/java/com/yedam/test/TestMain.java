package com.yedam.test;

import java.util.List;

import com.yedam.domain.EmpVO;
import com.yedam.service.EmpService;
import com.yedam.service.EmpServiceImpl;

public class TestMain {
	public static void main(String[] args) {
		EmpService service = new EmpServiceImpl();
		List<EmpVO> list = service.empList();
		
		for(EmpVO vo : list) {
			System.out.println(vo.toString());
		}
	}
}
