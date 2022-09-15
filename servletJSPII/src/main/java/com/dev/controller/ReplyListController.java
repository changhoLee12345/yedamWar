package com.dev.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.common.Controller;
import com.dev.common.HttpUtil;
import com.dev.service.BoardService;
import com.dev.vo.BoardVO;
import com.dev.vo.ReplyVO;

public class ReplyListController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		BoardService service = BoardService.getInstance();
		List<BoardVO> list = service.getBoardReplyList("user1");
		request.setAttribute("boardReplyList", list);
		for (BoardVO board : list) {
			for (ReplyVO reply : board.getReplyList()) {
				System.out.println(reply.toString());
			}
		}

		HttpUtil.forward(request, response, "board/boardList.tiles");

	}

}
