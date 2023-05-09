package com.yedam.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Command;
import com.yedam.domain.EmpVO;
import com.yedam.service.EmpService;
import com.yedam.service.EmpServiceImpl;

public class MainCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		EmpService service = new EmpServiceImpl();
		List<EmpVO> list = service.empList();
		System.out.println(list);

		return "main.jsp";
	}

}
