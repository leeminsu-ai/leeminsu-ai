package com.kh.springPractice.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Member1Dto {
	 private int memberId;
	    private String memberLoginId;
	    private String memberPw;
	    private String memberName;
	    private String memberPhone;
	    private String memberEmail;
	    private String memberLevel;
	    private Timestamp createdAt;
	    private String memberNickname;
	}

