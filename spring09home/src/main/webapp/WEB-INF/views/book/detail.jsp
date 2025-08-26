<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<c:choose>
	<c:when test="${bookDto != null}">
		<h1>『${bookDto.bookTitle}』 상세 정보</h1>
		
		<table border="1" width="400">
			<tr>
				<th width="30%">도서번호</th>
				<td>${bookDto.bookId}</td>
			</tr>
			<tr>
				<th>도서명</th>
				<td>${bookDto.bookTitle}</td>
			</tr>
			<tr>
				<th>저자</th>
				<td>${bookDto.bookAuthor}</td>
			</tr>
			<tr>
				<th>출판사</th>
				<td>${bookDto.bookPublisher}</td>
			</tr>
			<tr>
				<th>출간일</th>
				<td>${bookDto.bookPublicationDate}</td>
			</tr>
			<tr>
				<th>판매가</th>
				<td>
					<fmt:formatNumber value="${bookDto.bookPrice}" pattern="#,##0"></fmt:formatNumber>
					원
				</td>
			</tr>
			<tr>
				<th>페이지수</th>
				<td>
					<fmt:formatNumber value="${bookDto.bookPageCount}" pattern="#,##0"></fmt:formatNumber>
				</td>
			</tr>
			<tr>
				<th>장르</th>
				<td>${bookDto.bookGenre}</td>
			</tr>
		</table>
	</c:when>
	<c:otherwise>
		<h1>존재하지 않는 도서</h1>
	</c:otherwise>
</c:choose>

<h2><a href="save">신규 도서 등록</a></h2>
<h2><a href="list">목록으로 이동</a></h2>
<h2><a href="edit?bookId=${bookDto.bookId}">도서 정보 수정</a></h2>
<h2><a href="delete?bookId=${bookDto.bookId}">도서 정보 삭제</a></h2>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>