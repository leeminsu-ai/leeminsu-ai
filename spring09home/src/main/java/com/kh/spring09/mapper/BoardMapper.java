package com.kh.spring09.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kh.spring09.dto.BoardDto;
@Component
public class BoardMapper implements RowMapper<BoardDto> {

	public BoardDto mapRow(ResultSet rs,int rowNum)throws SQLException{
			BoardDto dto=new BoardDto();
			dto.setBoard_no(rs.getInt("board_no"));
			dto.setBoard_title(rs.getString("board_title"));
			dto.setBoard_writer(rs.getString("board_writer"));
			dto.setBoard_wtime(rs.getTimestamp("board_wtime"));
			dto.setBoard_etime(rs.getTimestamp("board_etime"));
			dto.setBoard_content(rs.getString("board_content"));
			dto.setBoard_read(rs.getInt("board_read"));
			dto.setBoard_like(rs.getInt("board_like"));
			dto.setBoard_reply(rs.getInt("board_reply"));
			dto.setBoard_notice(rs.getString("board_notice"));
			return dto;
			
			
	}
}
