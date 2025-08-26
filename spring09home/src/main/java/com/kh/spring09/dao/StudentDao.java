package com.kh.spring09.dao;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring09.dto.StudentDto;
import com.kh.spring09.mapper.StudentMapper;

@Repository
public class StudentDao {
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insert(StudentDto studentDto) {
		String sql = "insert into student("
						+ "student_no, student_name, student_kor, "
						+ "student_eng, student_mat, student_reg"
					+ ") "
					+ "values(student_seq.nextval, ?, ?, ?, ?, systimestamp)";
		Object[] param = {
			studentDto.getStudentName(), studentDto.getStudentKor(),
			studentDto.getStudentEng(), studentDto.getStudentMat()
		};
		jdbcTemplate.update(sql, param);
	}

	public boolean update(StudentDto studentDto) {
		String sql = "update student "
						+ "set student_name=?, student_kor=?,"
							+ "student_eng=?, student_mat=? "
						+ "where student_no=?";
		Object[] params = {
			studentDto.getStudentName(), studentDto.getStudentKor(),
			studentDto.getStudentEng(), studentDto.getStudentMat(),
			studentDto.getStudentNo()
		};
		return jdbcTemplate.update(sql, params) > 0;
	}

	public boolean delete(int studentNo) {
		String sql = "delete student where student_no = ?";
		Object[] params = {studentNo};
		return jdbcTemplate.update(sql, params) > 0;
	}

	public List<StudentDto> selectList() {
		String sql = "select * from student order by student_no asc";
		return jdbcTemplate.query(sql, studentMapper);
	}
	public List<StudentDto> selectList(String column, String keyword) {
		Set<String> allowList = Set.of("student_name");
		if(!allowList.contains(column)) return List.of();
		
		String sql = "select * from student "
						+ "where instr(#1, ?) > 0 "
						+ "order by #1 asc, student_no asc";
		sql = sql.replace("#1", column);
		Object[] params = {keyword};
		return jdbcTemplate.query(sql, studentMapper, params);
	}

	public StudentDto selectOne(int studentNo) {
		String sql = "select * from student where student_no=?";
		Object[] params = {studentNo};
		List<StudentDto> list = jdbcTemplate.query(sql, studentMapper, params);
		return list.isEmpty() ? null : list.get(0);
	}
}











