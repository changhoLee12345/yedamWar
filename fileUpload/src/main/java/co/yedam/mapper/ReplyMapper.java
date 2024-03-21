package co.yedam.mapper;

import java.util.List;

import co.yedam.vo.Reply;
import co.yedam.vo.SearchVO;

public interface ReplyMapper {
	List<Reply> selectList(SearchVO search);
	int replyCount(int bno);
}
