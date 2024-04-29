package co.yedam.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.common.SearchVO;
import co.yedam.mapper.ReplyMapper;
import co.yedam.vo.ReplyVO;

public class ReplyServiceImpl implements ReplyService {

	SqlSession session = DataSource.getInstance()//
			.openSession(true);

	ReplyMapper mapper = session.getMapper(ReplyMapper.class);

	@Override
	public List<ReplyVO> replyList(SearchVO search) {
		return mapper.replyListNoPage(search);
	}

	@Override
	public boolean removeReply(int rno) {
		return mapper.deleteReply(rno) == 1;
	}

	@Override
	public int getReplyCount(int bno) {
		return mapper.selectReplyCount(bno);
	}

	@Override
	public boolean addReply(ReplyVO rvo) {
		return mapper.insertReply(rvo) == 1;
	}

	@Override
	public List<Map<String, Object>> getCntByMember() {
		return mapper.selectCntByMember();
	}

}
