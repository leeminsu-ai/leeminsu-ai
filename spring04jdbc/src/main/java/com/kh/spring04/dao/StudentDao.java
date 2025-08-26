package com.kh.spring04.dao;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring04.dto.StudentDto;
import com.kh.spring04.mapper.StudentMapper;

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
                + ") values(student_seq.nextval, ?, ?, ?, ?, systimestamp)";
        Object[] param = {
            studentDto.getStudentName(),
            studentDto.getStudentKor(),
            studentDto.getStudentEng(),
            studentDto.getStudentMat()
        };
        jdbcTemplate.update(sql, param);
    }

    public boolean update(StudentDto studentDto) {
        String sql = "update student "
                + "set student_name=?, student_kor=?, student_eng=?, student_mat=? "
                + "where student_no=?";
        Object[] params = {
            studentDto.getStudentName(),
            studentDto.getStudentKor(),
            studentDto.getStudentEng(),
            studentDto.getStudentMat(),
            studentDto.getStudentNo()
        };
        return jdbcTemplate.update(sql, params) > 0;
    }

    public boolean delete(StudentDto studentDto) {
        String sql = "delete from student where student_no = ?";
        Object[] params = { studentDto.getStudentNo() };
        return jdbcTemplate.update(sql, params) > 0;
    }

    public boolean delete(int studentNo) {
        String sql = "delete from student where student_no = ?";
        return jdbcTemplate.update(sql, studentNo) > 0;
    }

    public StudentDto selectOne(int studentNo) {
        String sql = "select student_no, student_name, student_kor, student_eng, student_mat, student_reg "
                   + "from student where student_no = ?";
        List<StudentDto> list = jdbcTemplate.query(sql, studentMapper, studentNo);
        return list.isEmpty() ? null : list.get(0);
    }

    // ✅ 전체 조회 (미구현 부분 채움)
    public List<StudentDto> selectList() {
        String sql = "select student_no, student_name, student_kor, student_eng, student_mat, student_reg "
                   + "from student order by student_no asc";
        return jdbcTemplate.query(sql, studentMapper);
    }

    // ✅ 검색 조회 (컬럼 화이트리스트 + 타입별 처리)
    public List<StudentDto> selectList(String column, String keyword) {
        // 실제 존재하는 컬럼만 허용
        Set<String> allow = Set.of("student_no", "student_name", "student_kor", "student_eng", "student_mat");
        if (!allow.contains(column)) {
            throw new IllegalArgumentException("invalid column: " + column);
        }

        String sql;
        Object[] params;

        switch (column) {
            case "student_no":
                // 숫자 컬럼: 부분검색이면 to_char로, 정확검색이면 = ?
                sql = "select student_no, student_name, student_kor, student_eng, student_mat, student_reg "
                    + "from student where instr(to_char(student_no), ?) > 0 "
                    + "order by student_no asc";
                params = new Object[] { keyword };
                break;
            case "student_kor":
            case "student_eng":
            case "student_mat":
                // 점수도 숫자라서 부분검색이면 to_char 사용
                sql = "select student_no, student_name, student_kor, student_eng, student_mat, student_reg "
                    + "from student where instr(to_char(" + column + "), ?) > 0 "
                    + "order by " + column + " asc, student_no asc";
                params = new Object[] { keyword };
                break;
            case "student_name":
            default:
                // 문자열 컬럼
                sql = "select student_no, student_name, student_kor, student_eng, student_mat, student_reg "
                    + "from student where instr(" + column + ", ?) > 0 "
                    + "order by " + column + " asc, student_no asc";
                params = new Object[] { keyword };
                break;
        }

        return jdbcTemplate.query(sql, studentMapper, params);
    }
}
