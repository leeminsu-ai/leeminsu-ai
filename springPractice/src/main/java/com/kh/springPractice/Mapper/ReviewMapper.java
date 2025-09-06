package com.kh.springPractice.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kh.springPractice.dto.ReviewDto;
@Component
public class ReviewMapper implements RowMapper<ReviewDto> {
	 public ReviewDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		 ReviewDto reviewDto = new ReviewDto();
	        reviewDto.setReviewId(rs.getInt("review_id"));
	        reviewDto.setMemberId(rs.getInt("member_id"));
	        reviewDto.setProductId(rs.getInt("product_id"));
	        reviewDto.setReviewContent(rs.getString("review_content"));
	        reviewDto.setReviewScore(rs.getInt("review_score"));
	        reviewDto.setCreatedAt(rs.getTimestamp("created_at"));
	        return reviewDto;
	    }
}

