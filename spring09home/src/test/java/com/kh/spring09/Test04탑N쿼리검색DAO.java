//package com.kh.spring09;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.kh.spring09.dao.BoardDao;
//import com.kh.spring09.dto.BoardDto;
//
//@SpringBootTest
//public class Test04탑N쿼리검색DAO {
//@Autowired
//private BoardDao boardDao;
//
//@Test
//public void test() {
//	int page=1;
//	int size=10;
//	String column="board_title";
//	String keyword="공부";
//	
//	List<BoardDto>boardList=boardDao.selectListWithPaging(page, size,column,keyword);
//	System.out.println("결과="+boardList.size());
//	assertEquals(size,boardList.size());
//}
//}
