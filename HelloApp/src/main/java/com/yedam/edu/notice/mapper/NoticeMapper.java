package com.yedam.edu.notice.mapper;

import java.util.List;

import com.yedam.edu.notice.vo.NoticeVO;

public interface NoticeMapper {

	public List<NoticeVO> noticeList(); // 전체데이터.

	public int searchNoticeCnt(NoticeVO vo);

	public List<NoticeVO> searchNoticeList(NoticeVO vo); // 조건데이터.

	public NoticeVO searchNotice(int id);

	public int insertNotice(NoticeVO vo);

	public int updateNotice(NoticeVO vo);

	public int deleteNotice(int id);

	// paging.
	public int noticePagingCnt(NoticeVO vo);

	public List<NoticeVO> noticeListPaging(NoticeVO vo);

}
