<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>글쓰기</h1>
<p>글은 자신의 인격입니다</p>

<form action="write" method="post">
	<%-- 답글일 경우(boardOrigin이 있을 경우) 이것을 전달하는 코드를 작성 --%>
	<c:if test="${param.boardOrigin != null}">
		<input type="hidden" name="boardOrigin" value="${param.boardOrigin}">
	</c:if>
	
	<c:if test="${sessionScope.loginLevel == '관리자'}">
	<%-- 체크박스는 입력창처럼 input으로 작성하며 name과 value를 적어 전송(미체크시 전송안됨) --%>
	<input type="checkbox" name="boardNotice" value="Y"> 공지사항으로 등록 <br><br>
	</c:if>
	
	<input type="text" name="boardTitle" placeholder="제목" required> <br><br>
<!-- 	<input type="text" name="boardContent" placeholder="내용" required>  -->
	<textarea name="boardContent" placeholder="내용" required rows="5" cols="80"></textarea>
	<br><br>
	<button>작성하기</button>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>