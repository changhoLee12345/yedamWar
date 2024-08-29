package co.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.common.SearchVO;
import co.yedam.mapper.BoardMapper;
import co.yedam.vo.BoardVO;

public class BoardServiceImpl implements BoardService {

	SqlSession session = DataSource.getInstance()//
			.openSession(true);

	BoardMapper mapper = session.getMapper(BoardMapper.class);

	@Override
	public List<BoardVO> boardList(SearchVO search) {
		System.out.println(search);
		return mapper.selectList(search);
	}

	@Override
	public int getCount(SearchVO search) {
		return mapper.selectCount(search);
	}

	@Override
	public BoardVO getBoard(int bno) {
		return mapper.getBoard(bno);
	}

	@Override
	public boolean addBoard(BoardVO vo) {
		return mapper.insertBoard(vo) == 1;
	}

	@Override
	public boolean modifyBoard(BoardVO vo) {
		return mapper.updateBoard(vo) == 1;
	}

	@Override
	public boolean removeBoard(int bno) {
		return mapper.deleteBoard(bno) == 1;
	}

	@Override
	public boolean addViewCnt(int bno) {
		return mapper.updateCnt(bno) == 1;
	}
}
