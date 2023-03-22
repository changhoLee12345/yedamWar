package com.yedam.edu.notice.command;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.edu.common.Command;
import com.yedam.edu.common.Criteria;
import com.yedam.edu.common.PageDTO;
import com.yedam.edu.notice.service.NoticeService;
import com.yedam.edu.notice.service.impl.NoticeServiceImpl;
import com.yedam.edu.notice.vo.NoticeVO;

public class UpdateNotice implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String searchCondition = request.getParameter("searchCondition");
		String keyword = request.getParameter("keyword");
		String pageNum = request.getParameter("pageNum");
		String cntPage = request.getParameter("amount");
		String nDate = request.getParameter("ndate");
		if(nDate == null || nDate.equals("")) {
			nDate = "2023-05-05 13:34:33";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date noticeDate = null;
		try {
			noticeDate = sdf.parse(nDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int pageNumInt = Integer.parseInt(pageNum);
		int cntPageInt = Integer.parseInt(cntPage);

		String num = request.getParameter("num");
		num = num == null ? "1" : num;
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String subject = request.getParameter("subject");

		Criteria cri = new Criteria(pageNumInt, cntPageInt);
		cri.setSearchCondition(searchCondition);
		cri.setKeyWord(keyword);

		NoticeVO vo = new NoticeVO();
		vo.setNoticeId(Integer.parseInt(num));
		vo.setNoticeWriter(writer);
		vo.setNoticeTitle(title);
		vo.setNoticeSubject(subject);
		vo.setNoticeDate(noticeDate);

		System.out.println(vo);

		NoticeService service = new NoticeServiceImpl();
		service.updateNotice(vo);

		int total = service.searchNoticePagingCnt(cri);
		List<NoticeVO> list = service.searchNoticePagingList(cri);

		PageDTO page = new PageDTO(cri, total);

		// 필요한 정보 전송.
		request.setAttribute("list", list);
		request.setAttribute("pageInfo", page);
		request.setAttribute("criInfo", cri);

		return "notice/noticeList.tiles";
	}

}
