<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>학생 정보 수정</h1>

<form action="edit" method="post">
	<input type="hidden" name="studentNo" value="${studentDto.studentNo}">
	이름 : <input type="text" name="studentName" value="${studentDto.studentName}" required><br><br>
	국어 : <input type="text" name="studentKor" value="${studentDto.studentKor}" inputmode="numeric" required> <br><br>
	영어 : <input type="text" name="studentEng" value="${studentDto.studentEng}" inputmode="numeric" required> <br><br>
	수학 : <input type="text" name="studentMat" value="${studentDto.studentMat}" inputmode="numeric" required> <br><br>
	<button>수정하기</button>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>