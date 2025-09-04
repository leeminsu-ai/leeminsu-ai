<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<%-- 제목 --%>
<h1>자유 게시판(멘션형태)</h1>
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
<table border="1" width="100%">
	<tbody align="left">
		<c:forEach var="boardListVO" items="${boardList}" varStatus="status">
		<tr bgcolor="${status.index < noticeCount ? '#ffeaa7' : ''}">
			<td>
				No.${boardListVO.boardNo} 
				(${boardListVO.memberNickname == null ? '탈퇴한사용자' : boardListVO.memberNickname})
				<br><br>
				<c:if test="${boardListVO.boardDepth > 0}">
					<div style="color:red">@ ${boardListVO.originWriter} - ${boardListVO.originTitle}</div>
				</c:if>
				<a href="detail?boardNo=${boardListVO.boardNo}">${boardListVO.boardTitle}</a>
			</td>
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






