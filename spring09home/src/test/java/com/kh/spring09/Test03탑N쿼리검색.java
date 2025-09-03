package com.kh.spring09;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import com.kh.spring09.dto.BoardDto;
import com.kh.spring09.mapper.BoardListMapper;

@SpringBootTest
public class Test03탑N쿼리검색 {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private BoardListMapper boardListMapper;
	
	@Test
	public void test() {
		int page=1;
		int size=10;
		String column="board_title";
		String keyword="공부";
		int begin = page * size - (size-1);
		int end = page * size;
		String sql = "select * from ("
							+ "select rownum rn, TMP.* from ("
								+ "select * from board where instr(#1, ?) > 0 "
								+ "order by board_no desc"
							+ ")TMP"
					+ ") where rn between ? and ?";
		sql = sql.replace("#1", column);
		Object[] params = {keyword, begin, end};
		List<BoardDto> boardList = jdbcTemplate.query(sql, boardListMapper, params);
		System.out.println("size = " + boardList.size());
	}
}





