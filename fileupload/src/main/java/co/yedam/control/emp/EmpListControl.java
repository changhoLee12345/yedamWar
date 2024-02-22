package co.yedam.control.emp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.EmpService;
import co.yedam.service.EmpServiceImpl;
import co.yedam.vo.Employee;
import co.yedam.vo.SearchVO;

public class EmpListControl implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String dept = request.getParameter("dept");
		String page = request.getParameter("page");
		page = page == null ? "1" : page;

		EmpService svc = new EmpServiceImpl();
		SearchVO search = new SearchVO();
		search.setDepartment(dept);
		search.setPage(Integer.parseInt(page));
		List<Employee> list = svc.empListPaging(search);

		String path = "WEB-INF/view/empList.jsp";
		request.setAttribute("list", list);

		request.getRequestDispatcher(path).forward(request, response);
	}

}
