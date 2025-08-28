package com.kh.spring09.dao;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring09.dto.BoardDto;
import com.kh.spring09.mapper.BoardMapper;

@Repository
public class BoardDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private BoardMapper boardMapper;
	
	//글 등록
	public int insert(BoardDto dto) {
			String sql="INSERT INTO board("
									+"board_no, board_title,board_writer,board_content)"
									+"VALUES(board_seq.nextval,?,?,?)";
			Object[]params= { dto.getBoard_title(), dto.getBoard_writer(),
					dto.getBoard_content()
			};
			return jdbcTemplate.update(sql,params);
							
	}
	
	
	//글을 수정
	public boolean update(BoardDto dto) {
		String sql = "UPDATE board "
		           + "SET board_title = ?, board_content = ?, board_etime = SYSTIMESTAMP "
		           + "WHERE board_no = ?";

		
		Object[]params= {
				dto.getBoard_title(),
				dto.getBoard_content(),
				dto.getBoard_no()
		};
		return jdbcTemplate.update(sql,params)>0;
		
		
	}
	
	public boolean delete(int boardNo) {
		String sql="DELETE FROM board WHERE board_no=?";
		return jdbcTemplate.update(sql,boardNo)>0;
	}
	
	public List<BoardDto>selectList(){
		String sql="SELECT * FROM board ORDER BY board_no DESC";
		return jdbcTemplate.query(sql, boardMapper);
	}
	
	public List<BoardDto> selectList(String column, String keyword) {
	    Set<String> allow = Set.of("board_title", "board_writer", "board_content");

	    // 1. column이 null이거나 허용되지 않은 값이면 전체 목록 반환
	    if (column == null || !allow.contains(column)) {
	        return selectList();
	    }

	    // 2. keyword가 null 또는 공백이면 전체 목록 반환
	    if (keyword == null || keyword.isBlank()) {
	        return selectList();
	    }

	    // 3. 검색 실행
	    String sql = "SELECT * FROM board "
	               + "WHERE INSTR(UPPER(#1), UPPER(?)) > 0 "
	               + "ORDER BY #1 ASC, board_no DESC";
	    sql = sql.replace("#1", column);
	    Object[] params = { keyword };
	    return jdbcTemplate.query(sql, boardMapper, params);
	}

	
	public BoardDto selectOne(int board_no) {
		String sql="select *from board where board_no=?";
		Object[]params= {board_no};
		List<BoardDto>list=jdbcTemplate.query(sql, boardMapper,params);
		return list.isEmpty()?null:list.get(0);
	}
    public boolean updateReadCount(int board_no) {
        String sql = "update board set board_read = board_read + 1 where board_no = ?";
        Object[] params = { board_no };
        return jdbcTemplate.update(sql, params) > 0;
    }
	
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
