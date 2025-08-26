<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>학생 상세정보</h1>

<c:choose>
	<c:when test="${studentDto == null}">
		<h3>존재하지 않는 학생 번호</h3>
	</c:when>
	<c:otherwise>
		<table border="1" width="400">
			<tr>
				<th>번호</th>
				<td>${studentDto.studentNo}</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${studentDto.studentName}</td>
			</tr>
			<tr>
				<th>국어</th>
				<td>${studentDto.studentKor}점</td>
			</tr>
			<tr>
				<th>영어</th>
				<td>${studentDto.studentEng}점</td>
			</tr>
			<tr>
				<th>수학</th>
				<td>${studentDto.studentMat}점</td>
			</tr>
			<tr>
				<th>총점</th>
				<td>${studentDto.total}점</td>
			</tr>
			<tr>
				<th>평균</th>
				<td>
					<fmt:formatNumber value="${studentDto.average}" pattern="0.00"/>
				</td>
			</tr>
			<tr>
				<th>등록일</th>
				<td>
					<fmt:formatDate value="${studentDto.studentReg}" pattern="y년 M월 d일 E a h시 m분 s초"/>
				</td>
			</tr>
		</table>
	</c:otherwise>
</c:choose>

<%-- <c:if test="${studentDto == null}"></c:if> --%>
<%-- <c:if test="${studentDto != null}"></c:if> --%>

<h2><a href="add">신규 등록</a></h2>
<h2><a href="list">목록으로 이동</a></h2>
<h2><a href="edit?studentNo=${studentDto.studentNo}">정보 수정하기</a></h2>
<h2><a href="delete?studentNo=${studentDto.studentNo}">정보 삭제하기</a></h2>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
