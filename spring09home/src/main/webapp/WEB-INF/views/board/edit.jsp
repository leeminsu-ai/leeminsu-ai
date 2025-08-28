<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"/>

<h1>게시글 수정</h1>

<form action="edit" method="post">
    <input type="hidden" name="board_no" value="${boardDto.board_no}">
    <p>제목 <input type="text" name="board_title" value="${boardDto.board_title}"></p>
    <p>내용 <textarea name="board_content" rows="10" cols="60">${boardDto.board_content}</textarea></p>
    <button>수정</button>
</form>
