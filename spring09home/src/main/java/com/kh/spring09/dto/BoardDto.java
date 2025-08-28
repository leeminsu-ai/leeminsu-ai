package com.kh.spring09.dto;



import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class BoardDto {
		private int board_no;
		private String board_title;
		private String board_writer;
		private Timestamp board_wtime;
		private Timestamp board_etime;
		private String board_content;
		private int board_read;
		private int board_like;
		private int board_reply;
		private String board_notice;
	
}
