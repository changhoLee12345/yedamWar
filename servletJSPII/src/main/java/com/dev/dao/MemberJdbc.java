package com.dev.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dev.common.DAO;
import com.dev.common.SearchDTO;
import com.dev.vo.MemberVO;

public class MemberJdbc extends DAO implements MemberAction {

	private static MemberJdbc instance = new MemberJdbc();

	private MemberJdbc() {
	}

	public static MemberJdbc getInstance() {
		return instance;
	}

	@Override
	public List<MemberVO> selectList(SearchDTO search) {
		conn = connect();
		String sql = "select id, name, passwd, email " //
				+ "from member "//
				+ "where 1 = 1 "//
				+ "order by 1";
		List<MemberVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				MemberVO member = new MemberVO();
				member.setId(rs.getString("id"));
				member.setEmail(rs.getString("email"));
				member.setName(rs.getString("name"));
				member.setPasswd(rs.getString("passwd"));
				list.add(member);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return list;
	}

	// 조회
	@Override
	public MemberVO selectMember(String id) {
		conn = connect();
		String sql = "select * from member where id = ?";
		MemberVO member = new MemberVO();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				member.setId(rs.getString("id"));
				member.setEmail(rs.getString("mail"));
				member.setName(rs.getString("name"));
				member.setPasswd(rs.getString("passwd"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return member;
	}

	// 입력
	@Override
	public int memberInsert(MemberVO member) {
		connect();
		String sql = "insert into member(id, name, passwd, mail) values(?,?,?,?)";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getName());
			psmt.setString(3, member.getPasswd());
			psmt.setString(4, member.getEmail());

			int r = psmt.executeUpdate();
			if (r > 0)
				return r;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return 0;
	}

	// 수정
	public int memberUpdate(MemberVO member) {
		conn = connect();
		String sql = "update member set passwd=?, name=?, mail=? where id=?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getPasswd());
			psmt.setString(2, member.getName());
			psmt.setString(3, member.getEmail());
			psmt.setString(4, member.getId());
			int r = psmt.executeUpdate();
			if (r > 0)
				return r;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return 0;
	}

	// 삭제
	@Override
	public int memberDelete(String id) {
		conn = connect();
		String sql = "delete from member where id=?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			int r = psmt.executeUpdate();
			if (r > 0)
				return r;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return 0;
	}

}
