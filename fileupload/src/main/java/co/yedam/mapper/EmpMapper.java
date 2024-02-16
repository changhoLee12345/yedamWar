package co.yedam.mapper;

import java.util.List;

import co.yedam.vo.Employee;
import co.yedam.vo.SearchVO;

public interface EmpMapper {
	List<Employee> selectList(String department);
	List<Employee> selectListPaging(SearchVO search);
}
