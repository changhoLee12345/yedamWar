package com.yedam.edu.notice.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.edu.common.Command;
import com.yedam.edu.common.Criteria;
import com.yedam.edu.common.PageDTO;
import com.yedam.edu.notice.service.NoticeService;
import com.yedam.edu.notice.service.impl.NoticeServiceImpl;
import com.yedam.edu.notice.vo.NoticeVO;

public class NoticeList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String currPage = request.getParameter("page");
		currPage = currPage == null ? "1" : currPage;

		int pageInt = Integer.parseInt(currPage);

		NoticeVO vo = new NoticeVO();
		Criteria cri = new Criteria(pageInt, 10);
		int total = 0;
		vo.setCri(cri);

		NoticeService service = new NoticeServiceImpl();
		List<NoticeVO> list = service.noticeListPaging(vo);

		total = service.noticePagingCnt(vo);
		PageDTO page = new PageDTO(cri, total);

		request.setAttribute("list", list);
		request.setAttribute("pageInfo", page);

		return "notice/noticeList.tiles";
	}

}
