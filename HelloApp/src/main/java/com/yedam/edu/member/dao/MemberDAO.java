package com.yedam.edu.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		}
		return list;
	};
}
