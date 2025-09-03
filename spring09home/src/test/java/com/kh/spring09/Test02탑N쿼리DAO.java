package com.kh.spring09;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring09.dao.BoardDao;
import com.kh.spring09.dto.BoardDto;

@SpringBootTest
public class Test02탑N쿼리DAO {
	@Autowired
	private BoardDao boardDao;
	
	@Test
	public void test() {
		int page = 1, size = 10;
		
		List<BoardDto> boardList = boardDao.selectListWithPaging(page, size);
		System.out.println("size = " + size);
		assertEquals(size, boardList.size());
	}
}






