package co.yedam.service;

import java.util.List;

import co.yedam.vo.Reply;
import co.yedam.vo.SearchVO;

public interface ReplyService {
	List<Reply> selectList(SearchVO search);
	int replyCount(int bno);
}
