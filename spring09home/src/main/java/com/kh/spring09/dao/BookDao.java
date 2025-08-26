package com.kh.spring09.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring09.dto.BookDto;
import com.kh.spring09.mapper.BookMapper;

@Repository
public class BookDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private BookMapper bookMapper;
	
	//등록
	public void insert(BookDto bookDto) {
		String sql = "insert into book("
							+ "book_id, book_title, book_author, book_publication_date, "
							+ "book_price, book_publisher, book_page_count, book_genre"
						+ ") values(book_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
		Object[] params = {
			bookDto.getBookTitle(), bookDto.getBookAuthor(),
			bookDto.getBookPublicationDate(), bookDto.getBookPrice(),
			bookDto.getBookPublisher(), bookDto.getBookPageCount(),
			bookDto.getBookGenre()
		};
		jdbcTemplate.update(sql, params);
	}
	
	//목록
	public List<BookDto> selectList() {
		String sql = "select * from book order by book_id asc";
		return jdbcTemplate.query(sql, bookMapper);
	}
	public List<BookDto> selectList(String column, String keyword) {
		String sql = "select * from book "
						+ "where instr(#1, ?) > 0 "
						+ "order by #1 asc, book_id asc";
		sql = sql.replace("#1", column);
		Object[] params = {keyword};
		return jdbcTemplate.query(sql, bookMapper, params);
	}
	
	//상세
	public BookDto selectOne(int bookId) {
		String sql = "select * from book where book_id=?";
		Object[] params = {bookId};
		List<BookDto> list = jdbcTemplate.query(sql, bookMapper, params);
		return list.isEmpty() ? null : list.get(0);
	}
	
	//수정
	public boolean update(BookDto bookDto) {
		String sql = "update book "
						+ "set book_title=?, book_author=?, book_publisher=?,"
						+ "book_publication_date=?, book_price=?, "
						+ "book_page_count=?, book_genre=? "
						+ "where book_id=?";
		Object[] params = {
			bookDto.getBookTitle(), bookDto.getBookAuthor(),
			bookDto.getBookPublisher(), bookDto.getBookPublicationDate(),
			bookDto.getBookPrice(), bookDto.getBookPageCount(),
			bookDto.getBookGenre(), bookDto.getBookId()
		};
		return jdbcTemplate.update(sql, params) > 0;
	}
	
	//삭제
	public boolean delete(int bookId) {
		String sql = "delete book where book_id=?";
		Object[] params = {bookId};
		return jdbcTemplate.update(sql, params) > 0;
	}
}









