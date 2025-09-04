package com.kh.spring09.vo;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Data;

@Data
public class BoardListVO {
	//board_list 라는 뷰를 조회했을떄 나오는항목을 담기위한 필드를 작성(BoardDto+닉네임,등급)
	private int boardNo;
	private String boardTitle;
	private String boardWriter;
	private Timestamp boardWtime, boardEtime;
	//private String boardContent; //있을 필요가없음(board_list에서 조회하지않음)
	private int boardRead, boardLike, boardReply;
	private String boardNotice = "N";
	private int boardGroup; //글 그룹 번호(답변형 게시판용)
	private Integer boardOrigin; //상위 글 번호
	private int boardDepth;//글 차수
	//private boolean boardNotice;
	private String memberId; //작성자의 ID
	private String memberNickname; //작성자의닉네임
	private String memberLevel; //작성자의 등급
	
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

	

