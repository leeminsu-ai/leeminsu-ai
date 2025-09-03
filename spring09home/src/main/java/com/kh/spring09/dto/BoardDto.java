package com.kh.spring09.dto;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Data;

@Data
public class BoardDto {
	private int boardNo;
	private String boardTitle;
	private String boardWriter;
	private Timestamp boardWtime, boardEtime;
	private String boardContent;
	private int boardRead, boardLike, boardReply;
	private String boardNotice = "N";
	//private boolean boardNotice;
	
	//EL에서 ${boardDto.boardWriteTime}으로 부를 수 있는 메소드
	public String getBoardWriteTime() {
		LocalDateTime wtime = boardWtime.toLocalDateTime();//작성시점을 LocalDateTime으로 변환
		LocalDate today = LocalDate.now();//오늘날짜를 구하고
		LocalDate wday = wtime.toLocalDate();//작성일자를 구해서
		
		if(wday.isBefore(today)) {//이전에 작성한 글이라면
			return wtime.toLocalDate().toString();//날짜 반환
		}
		else {
			DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm");
			return wtime.toLocalTime().format(fmt);//시간 반환
		}
	}
}




