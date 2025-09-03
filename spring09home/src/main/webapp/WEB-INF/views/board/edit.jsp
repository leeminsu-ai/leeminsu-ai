<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>${boardDto.boardNo} 게시글 수정</h1>

<%-- textarea에는 value가 없다 --%>
<form action="edit" method="post">
	<input type="hidden" name="boardNo" value="${boardDto.boardNo}">
	
	<c:if test="${sessionScope.loginLevel == '관리자'}">
	<input type="checkbox" name="boardNotice" value="Y" 
			${boardDto.boardNotice == 'Y' ? 'checked' : ''}> 공지사항으로 등록 <br><br>
	</c:if>
	
	<input type="text" name="boardTitle" value="${boardDto.boardTitle}" required> <br><br>
	<textarea name="boardContent" rows="5" cols="80">${boardDto.boardContent}</textarea>
	<br><br>
	<button>수정하기</button>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>