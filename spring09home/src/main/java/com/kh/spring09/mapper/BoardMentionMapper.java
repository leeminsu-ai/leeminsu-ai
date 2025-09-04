package com.kh.spring09.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kh.spring09.vo.BoardMentionVO;

@Component
public class BoardMentionMapper implements RowMapper<BoardMentionVO> {
	@Override
	public BoardMentionVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardMentionVO boardMentionVO = new BoardMentionVO();
		boardMentionVO.setBoardNo(rs.getInt("board_no"));
		boardMentionVO.setBoardTitle(rs.getString("board_title"));
		boardMentionVO.setBoardWriter(rs.getString("board_writer"));
		boardMentionVO.setBoardWtime(rs.getTimestamp("board_wtime"));
		boardMentionVO.setBoardEtime(rs.getTimestamp("board_etime"));
		boardMentionVO.setBoardRead(rs.getInt("board_read"));
		boardMentionVO.setBoardLike(rs.getInt("board_like"));
		boardMentionVO.setBoardReply(rs.getInt("board_reply"));
		boardMentionVO.setBoardNotice(rs.getString("board_notice"));
		boardMentionVO.setBoardGroup(rs.getInt("board_group"));
		boardMentionVO.setBoardOrigin(rs.getObject("board_origin", Integer.class));
		boardMentionVO.setBoardDepth(rs.getInt("board_depth"));
		
		boardMentionVO.setMemberId(rs.getString("member_id"));
		boardMentionVO.setMemberNickname(rs.getString("member_nickname"));
		boardMentionVO.setMemberLevel(rs.getString("member_level"));
		
		boardMentionVO.setOriginNo(rs.getInt("origin_no"));
		boardMentionVO.setOriginTitle(rs.getString("origin_title"));
		boardMentionVO.setOriginWriter(rs.getString("origin_writer"));
		
		return boardMentionVO;
	}

}