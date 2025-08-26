<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>도서 등록</h1>

<form action="save" method="post">
	<input type="text" name="bookTitle" placeholder="도서 제목"><br><br>
	<input type="text" name="bookAuthor" placeholder="저자"><br><br>
	<input type="text" name="bookPublisher" placeholder="출판사"><br><br>
	<input type="date" name="bookPublicationDate"><br><br>
	<input type="text" name="bookPrice" placeholder="판매가격" inputmode="numeric"><br><br>
	<input type="text" name="bookPageCount" placeholder="페이지 수" inputmode="numeric"><br><br>
	<input type="text" name="bookGenre" placeholder="장르"><br><br>
	<button>등록하기</button>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
