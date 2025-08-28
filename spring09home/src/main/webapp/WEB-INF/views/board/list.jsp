<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1> 게시판 목록</h1>

<p><a href="write">글쓰기</a></p>

<form action="list">
 	<select name="column">
 			<option value="board_title" ${param.column=='board_title'? 'selected':' ' }>제목</option>
 			  <option value="board_writer" ${param.column == 'board_writer' ? 'selected' : ''}>작성자</option>
	</select>
	 <input type="text" name="keyword" placeholder="검색어" required value="${param.keyword}">
   <button>검색</button>
</form>

<table border="1" width="100%">
    <thead>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>조회수</th>
            <th>작성일</th>
        </tr>
    </thead>
    <tbody><c:forEach var="boardDto" items="${list}">
            <tr>
                <td>${boardDto.board_no}</td>
                <td>
                    <a href="detail?board_no=${boardDto.board_no}">
                        ${boardDto.board_title}
                    </a>
                </td>
                <td>${boardDto.board_writer}</td>
                <td>${boardDto.board_read}</td>
                <td>
                <fmt:formatDate value="${boardDto.board_wtime}" pattern="yyyy-MM-dd" />
                </td>
                </tr>
                </c:forEach>
                </tbody>
                </table>