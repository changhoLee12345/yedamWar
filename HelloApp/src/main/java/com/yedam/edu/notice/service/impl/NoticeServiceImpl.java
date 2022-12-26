package com.yedam.edu.notice.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.edu.common.Criteria;
import com.yedam.edu.common.DataSource;
import com.yedam.edu.common.PageDTO;
import com.yedam.edu.common.SearchVO;
import com.yedam.edu.notice.mapper.NoticeMapper;
import com.yedam.edu.notice.service.NoticeService;
import com.yedam.edu.notice.vo.NoticeVO;

public class NoticeServiceImpl implements NoticeService {
	SqlSession session = DataSource.getInstance().openSession(true); // SqlSession 을 통해 쿼리.
	NoticeMapper mapper = session.getMapper(NoticeMapper.class);

	@Override
	public List<NoticeVO> noticeList() {
		return mapper.noticeList();
	}

	@Override
	public int searchNoticePagingCnt(Criteria cri) {
		return mapper.searchNoticePagingCnt(cri);
	}

	@Override
	public List<NoticeVO> searchNoticePagingList(Criteria cri) {
		return mapper.searchNoticePagingList(cri);
	}

	@Override
	public int insertNotice(NoticeVO vo) {
		return mapper.insertNotice(vo);
	}

	@Override
	public int updateNotice(NoticeVO vo) {
		return mapper.updateNotice(vo);
	}

	@Override
	public int deleteNotice(int id) {
		return mapper.deleteNotice(id);
	}

	@Override
	public NoticeVO searchNotice(int id) {
		return mapper.searchNotice(id);
	}

	@Override
	public int noticePagingCnt(NoticeVO vo) {
		return mapper.noticePagingCnt(vo);
	}

	@Override
	public List<NoticeVO> noticeListPaging(NoticeVO vo) {
		return mapper.noticeListPaging(vo);
	}

}
