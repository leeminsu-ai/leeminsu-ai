<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	컨트롤러에서 전달되는 Model에 담긴 데이터를 이용하여 화면을 구현
	- EL(Expression Language, 표현 언어)을 사용하여 데이터를 불러오는 작업
	- JSTL(Jsp Standard Tag Library, JSP 표준 태그 모음)을 사용하여 프로그래밍 처리를 수행 (사용설정 필요)
	- 날것의 자바코드를 절대로 JSP에서 사용하지 않는다
	
	현재 컨트롤러에서 전달된 데이터의 이름은 studentList이고
	이것을 불러오려면 ${studentList}라고 써야한다
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>학생 ${isSearch ? "검색" : "목록"}</h1>

<h2><a href="add">신규 학생 등록</a></h2>

<h2>등록된 학생 수 : ${studentList.size()}명</h2>

<form action="list" method="get">
	<select name="column">
		<option value="student_name">학생명</option>
	</select>
	<input type="search" name="keyword" placeholder="검색어 입력" value="${keyword}">
	<button>검색</button>
</form>

<table border="1" width="800">
	<thead>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>국어</th>
			<th>영어</th>
			<th>수학</th>
			<th>총점</th>
			<th>평균</th>
			<th>등록일</th>
		</tr>
	</thead>
	<tbody align="center">
		<c:forEach var="studentDto" items="${studentList}">
		<tr>
			<td>${studentDto.studentNo}</td>
			<td>
				<a href="detail?studentNo=${studentDto.studentNo}">
					${studentDto.studentName}
				</a>
			</td>
			<td>${studentDto.studentKor}</td>
			<td>${studentDto.studentEng}</td>
			<td>${studentDto.studentMat}</td>
			<td>${studentDto.total}</td>
<%-- 			<td>${studentDto.average}</td> --%>
			<td>
				<fmt:formatNumber value="${studentDto.average}" pattern="#,##0.00"/>
			</td>
<%-- 			<td>${studentDto.studentReg}</td> --%>
			<td>
				<fmt:formatDate value="${studentDto.studentReg}" pattern="y년 M월 d일"/>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>

