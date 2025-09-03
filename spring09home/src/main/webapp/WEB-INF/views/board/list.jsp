<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<%-- 제목 --%>
<h1>자유 게시판</h1>
<p>타인에 대한 무분별한 비방 또는 욕설은 제제의 대상입니다</p>

<c:choose>
	<c:when test="${sessionScope.loginId != null}">
		<h3><a href="write">글쓰기</a></h3>
	</c:when>
	<c:otherwise>
		<h3><a href="/member/login">로그인</a>을 해야 글을 작성할 수 있습니다</h3>
	</c:otherwise>
</c:choose>


<%-- 글 목록 --%>
<table border="1" width="800">
	<thead>
		<tr>
			<th>번호</th>
			<th width="40%">제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
			<th>좋아요</th>
		</tr>
	</thead>
	<tbody align="center">
		<c:forEach var="boardDto" items="${boardList}" varStatus="status">
		<tr bgcolor="${status.index < noticeCount ? '#ffeaa7' : ''}">
			<td>${boardDto.boardNo} (${status.index})</td>
			<td align="left">
				<%-- 공지사항인 경우는 제목앞에 (공지) 추가 --%>
				<c:if test="${boardDto.boardNotice == 'Y'}">(공지)</c:if>
				
				<a href="detail?boardNo=${boardDto.boardNo}">
					${boardDto.boardTitle}
				</a>
			</td>
			<td>${boardDto.boardWriter == null ? '(탈퇴한사용자)' : boardDto.boardWriter}</td>
			<td>${boardDto.boardWriteTime}</td>
			<td>${boardDto.boardRead}</td>
			<td>${boardDto.boardLike}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<c:choose>
	<c:when test="${sessionScope.loginId != null}">
		<h3><a href="write">글쓰기</a></h3>
	</c:when>
	<c:otherwise>
		<h3><a href="/member/login">로그인</a>을 해야 글을 작성할 수 있습니다</h3>
	</c:otherwise>
</c:choose>

<%-- 페이지 네비게이터 구현 --%>
<jsp:include page="/WEB-INF/views/template/pagination.jsp"></jsp:include>

<%-- 검색창 --%>
<form action="list">
	<select name="column">
		<option value="board_title" ${pageVO.column == 'board_title' ? 'selected' : ''}>제목</option>
		<option value="board_writer" ${pageVO.column == 'board_writer' ? 'selected' : ''}>작성자</option>
	</select>
	<input type="text" name="keyword" value="${pageVO.keyword}" required>
	<button>검색</button>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>






