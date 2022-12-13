package co.micol.prj.notice.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.micol.prj.common.DataSource;
import co.micol.prj.notice.mapper.NoticeMapper;
import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.vo.NoticeVO;

public class NoticeServiceImpl implements NoticeService {

	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);

	@Override
	public List<NoticeVO> noticeList() {
		return mapper.noticeList();
	}

	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		return mapper.noticeSelect(vo);
	}

	@Override
	public int noticeInsert(NoticeVO vo) {
		return mapper.noticeInsert(vo);
	}

	@Override
	public int noticeUpdate(NoticeVO vo) {
		return mapper.noticeUpdate(vo);
	}

	@Override
	public int noticeDelete(NoticeVO vo) {
		return mapper.noticeDelete(vo);
	}

}
