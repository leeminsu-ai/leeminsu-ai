<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- <div>${pageVO}</div> --%>

<c:if test="${pageVO != null && pageVO.dataCount > 0}">

<%-- 페이지 네비게이터 (pageVO의 내용을 토대로 작성) --%>
<h2>

<c:if test="${pageVO.firstBlock == false}">
<a href="list?page=${pageVO.prevPage}&${pageVO.searchParams}">이전</a>
</c:if>

<c:forEach var="i" begin="${pageVO.blockStart}" end="${pageVO.blockFinish}" step="1">
	<c:choose>
		<c:when test="${pageVO.page == i}">
			<%-- 현재 페이지일 경우 클릭하여 이동할 수 없도록 처리 --%>
			<a>${i}</a>		
		</c:when>
		<c:otherwise>
			<%-- 현재 페이지가 아닐 경우 클릭하여 이동하도록 처리 --%>
			<a href="list?page=${i}&${pageVO.searchParams}">${i}</a>		
		</c:otherwise>
	</c:choose>
</c:forEach>

<c:if test="${pageVO.lastBlock == false}">
<a href="list?page=${pageVO.nextPage}&${pageVO.searchParams}">다음</a>
</c:if>

</h2>

</c:if>