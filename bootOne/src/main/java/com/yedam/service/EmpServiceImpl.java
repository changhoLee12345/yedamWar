package com.yedam.service;

import java.util.List;

import com.yedam.common.DataSource;
import com.yedam.domain.EmpVO;
import com.yedam.mapper.EmpMapper;

public class EmpServiceImpl implements EmpService {

	EmpMapper mapper = DataSource.getInstance().openSession().getMapper(EmpMapper.class);

	@Override
	public List<EmpVO> empList() {
		return mapper.empList();
	}

}
