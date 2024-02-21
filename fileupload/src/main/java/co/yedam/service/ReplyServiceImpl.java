package co.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.mapper.ReplyMapper;
import co.yedam.vo.Reply;
import co.yedam.vo.SearchVO;

public class ReplyServiceImpl implements ReplyService {

	SqlSession sqlSession = DataSource.getInstance().openSession();
	ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);

	@Override
	public List<Reply> selectList(SearchVO search) {
		return mapper.selectList(search);
	}

	@Override
	public int replyCount(int bno) {
		return mapper.replyCount(bno);
	}

}
