package com.yedam.edu.notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.edu.common.Command;
import com.yedam.edu.common.Criteria;
import com.yedam.edu.notice.service.NoticeService;
import com.yedam.edu.notice.service.impl.NoticeServiceImpl;
import com.yedam.edu.notice.vo.NoticeVO;

public class NoticeSearch implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String num = request.getParameter("num");
		num = num == null ? "1" : num;

		String searchCondition = request.getParameter("searchCondition");
		String keyword = request.getParameter("keyword");
		String pageNum = request.getParameter("pageNum");
		String cntPage = request.getParameter("amount");
		int pageNumInt = Integer.parseInt(pageNum);
		int cntPageInt = Integer.parseInt(cntPage);

		Criteria cri = new Criteria(pageNumInt, cntPageInt);
		cri.setSearchCondition(searchCondition);
		cri.setKeyWord(keyword);

		NoticeService service = new NoticeServiceImpl();
		NoticeVO vo = service.searchNotice(Integer.parseInt(num));

		request.setAttribute("vo", vo);
		request.setAttribute("criInfo", cri);

		return "notice/searchNotice.tiles";
	}

}
