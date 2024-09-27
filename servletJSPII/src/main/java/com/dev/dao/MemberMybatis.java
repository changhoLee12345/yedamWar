package com.dev.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dev.common.DataSource;
import com.dev.common.SearchDTO;
import com.dev.vo.MemberVO;

public class MemberMybatis implements MemberAction {

	// sqlSessionFactory에서 sqlSession을 생성해오기 위해 ..
	SqlSessionFactory sqlSessionFactory = DataSource.getSqlSessionFactory();;
//	SqlSession session = sqlSessionFactory.openSession(true);

	private static MemberMybatis instance = new MemberMybatis();

	private MemberMybatis() {
	}

	public static MemberMybatis getInstance() {
		return instance;
	}

	// id, pw 조회
	public MemberVO login(MemberVO vo) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			MemberVO member = session.selectOne("com.dev.mybatisdb.memberMapper.login", vo);
			return member;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 멤버리스트.
	public List<MemberVO> memberList() {
		System.out.println("memberList");
		try (SqlSession session = sqlSessionFactory.openSession()) {
			List<MemberVO> memberList = session.selectList("com.dev.mybatisdb.MemberMapper.getMemberList");
			return memberList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<MemberVO> selectList(SearchDTO search) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			List<MemberVO> memberList = session.selectList("com.dev.mybatisdb.MemberMapper.getMemberList");
			return memberList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 단건조회.
	public MemberVO memberSearch(String id) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			MemberVO member = session.selectOne("com.dev.mybatisdb.memberMapper.getMemberMap", id);
			return member;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 입력.
	public int memberInsert(MemberVO member) {
		try (SqlSession session = sqlSessionFactory.openSession(true)) {
			return session.insert("com.dev.mybatisdb.MemberMapper.insertMember", member);
		}
	}

	// 수정.
	public int memberUpdate(MemberVO member) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			return session.update("com.dev.mybatisdb.memberMapper.updateMember", member);
		}
	}

	// 삭제
	public int memberDelete(String id) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			return session.delete("com.dev.mybatisdb.memberMapper.deleteMember", id);
		}

	}

	@Override
	public MemberVO selectMember(String id) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			MemberVO member = session.selectOne("com.dev.mybatisdb.MemberMapper.getMember", id);
			return member;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
