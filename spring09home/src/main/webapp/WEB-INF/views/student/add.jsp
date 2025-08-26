<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>학생 정보 입력</h1>

<form action="add" method="post">
	<input type="text" name="studentName" placeholder="학생명"> <br><br>
	<input type="text" name="studentKor" placeholder="국어점수" inputmode="numeric"> <br><br>
	<input type="text" name="studentEng" placeholder="영어점수" inputmode="numeric"> <br><br>
	<input type="text" name="studentMat" placeholder="수학점수" inputmode="numeric"> <br><br>
	<button>등록</button>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>