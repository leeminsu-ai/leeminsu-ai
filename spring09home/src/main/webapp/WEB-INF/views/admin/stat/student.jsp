<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>일별 학생 등록 현황</h1>

<table border="1" width="350">
	<thead>
		<tr>
			<th width="50%">일자</th>
			<th>등록된 학생 수</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="statVO" items="${statList}">
		<tr>
			<td>${statVO.title}</td>
			<td>
				<fmt:formatNumber value="${statVO.value}" pattern="#,##0"></fmt:formatNumber>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>