package com.kh.spring09.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring09.mapper.StatMapper;
import com.kh.spring09.vo.StatVO;

//모든 테이블에 대한 통계 조회 기능만 전담하는 DAO
@Repository
public class StatDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private StatMapper statMapper;
	
	//포켓몬 현황
	public List<StatVO> countByPokemonType() {
		String sql = "select pokemon_type title, count(*) value from pokemon "
						+ "group by pokemon_type order by value desc, title asc";
		return jdbcTemplate.query(sql, statMapper);
	}
	//도서 현황
	public List<StatVO> countByBookGenre() {
		String sql = "select book_genre title, count(*) value from book "
						+ "group by book_genre order by value desc, title asc";
		return jdbcTemplate.query(sql, statMapper);
	}
	//회원 현황
	public List<StatVO> countByMemberLevel() {
		String sql = "select member_level title, count(*) value from member "
						+ "group by member_level order by value desc, title asc";
		return jdbcTemplate.query(sql, statMapper);
	}
	//학생 현황
	public List<StatVO> countByStudentDaily() {
		String sql = "select to_char(student_reg, 'YYYY-MM-DD') title, count(*) value from student "
				+ "group by to_char(student_reg, 'YYYY-MM-DD') order by title asc, value desc";
		return jdbcTemplate.query(sql, statMapper);		
	}
}





