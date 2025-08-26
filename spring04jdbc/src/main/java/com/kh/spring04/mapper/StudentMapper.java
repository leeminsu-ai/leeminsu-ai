package com.kh.spring04.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kh.spring04.dto.StudentDto;

@Component
public class StudentMapper implements RowMapper<StudentDto>{
	@Override
	public StudentDto mapRow(ResultSet rs, int idx) throws SQLException {
		//ResultSet에 담긴 데이터를 StudentDto로 변환하여 반환하는 코드 (조회과정의 유일한 미싱링크)
		StudentDto studentDto = new StudentDto();
		studentDto.setStudentNo(rs.getInt("student_no"));
		studentDto.setStudentName(rs.getString("student_name"));
		studentDto.setStudentKor(rs.getInt("student_kor"));
		studentDto.setStudentEng(rs.getInt("student_eng"));
		studentDto.setStudentMat(rs.getInt("student_mat"));
		
		return studentDto;
	}
}



