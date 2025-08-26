<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
    
<h1>도서 정보 수정</h1>

<form action="edit" method="post">
	<input type="hidden" name="bookId" value="${bookDto.bookId}">
	
	제목 : <input type="text" name="bookTitle" value="${bookDto.bookTitle}" required> <br><br>
	저자 : <input type="text" name="bookAuthor" value="${bookDto.bookAuthor}"> <br><br>
	출판사 : <input type="text" name="bookPublisher" value="${bookDto.bookPublisher}"> <br><br>
	출간일 : <input type="date" name="bookPublicationDate" value="${bookDto.bookPublicationDate}"> <br><br>
	판매가 : <input type="text" name="bookPrice" value="${bookDto.bookPrice}" inputmode="numeric"> <br><br>
	페이지수 : <input type="text" name="bookPageCount" value="${bookDto.bookPageCount}" inputmode="numeric"> <br><br>
	장르 : <input type="text" name="bookGenre" value="${bookDto.bookGenre}"> <br><br>
	<%--
	<select name="bookGenre">
		<option value="공포" ${bookDto.bookGenre == "공포" ? "selected" : ""}>공포</option>
		<option value="추리" ${bookDto.bookGenre == "추리" ? "selected" : ""}>추리</option>
		<option value="과학" ${bookDto.bookGenre == "과학" ? "selected" : ""}>과학</option>
		<option value="교양" ${bookDto.bookGenre == "교양" ? "selected" : ""}>교양</option>
	</select>
	 --%>
	
	<button>수정하기</button>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>