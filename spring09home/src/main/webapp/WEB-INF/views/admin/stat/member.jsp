<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>등급별 회원 현황</h1>

<table border="1" width="350">
	<thead>
		<tr>
			<th width="50%">회원 등급</th>
			<th>회원 수</th>
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