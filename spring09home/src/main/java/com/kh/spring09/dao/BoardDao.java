package com.kh.spring09.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring09.dto.BoardDto;
import com.kh.spring09.mapper.BoardListMapper;
import com.kh.spring09.mapper.BoardMapper;
import com.kh.spring09.mapper.BoardMentionMapper;
import com.kh.spring09.vo.BoardListVO;
import com.kh.spring09.vo.BoardMentionVO;
import com.kh.spring09.vo.PageVO;

@Repository
public class BoardDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private BoardMapper boardMapper;//상세용도 (내용 조회됨)
	@Autowired
	private BoardListMapper boardListMapper;//목록 및 검색용도 (내용 조회되지 않음)
	@Autowired
	private BoardMentionMapper boardMentionMapper;
	
	//상세
	public BoardDto selectOne(int boardNo) {
		String sql = "select * from board where board_no=?";
		Object[] params = {boardNo};
		List<BoardDto> list = jdbcTemplate.query(sql, boardMapper, params);
		return list.isEmpty() ? null : list.get(0);
	}
	//조회수 증가
	public boolean updateBoardRead(int boardNo) {
		String sql = "update board set board_read=board_read+1 where board_no=?";
		Object[] params = {boardNo};
		return jdbcTemplate.update(sql, params) > 0;
	}
	public int sequence() {
		String sql = "select board_seq.nextval from dual";
		//int처럼 자바의 기본데이터들은 Mapper 없이도 조회가 가능
		//= int 1개, String 1개 처럼 매우 특수한 상황(특히 집계함수 사용 결과)
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	public void insert(BoardDto boardDto) {
		String sql = "insert into board("
							+ "board_no, board_title, board_content, board_writer, board_notice, "
							+ "board_group, board_origin, board_depth"
						+ ") "
						+ "values(?, ?, ?, ?, ?, ?, ?, ?)";//기존방법
//						+ "values(?, ?, ?, ?, nvl(?, 'N'), ?, ?, ?)";//Oracle의 NVL함수를 이용하는 방법
		Object[] params = {
			boardDto.getBoardNo(), boardDto.getBoardTitle(), 
			boardDto.getBoardContent(), boardDto.getBoardWriter(),
			boardDto.getBoardNotice(), boardDto.getBoardGroup(),
			boardDto.getBoardOrigin(), boardDto.getBoardDepth()
		};
		jdbcTemplate.update(sql, params);
	}
	public boolean delete(int boardNo) {
		String sql = "delete board where board_no = ?";
		Object[] params = {boardNo};
		return jdbcTemplate.update(sql, params) > 0;
	}
	public boolean update(BoardDto boardDto) {
		String sql = "update board "
						+ "set board_title=?, board_content=?, "
						+ "board_notice=?, board_etime=systimestamp "
						+ "where board_no=?";
		Object[] params = {
			boardDto.getBoardTitle(), boardDto.getBoardContent(),
			boardDto.getBoardNotice(), boardDto.getBoardNo()
		};
		return jdbcTemplate.update(sql, params) > 0;
	}
	
	//목록+검색+페이징 통합
	public List<BoardListVO> selectListWithPaging(PageVO pageVO) {
		if(pageVO.isList()) {//목록
			String sql = "select * from ("
								+ "select rownum rn, TMP.* from ("
									+ "select * from board_list "
									+ "connect by prior board_no=board_origin "
									+ "start with board_origin is null "
									+ "order siblings by board_group desc, board_no asc"
								+ ")TMP"
							+ ") where rn between ? and ?";
			Object[] params = {pageVO.getBegin(), pageVO.getEnd()};
			return jdbcTemplate.query(sql, boardListMapper, params);
		}
		else {//검색
			String sql = "select * from ("
								+ "select rownum rn, TMP.* from ("
									+ "select * from board_list "
									+ "where instr(#1, ?) > 0 "
									+ "connect by prior board_no=board_origin "
									+ "start with board_origin is null "
									+ "order siblings by board_group desc, board_no asc"
								+ ")TMP"
						+ ") where rn between ? and ?";
			sql = sql.replace("#1", pageVO.getColumn());
			Object[] params = {pageVO.getKeyword(), pageVO.getBegin(), pageVO.getEnd()};
			return jdbcTemplate.query(sql, boardListMapper, params);
		}
	}
	
	//목록+검색+페이징 통합 (+멘션)
	public List<BoardMentionVO> selectListWithMention(PageVO pageVO) {
		if(pageVO.isList()) {//목록
			String sql = "select * from ("
								+ "select rownum rn, TMP.* from ("
									+ "select * from board_mention "
									+ "connect by prior board_no=board_origin "
									+ "start with board_origin is null "
									+ "order siblings by board_group desc, board_no asc"
								+ ")TMP"
							+ ") where rn between ? and ?";
			Object[] params = {pageVO.getBegin(), pageVO.getEnd()};
			return jdbcTemplate.query(sql, boardMentionMapper, params);
		}
		else {//검색
			String sql = "select * from ("
								+ "select rownum rn, TMP.* from ("
									+ "select * from board_mention "
									+ "where instr(#1, ?) > 0 "
									+ "connect by prior board_no=board_origin "
									+ "start with board_origin is null "
									+ "order siblings by board_group desc, board_no asc"
								+ ")TMP"
						+ ") where rn between ? and ?";
			sql = sql.replace("#1", pageVO.getColumn());
			Object[] params = {pageVO.getKeyword(), pageVO.getBegin(), pageVO.getEnd()};
			return jdbcTemplate.query(sql, boardMentionMapper, params);
		}
	}
	
//	페이지 네비게이터 구현에 필요한 카운트 구하는 메소드 (목록 검색 따로)
	public int count(PageVO pageVO) {
		if(pageVO.isList()) {//목록일 경우
			String sql = "select count(*) from board_list";
			return jdbcTemplate.queryForObject(sql, int.class);
		}
		else {//검색일 경우
			String sql = "select count(*) from board_list where instr(#1, ?) > 0";
			sql = sql.replace("#1", pageVO.getColumn());
			Object[] params = {pageVO.getKeyword()};
			return jdbcTemplate.queryForObject(sql, int.class, params);
		}
	}
	
//	public int count() {
//		String sql = "select count(*) from board";
//		return jdbcTemplate.queryForObject(sql, int.class);
//	}
//	public int count(String column, String keyword) {
//		String sql = "select count(*) from board where instr(#1, ?) > 0";
//		sql = sql.replace("#1", column);
//		Object[] params = {keyword};
//		return jdbcTemplate.queryForObject(sql, int.class, params);
//	}
	
//	공지사항 조회용 메소드
	public List<BoardListVO> selectListNotice(PageVO pageVO) {
		if(pageVO.isList()) {
			String sql = "select * from board_list "
							+ "where board_notice = 'Y' order by board_no desc";
			return jdbcTemplate.query(sql, boardListMapper);
		}
		else {
			String sql = "select * from board_list "
							+ "where board_notice = 'Y' and instr(#1, ?) > 0 "
							+ "order by board_no desc";
			sql = sql.replace("#1", pageVO.getColumn());
			Object[] params = {pageVO.getKeyword()};
			return jdbcTemplate.query(sql, boardListMapper, params);
		}
	}
}






