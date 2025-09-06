package com.kh.springPractice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.springPractice.Mapper.Member1Mapper;
import com.kh.springPractice.dto.Member1Dto;
@Repository
public class Member1Dao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private final Member1Mapper member1Mapper= new Member1Mapper();
	
	 public void insert(Member1Dto dto) {
		 String sql="""
		 	Insert into member1(member_id,member_login_id,member_pw,member_name,
		 	member_phone,member_email, member_level,
                created_at, member_nickname)
                VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)
		 		""";
		 Object[] params= {
				 dto.getMemberId(),
		            dto.getMemberLoginId(),
		            dto.getMemberPw(),
		            dto.getMemberName(),
		            dto.getMemberPhone(),
		            dto.getMemberEmail(),
		            dto.getMemberLevel(),
		            dto.getCreatedAt(),
		            dto.getMemberNickname()
				 
		 };
		 jdbcTemplate.update(sql,params);
		 
	 }
	 
	 public Member1Dto selectOne(int memberid) {
		 String sql="select *from member1 where member_id=?";
		 Object []params= {memberid};
		 List<Member1Dto>list=jdbcTemplate.query(sql,member1Mapper,params);
		 return list.isEmpty()? null:list.get(0);
	 }
	 
	 public List<Member1Dto> selectList() {
	        String sql = "SELECT * FROM member1 ORDER BY member_id ASC";
	        return jdbcTemplate.query(sql, member1Mapper);
	 
	 }
	 
	public boolean delete(int memberId) {
		String sql="Delete From member1 Where member_id=?";
		Object[] params= {memberId};
		return jdbcTemplate.update(sql,params)>0;
	}
	 
	 
	 
	 
}
