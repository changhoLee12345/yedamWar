package com.yedam.edu;

import java.util.List;

import com.yedam.edu.common.Criteria;
import com.yedam.edu.common.PageDTO;
import com.yedam.edu.notice.service.NoticeService;
import com.yedam.edu.notice.service.impl.NoticeServiceImpl;
import com.yedam.edu.notice.vo.NoticeVO;

public class MainApp {

	public static void main(String[] args) {

		System.out.println("start");

		Criteria cri;
		NoticeVO vo;
		PageDTO paging;
		List<NoticeVO> list;
		int totalCnt;

		NoticeService service = new NoticeServiceImpl();

		cri = new Criteria(3, 10);

		vo = new NoticeVO();
//		vo.setNoticeWriter("writer998");
//		vo.setNoticeTitle("title998");
//		vo.setNoticeSubject("subject999");
//		vo.setNoticeId(1);

		vo.setCri(cri);
		vo.setSearchCondition("subject");
		vo.setKeyWord("subject1");

//		service.updateNotice(vo);
//		vo = service.searchNotice(1);
//		System.out.println(vo);
		list = service.searchNoticeList(vo);
		for (NoticeVO nvo : list) {
			System.out.println(nvo);
		}
		totalCnt = service.searchNoticeCnt(vo);

		paging = new PageDTO(cri, totalCnt);
		System.out.println(paging);

		System.out.println("end");
	}

}
