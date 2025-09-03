package com.kh.spring09.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring09.dto.MemberDto;
import com.kh.spring09.mapper.MemberMapper;
import com.kh.spring09.vo.PageVO;

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
							+ "member_post, member_address1, member_address2, "
							+ "member_change"
						+ ") "
						+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, systimestamp)";
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
		String sql = "select * from member "
						+ "where member_level != '관리자' "
						+ "order by member_id asc";
		return jdbcTemplate.query(sql, memberMapper);
	}
	public List<MemberDto> selectList(String column, String keyword) {
		String sql = "select * from member "
						+ "where instr(#1, ?) > 0 and member_level != '관리자' "
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
		String sql = "delete member where member_id=?";
		Object[] params = {memberId};
		return jdbcTemplate.update(sql, params) > 0;
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
			memberDto.getMemberContact(), memberDto.getMemberEmail(), 
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

	public int count(PageVO pageVO) {
		if(pageVO.isList()) {
			return 0;//목록은 데이터가 없다! (회원 검색의 특징)
			//String sql = "select count(*) from member";
			//return jdbcTemplate.queryForObject(sql, int.class);
		}
		else {
			String sql ="select count(*) from member "
					+ "where instr(#1, ?) > 0 and member_level != '관리자'";
			sql = sql.replace("#1", pageVO.getColumn());
			Object[] params = {pageVO.getKeyword()};
			return jdbcTemplate.queryForObject(sql, int.class, params);
		}
	}
	
	public List<MemberDto> selectListWithPaging(PageVO pageVO) {
		if(pageVO.isList()) {//목록이라면
			return null;//return List.of();//목록은 현재 보여주지 않고 있다
		}
		else {//검색이라면
			String sql = "select * from ("
								+ "select rownum rn, TMP.* from ("
									+ "select * from member "
									+ "where instr(#1, ?) > 0 and member_level != '관리자' "
									+ "order by #1 asc, member_id asc"
								+ ")TMP"
							+ ") where rn between ? and ?";
			sql = sql.replace("#1", pageVO.getColumn());
			Object[] params = {
					pageVO.getKeyword(), pageVO.getBegin(), pageVO.getEnd()
			};//동적할당
			return jdbcTemplate.query(sql, memberMapper, params);
		}
	}
}






