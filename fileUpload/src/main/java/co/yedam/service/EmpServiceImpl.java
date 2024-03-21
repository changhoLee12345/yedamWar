package co.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

import co.yedam.common.DataSource;
import co.yedam.mapper.EmpMapper;
import co.yedam.vo.Employee;
import co.yedam.vo.Member;
import co.yedam.vo.SearchVO;

public class EmpServiceImpl implements EmpService {

	SqlSessionFactory sessionFactory = DataSource.getInstance();

	EmpMapper mapper = sessionFactory.openSession(false).getMapper(EmpMapper.class);

	@Override
	public List<Employee> empList(String department) {
		return mapper.selectList(department);
	}

	@Override
	public List<Employee> empListPaging(SearchVO search) {
		return mapper.selectListPaging(search);
	}

	@Override
	public Member login(SearchVO search) {
		return mapper.selectMember(search);
	}

}
