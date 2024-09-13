package com.dev.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.dev.common.DAO;
import com.dev.common.SearchDTO;
import com.dev.vo.BoardVO;
import com.dev.vo.ReplyVO;

public class BoardJdbc extends DAO implements BoardAction {

	public List<Map<String, Object>> getReplyMapList(int bno) {
		return null;
	}

	public List<ReplyVO> getReplyList(int bno) {
		connect();
		List<ReplyVO> replyList = new ArrayList<>();
		String sql = "select * from tbl_reply where bno = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, bno);
			rs = psmt.executeQuery();
			while (rs.next()) {
				ReplyVO vo = new ReplyVO();
				vo.setRno(rs.getInt("reply_no"));
				vo.setBno(rs.getInt("bno"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setCreateDate(rs.getDate("create_date"));
				replyList.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return replyList;
	}

	@Override
	public List<BoardVO> boardList(SearchDTO search) {
		connect();
		List<BoardVO> boardList = new ArrayList<>();
		String sql = "select * from tbl_board where id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, search.getWriter());
			rs = psmt.executeQuery();
			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBoardNo(rs.getInt("board_no"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setWriteDate(rs.getDate("write_date"));
				vo.setClickCnt(rs.getInt("click_cnt"));

				boardList.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return boardList;
	}

	@Override
	public BoardVO getBoard(int bno) {
		return null;
	}

	@Override
	public boolean addBoard(BoardVO board) {
		return false;
	}

	@Override
	public boolean modifyBoard(BoardVO board) {
		return false;
	}

	@Override
	public boolean removeBoard(int bno) {
		return false;
	}
}
