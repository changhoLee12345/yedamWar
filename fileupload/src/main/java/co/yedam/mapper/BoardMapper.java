package co.yedam.mapper;

import java.util.List;

import co.yedam.vo.Board;
import co.yedam.vo.SearchVO;

public interface BoardMapper { 
	List<Board> selectListPaging(SearchVO search);
}
