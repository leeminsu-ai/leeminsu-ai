<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>${memberDto.memberId}님의 정보</h1>

<table border="1" width="500">
	<tr>
		<th>닉네임</th>
		<td>${memberDto.memberNickname}</td>
	</tr>
	<tr>
		<th>이메일</th>
		<td>${memberDto.memberEmail}</td>
	</tr>
	<tr>
		<th>생년월일</th>
		<td>${memberDto.memberBirth}</td>
	</tr>
	<tr>
		<th>연락처</th>
		<td>${memberDto.memberContact}</td>
	</tr>
	<tr>
		<th>등급</th>
		<td>${memberDto.memberLevel}</td>
	</tr>
	<tr>
		<th>포인트</th>
		<td>${memberDto.memberPoint}포인트</td>
	</tr>
	<tr>
		<th>주소</th>
		<td>
			<c:if test="${memberDto.memberPost != null}">
			[${memberDto.memberPost}] 
			${memberDto.memberAddress1} 
			${memberDto.memberAddress2}
			</c:if>
		</td>
	</tr>
	<tr>
		<th>가입일</th>
		<td>
			<fmt:formatDate value="${memberDto.memberJoin}" pattern="y년 M월 d일 H시 m분 s초"/>
		</td>
	</tr>
</table>

<h2><a href="list">검색화면으로 돌아가기</a></h2>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>


