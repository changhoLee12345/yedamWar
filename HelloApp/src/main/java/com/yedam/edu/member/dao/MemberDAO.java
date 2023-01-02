package com.yedam.edu.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.yedam.edu.common.DAO;
import com.yedam.edu.member.vo.MemberVO;

public class MemberDAO {

	Connection conn;
	ResultSet rs;
	PreparedStatement psmt;
	String sql;

	private static MemberDAO instance = new MemberDAO();

	private MemberDAO() {
	}

	public static MemberDAO getInstance() {
		return instance;
	}

	public void disconnect() {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (psmt != null)
				psmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public int insertCenterInfo(List<Map<String, Object>> list) {
		String sql = "insert all ";
		for (Map<String, Object> map : list) {
			sql += " into center_info(id, center_name, phone_number) values (" //
					+ map.get("id") + ",'" + map.get("centerName") + "', '" + map.get("phoneNumber") + "')";
		}
		sql += " select * from dual";
		conn = DAO.connect();
		try {
			psmt = conn.prepareStatement(sql);
			int result = psmt.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return 0;
	}

	public List<MemberVO> memberList() {
		List<MemberVO> list = new ArrayList<>();
		sql = "select * from member ";
		conn = DAO.connect();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				MemberVO vo = new MemberVO();
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	};

	public MemberVO loginCheck(MemberVO vo) {
		sql = "select * from members where id=? and passwd=?";
		conn = DAO.connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPasswd());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}
}
