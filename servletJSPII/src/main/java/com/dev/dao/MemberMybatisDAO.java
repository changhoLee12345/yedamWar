package com.dev.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dev.common.SqlMapSessionFactory;
import com.dev.vo.MemberVO;

public class MemberMybatisDAO {

	// sqlSessionFactory에서 sqlSession을 생성해오기 위해 ..
	SqlSessionFactory sessionFactory;

	private static MemberMybatisDAO instance = new MemberMybatisDAO();

	private MemberMybatisDAO() {
		sessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	}

	public static MemberMybatisDAO getInstance() {
		return instance;
	}

	// 멤버리스트.
	public List<MemberVO> memberList() {
		SqlSession session = sessionFactory.openSession();
		List<MemberVO> memberList = session.selectList("com.dev.mybatisdb.memberMapper.getMemberList");
		session.close();
		return memberList;
	}

	// 단건조회.
	public MemberVO memberSearch(String id) {
		SqlSession session = sessionFactory.openSession();
		MemberVO member = session.selectOne("com.dev.mybatisdb.memberMapper.getMemberMap", id);
		session.close();
		return member;
	}

	// 입력.
	public void memberInsert(MemberVO member) {
		SqlSession session = sessionFactory.openSession();
		session.insert("com.dev.mybatisdb.memberMapper.insertMember", member);
		session.close();
	}

	// 수정.
	public void memberUpdate(MemberVO member) {
		SqlSession session = sessionFactory.openSession();
		session.update("com.dev.mybatisdb.memberMapper.updateMember", member);
		session.close();
	}

	// 삭제
	public void memberDelete(String id) {
		SqlSession session = sessionFactory.openSession();
		session.delete("com.dev.mybatisdb.memberMapper.deleteMember", id);
		session.close();
	}

}
