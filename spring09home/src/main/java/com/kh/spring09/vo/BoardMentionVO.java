package com.kh.spring09.vo;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Data;

@Data
public class BoardMentionVO {
	//board_mention이라는 뷰를 조회했을 때 나오는 항목을 담기 위한 필드를 작성
	private int boardNo;
	private String boardTitle;
	private String boardWriter;
	private Timestamp boardWtime, boardEtime;
	private int boardRead, boardLike, boardReply;
	private String boardNotice = "N";
	private int boardGroup;//글 그룹번호(답변형 게시판용)
	private Integer boardOrigin;//상위 글번호(답변형 게시판용)
	private int boardDepth;//글 차수(답변형 게시판용)
	
	private String memberId;//작성자의 ID (=boardWriter와 동일)
	private String memberNickname;//작성자의 닉네임
	private String memberLevel;//작성자의 등급
	
	private int originNo;//원본글 번호
	private String originTitle;//원본글 제목
	private String originWriter;//원본글 작성자ID
	
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