package com.kh.spring09.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring09.dto.MemberDto;
import com.kh.spring09.mapper.MemberMapper;

@Repository
public class MemberDao {
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//CRUD 메소드들
	public void insert(MemberDto memberDto) {
		String sql = "insert into member("
							+ "member_id, member_pw, member_nickname, member_email, "
							+ "member_birth, member_contact,"
							+ "member_post, member_address1, member_address2"
						+ ") "
						+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] params = {
			memberDto.getMemberId(), memberDto.getMemberPw(),
			memberDto.getMemberNickname(), memberDto.getMemberEmail(),
			memberDto.getMemberBirth(), memberDto.getMemberContact(),
			memberDto.getMemberPost(), memberDto.getMemberAddress1(),
			memberDto.getMemberAddress2()
		};
		jdbcTemplate.update(sql, params);
	}
	
	public List<MemberDto> selectList() {
		String sql = "select * from member order by member_id asc";
		return jdbcTemplate.query(sql, memberMapper);
	}
	public List<MemberDto> selectList(String column, String keyword) {
		String sql = "select * from member where instr(#1, ?) > 0 "
						+ "order by #1 asc, member_id asc";
		sql = sql.replace("#1", column);//정적할당
		Object[] params = {keyword};//동적할당
		return jdbcTemplate.query(sql, memberMapper, params);
	}

	public MemberDto selectOne(String memberId) {
		String sql = "select * from member where member_id = ?";
		Object[] params = {memberId};
		List<MemberDto> list = jdbcTemplate.query(sql, memberMapper, params);
		return list.isEmpty() ? null : list.get(0);
	}
	
	public boolean delete(String memberId) {
		String sql="delete from member where member_id=?";
		Object[] params= {memberId};
		return jdbcTemplate.update(sql,params)>0;
	}
//	정보를 변경하는 경우는 크게 두 가지가 있을 수 있다
//	1. 회원이 자신의 정보를 변경하는 경우
//	2. 관리자가 회원의 정보를 변경하는 경우
	public boolean updateMember(MemberDto memberDto) {
		String sql = "update member set "
							+ "member_nickname=?, member_birth=?, member_contact=?, "
							+ "member_email=?, member_post=?, member_address1=?, "
							+ "member_address2=? "
						+ "where member_id=?";
		Object[] params = {
				  memberDto.getMemberNickname(), memberDto.getMemberBirth(),
				  memberDto.getMemberContact(), memberDto.getMemberEmail(),   // ← 이메일
				  memberDto.getMemberPost(), memberDto.getMemberAddress1(),
				  memberDto.getMemberAddress2(), memberDto.getMemberId()
				};
		return jdbcTemplate.update(sql, params) > 0;
	}

	public boolean updateMemberByAdmin(MemberDto memberDto) {
		String sql = "update member set "
							+ "member_nickname=?, member_birth=?, member_contact=?, "
							+ "member_email=?, member_post=?, member_address1=?, "
							+ "member_address2=?, member_level=?, member_point=? "
						+ "where member_id=?";
		Object[] params = {
			memberDto.getMemberNickname(), memberDto.getMemberBirth(),
			memberDto.getMemberContact(), memberDto.getMemberEmail(),
			memberDto.getMemberPost(), memberDto.getMemberAddress1(),
			memberDto.getMemberAddress2(), memberDto.getMemberLevel(),
			memberDto.getMemberPoint(), memberDto.getMemberId()
		};
		return jdbcTemplate.update(sql, params) > 0;
	}
		public boolean updateMemberPw(MemberDto memberDto) {
			return updateMemberPw(memberDto.getMemberId(), memberDto.getMemberPw());
		}
		public boolean updateMemberPw(String memberId, String memberPw) {
			String sql = "update member "
							+ "set member_pw=?, member_change=systimestamp "
							+ "where member_id=?";
			Object[] params = {memberPw, memberId};
			return jdbcTemplate.update(sql, params) > 0;
		}
		public boolean updateMemberLogin(String memberId) {
			String sql = "update member set member_login=systimestamp where member_id=?";
			Object[] params = {memberId};
			return jdbcTemplate.update(sql, params) > 0;
	}
}


