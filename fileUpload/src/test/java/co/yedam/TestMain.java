package co.yedam;

import java.text.SimpleDateFormat;
import java.util.List;

import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.service.EmpService;
import co.yedam.service.EmpServiceImpl;
import co.yedam.service.ReplyService;
import co.yedam.service.ReplyServiceImpl;
import co.yedam.vo.Reply;
import co.yedam.vo.SearchVO;

public class TestMain {
	public static void main(String[] args) {

		SearchVO search = new SearchVO();
//		int page = 4;
//		search.setDepartment("인사");
//		search.setPage(page);
//		boardTest(search);
		search.setBno(157);
		search.setRpage(3);
		replyTest(search);

	}
	
	static void replyTest(SearchVO search) {
		ReplyService svc = new ReplyServiceImpl();
		List<Reply> list = svc.selectList(search);
		
		list.forEach(reply -> System.out.println(reply));
	}

	static void boardTest(SearchVO search) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		BoardService svc = new BoardServiceImpl();
		System.out.println("---------------------------------------------------");
		System.out.println("게시글번호    제목           작성자    조회수      작성일시\n---------------------------------------------------");
		svc.boardList(search).forEach(board -> {
			System.out.printf(board.showList(), board.getBoardNo(), board.getTitle(), board.getWriter(),
					board.getViewCnt(), sdf.format(board.getCreateDate()));
		});
		System.out.println("-----------------------(" + search.getPage() + ")-------------------------");
	}

	static void empTest(SearchVO search) {
		EmpService svc = new EmpServiceImpl();
		System.out.println(" 사번     이름     연락처       부서   급여\n------------------------------------");
		svc.empListPaging(search).forEach(emp -> {
			System.out.printf(emp.showList(), emp.getEmpNo(), emp.getEmpName(), emp.getPhone(), emp.getDepartment(),
					emp.getSalary());
		});
		System.out.println("----------------(" + search.getPage() + ")-------------------");

	}
}
