<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>글쓰기</h1>

<form action="write" method="post">
    <div>
        <label>제목</label>
        <input type="text" name="board_title" required>
    </div>
    <div>
        <label>작성자</label>
        <input type="text" name="board_writer" required>
    </div>
    <div>
        <label>내용</label>
        <textarea name="board_content" required rows="10" cols="60"></textarea>
    </div>
    <div>
        <button type="submit">작성 완료</button>
    </div>
</form>
