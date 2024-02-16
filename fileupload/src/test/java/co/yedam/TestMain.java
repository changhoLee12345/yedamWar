package co.yedam;

import co.yedam.service.EmpService;
import co.yedam.service.EmpServiceImpl;
import co.yedam.vo.SearchVO;

public class TestMain {
	public static void main(String[] args) {

		SearchVO search = new SearchVO();
		int page = 4;
		search.setDepartment("인사");
		search.setPage(page);
		empTest(search);

	}
	
	static void boardTest(SearchVO search) {
		
	}

	static void empTest(SearchVO search) {
		EmpService svc = new EmpServiceImpl();
		System.out.println(" 사번     이름     연락처       부서   급여\n------------------------------------");
		svc.empListPaging(search).forEach(emp -> {
			System.out.printf(emp.showList(), emp.getEmpNo(), emp.getEmpName(), emp.getPhone(), emp.getDepartment(),
					emp.getSalary());
		});
		System.out.println("----------------(" + search.getPage() + ")-----------------");

	}
}
