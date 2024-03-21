package co.yedam.mapper;

import java.util.List;

import co.yedam.vo.Employee;
import co.yedam.vo.Member;
import co.yedam.vo.SearchVO;

public interface EmpMapper {
	List<Employee> selectList(String department);
	List<Employee> selectListPaging(SearchVO search);

	// 로그인/로그아웃...
	Member selectMember(SearchVO search);
}
