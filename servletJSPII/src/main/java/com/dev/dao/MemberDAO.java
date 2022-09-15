package com.dev.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dev.common.DAO;
import com.dev.vo.MemberVO;

public class MemberDAO extends DAO {

	private static MemberDAO instance = new MemberDAO();

	private MemberDAO() {
	}

	public static MemberDAO getInstance() {
		return instance;
	}

	// 리스트
	public List<MemberVO> memberList() {
		conn = connect();
		String sql = "select id, name, passwd, mail from member order by 1";
		List<MemberVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				MemberVO member = new MemberVO();
				member.setId(rs.getString("id"));
				member.setMail(rs.getString("mail"));
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
	public MemberVO memberSearch(String id) {
		conn = connect();
		String sql = "select * from member where id = ?";
		MemberVO member = new MemberVO();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				member.setId(rs.getString("id"));
				member.setMail(rs.getString("mail"));
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
	public void memberInsert(MemberVO member) {
		connect();
		String sql = "insert into member(id, name, passwd, mail) values(?,?,?,?)";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getName());
			psmt.setString(3, member.getPasswd());
			psmt.setString(4, member.getMail());

			int r = psmt.executeUpdate();
			System.out.println(r + " 건 입력.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 수정
	public void memberUpdate(MemberVO member) {
		conn = connect();
		String sql = "update member set passwd=?, name=?, mail=? where id=?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getPasswd());
			psmt.setString(2, member.getName());
			psmt.setString(3, member.getMail());
			psmt.setString(4, member.getId());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 삭제
	public void memberDelete(String id) {
		conn = connect();
		String sql = "delete from member where id=?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제.");

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			disconnect();

		}
	}

}
