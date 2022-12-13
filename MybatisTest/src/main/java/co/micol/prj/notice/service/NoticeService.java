package co.micol.prj.notice.service;

import java.util.List;

import co.micol.prj.notice.vo.NoticeVO;

public interface NoticeService {
	// 전체공지사항, 한건조회, 한건입력, 수정, 삭제
	List<NoticeVO> noticeList();
	NoticeVO noticeSelect(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
}
