package com.kh.spring09.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kh.spring09.dto.BookDto;

@Component
public class BookMapper implements RowMapper<BookDto> {
	@Override
	public BookDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		//rs의 내용을 BookDto에 옮겨담아 반환
		BookDto bookDto = new BookDto();
		bookDto.setBookId(rs.getInt("book_id"));
		bookDto.setBookTitle(rs.getString("book_title"));
		bookDto.setBookAuthor(rs.getString("book_author"));
		bookDto.setBookPublicationDate(rs.getString("book_publication_date"));
		bookDto.setBookPrice(rs.getInt("book_price"));
		bookDto.setBookPublisher(rs.getString("book_publisher"));
		bookDto.setBookPageCount(rs.getInt("book_page_count"));
		bookDto.setBookGenre(rs.getString("book_genre"));
		return bookDto;
	}
}
