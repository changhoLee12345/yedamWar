package co.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

import co.yedam.common.DataSource;
import co.yedam.mapper.BoardMapper;
import co.yedam.vo.Board;
import co.yedam.vo.SearchVO;

public class BoardServiceImpl implements BoardService {
	SqlSessionFactory sessionFactory = DataSource.getInstance();

	BoardMapper mapper = sessionFactory.openSession(false).getMapper(BoardMapper.class);

	@Override
	public List<Board> boardList(SearchVO search) {
		return mapper.selectListPaging2(search);
	}

	@Override
	public int totalCnt(SearchVO search) {
		return mapper.selectTotal(search);
	}

	@Override
	public Board getBoard(SearchVO search) {
		return mapper.selectBoard(search);
	}

}
