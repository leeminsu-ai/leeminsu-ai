package com.kh.springPractice.dto;

import java.sql.Timestamp;

import lombok.Data;
@Data
public class ReviewDto {
	 private int reviewId;
	    private int memberId;
	    private int productId;
	    private String reviewTitle;
	    private String reviewContent;
	    private int reviewScore;
	    private Timestamp createdAt;
}
