package com.yedam.edu.notice.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.edu.common.Command;
import com.yedam.edu.common.Criteria;
import com.yedam.edu.common.PageDTO;
import com.yedam.edu.common.SearchVO;
import com.yedam.edu.notice.service.NoticeService;
import com.yedam.edu.notice.service.impl.NoticeServiceImpl;
import com.yedam.edu.notice.vo.NoticeVO;

public class NoticeList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String searchCondition = request.getParameter("searchCondition");
		String keyword = request.getParameter("keyword");
		String criPage = request.getParameter("pageNum");
		String criCnt = request.getParameter("amount");
		criPage = criPage == null ? "1" : criPage;
		criCnt = criCnt == null ? "10" : criCnt;
		int criPageInt = Integer.parseInt(criPage);
		int criCntInt = Integer.parseInt(criCnt);
		int total = 0;

		Criteria cri = new Criteria(criPageInt, criCntInt);
		cri.setSearchCondition(searchCondition);
		cri.setKeyWord(keyword);

		NoticeService service = new NoticeServiceImpl();
		total = service.searchNoticePagingCnt(cri);
		List<NoticeVO> list = service.searchNoticePagingList(cri);

		PageDTO page = new PageDTO(cri, total);

		// 필요한 정보 전송.
		request.setAttribute("list", list);
		request.setAttribute("pageInfo", page);
		request.setAttribute("criInfo", cri);

		return "notice/noticeList.tiles";
	}

}
