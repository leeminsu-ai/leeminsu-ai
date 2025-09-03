package com.kh.spring09;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import com.kh.spring09.dto.BoardDto;
import com.kh.spring09.mapper.BoardMapper;

@SpringBootTest//테스트 파일로등록(스프링의 도구들을 주입하여 사용가능)
public class Test01탑N쿼리 {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void test() {
		int page=1;
		int size=10;
		int begin=page*size-(size-1);
		int end=page*size;
		String sql="select *from("
				+"select rownum rn,TMP.*from("
				+"select * from board order by board_no desc"
				+")TMP "
				+") where rn between ? and ?";
		Object[] params= {begin,end};
		List<BoardDto>boardList=jdbcTemplate.query(sql,boardMapper,params);
		System.out.println("개수="+boardList.size());
		
	
	//성공을 단정짓는 구문을 추가해서 테스트의 정확도를 높인다
	//=> 성공상황은 boardList에 데이터가 10개가 있는것
	assertEquals(size,boardList.size());
}
}