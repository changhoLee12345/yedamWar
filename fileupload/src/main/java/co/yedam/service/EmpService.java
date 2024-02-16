package co.yedam.service;

import java.util.List;

import co.yedam.vo.Employee;
import co.yedam.vo.SearchVO;

public interface EmpService {
	List<Employee> empList(String department);
	List<Employee> empListPaging(SearchVO search);
}
