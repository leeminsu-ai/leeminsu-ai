<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"/>

<h1>게시글 상세보기</h1>

<table border="1" width="100%">
    <tr><th>번호</th><td>${boardDto.board_no}</td></tr>
    <tr><th>제목</th><td>${boardDto.board_title}</td></tr>
    <tr><th>작성자</th><td>${boardDto.board_writer}</td></tr>
    <tr><th>조회수</th><td>${boardDto.board_read}</td></tr>
    <tr><th>내용</th><td><pre>${boardDto.board_content}</pre></td></tr>
</table>

<p>
    <a href="edit?board_no=${boardDto.board_no}">수정</a>
    |
    <a href="delete?board_no=${boardDto.board_no}" onclick="return confirm('정말 삭제할까요?')">삭제</a>
    |
    <a href="list">목록으로</a>
</p>
ml>