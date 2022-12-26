package com.yedam.edu.notice.service;

import java.util.List;

import com.yedam.edu.common.Criteria;
import com.yedam.edu.common.PageDTO;
import com.yedam.edu.common.SearchVO;
import com.yedam.edu.notice.vo.NoticeVO;

public interface NoticeService {

	public List<NoticeVO> noticeList();

	public int searchNoticePagingCnt(Criteria cri);

	public List<NoticeVO> searchNoticePagingList(Criteria cri); // 조건데이터.

	public NoticeVO searchNotice(int id);

	public int insertNotice(NoticeVO vo);

	public int updateNotice(NoticeVO vo);

	public int deleteNotice(int id);

	// paging.
	public int noticePagingCnt(NoticeVO vo);

	public List<NoticeVO> noticeListPaging(NoticeVO vo);

}
