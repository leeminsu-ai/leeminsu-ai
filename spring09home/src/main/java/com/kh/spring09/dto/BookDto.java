package com.kh.spring09.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class BookDto {
	private int bookId;//도서번호
	private String bookTitle;//도서제목
	private String bookAuthor;//저자
	private String bookPublicationDate;//출간일
	private int bookPrice;//판매가
	private String bookPublisher;//출판사
	private int bookPageCount;//페이지수
	private String bookGenre;//장르
}
