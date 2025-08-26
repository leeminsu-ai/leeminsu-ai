<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>    

<h1>도서 목록/검색</h1>

<h2><a href="save">신규 도서 등록</a></h2>

<!-- <form action="/book/list"> -->
<form action="list">
	<select name="column">
		<option value="book_title" ${column == "book_title" ? "selected" : ""}>도서명</option>
		<option value="book_author" ${column == "book_author" ? "selected" : ""}>저자</option>
		<option value="book_publisher" ${column == "book_publisher" ? "selected" : ""}>출판사</option>
		<option value="book_publication_date" ${column == "book_publication_date" ? "selected" : ""}>출간일</option>
		<option value="book_genre" ${column == "book_genre" ? "selected" : ""}>장르</option>
	</select>
	<%-- 필수항목에는 required="required" 추가를 하며, 값은 생략이 가능하다 --%>
	<input type="text" name="keyword" placeholder="검색어" required value="${keyword}">
	<button>검색</button>
</form>

<table border="1" width="900">
	<thead>
		<tr>
			<th>도서번호</th>
			<th>도서명</th>
			<th>저자</th>
			<th>출판사</th>
			<th>출간일</th>
			<th>판매가</th>
			<th>페이지수</th>
			<th>장르</th>
		</tr>		
	</thead>
	<tbody align="center">
		<c:forEach var="bookDto" items="${bookList}">
		<tr>
			<td>${bookDto.bookId}</td>
			<td>
				<a href="detail?bookId=${bookDto.bookId}">
					${bookDto.bookTitle}
				</a>
			</td>
			<td>${bookDto.bookAuthor}</td>
			<td>${bookDto.bookPublisher}</td>
			<td>${bookDto.bookPublicationDate}</td>
			<td align="right">
				<fmt:formatNumber value="${bookDto.bookPrice}" pattern="#,##0"/>
			</td>
			<td align="right">
				<fmt:formatNumber value="${bookDto.bookPageCount}" pattern="#,##0"></fmt:formatNumber>
			</td>
			<td>${bookDto.bookGenre}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>



