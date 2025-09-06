package com.kh.springPractice.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kh.springPractice.dto.Member1Dto;
@Component
public class Member1Mapper implements RowMapper<Member1Dto>{
	
	public Member1Dto mapRow(ResultSet rs,int rowNum)  throws SQLException{
		Member1Dto dto=new Member1Dto();
		dto.setMemberId(rs.getInt("member_id"));
		dto.setMemberLoginId(rs.getString("member_login_id"));
        dto.setMemberPw(rs.getString("member_pw"));
        dto.setMemberName(rs.getString("member_name"));
        dto.setMemberPhone(rs.getString("member_phone"));
        dto.setMemberEmail(rs.getString("member_email"));
        dto.setMemberNickname(rs.getString("member_nickname"));
        dto.setMemberLevel(rs.getString("member_level"));
        dto.setCreatedAt(rs.getTimestamp("created_at"));
        
       return dto;
		
		
	}

}
