package com.kh.spring09.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kh.spring09.dto.BoardDto;

@Component
public class BoardMapper implements RowMapper<BoardDto> {
	@Override
	public BoardDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardDto boardDto = new BoardDto();
		boardDto.setBoardNo(rs.getInt("board_no"));
		boardDto.setBoardTitle(rs.getString("board_title"));
		boardDto.setBoardWtime(rs.getTimestamp("board_wtime"));
		boardDto.setBoardEtime(rs.getTimestamp("board_etime"));
		boardDto.setBoardWriter(rs.getString("board_writer"));
		boardDto.setBoardContent(rs.getString("board_content"));
		boardDto.setBoardRead(rs.getInt("board_read"));
		boardDto.setBoardLike(rs.getInt("board_like"));
		boardDto.setBoardReply(rs.getInt("board_reply"));
		boardDto.setBoardNotice(rs.getString("board_notice"));
		//답변형게시판용 데이터들을 이동시키는 코드
		boardDto.setBoardGroup(rs.getInt("board_group"));
		boardDto.setBoardOrigin(rs.getObject("board_origin", Integer.class));//null 까지 모두 보존
		boardDto.setBoardDepth(rs.getInt("board_depth"));
		return boardDto;
	}
}



