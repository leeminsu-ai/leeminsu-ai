<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<link rel="icon" href="/favicon.ico">

<div>
	<h1>KH정보교육원 스프링개발자 수업자료</h1>
</div>
<hr>

<div>
	세션ID : ${pageContext.session.id} - loginId : ${sessionScope.loginId}
	 , loginLevel : ${sessionScope.loginLevel}
</div>
<div>
	
	<c:choose>
		<c:when test="${loginId != null && loginLevel == '일반회원'}">
			<a href="/">홈</a>
			<a href="/pokemon/list">포켓몬정보</a>
			<a href="/student/list">학생정보</a>
			<a href="/board/list">게시판</a>
			<a href="/member/mypage">내정보</a>
			<a href="/member/logout">로그아웃</a>
		</c:when>
		<c:when test="${loginId != null && loginLevel == '우수회원'}">
			<a href="/">홈</a>
			<a href="/pokemon/list">포켓몬정보</a>
			<a href="/student/list">학생정보</a>
			<a href="/board/list">게시판</a>
			<a href="/book/list">도서정보</a>
			<a href="/member/mypage">내정보</a>
			<a href="/member/logout">로그아웃</a>
		</c:when>
		<c:when test="${loginId != null && loginLevel == '관리자'}">
			<a href="/">홈</a>
			<a href="/pokemon/list">포켓몬정보</a>
			<a href="/student/list">학생정보</a>
			<a href="/board/list">게시판</a>
			<a href="/book/list">도서정보</a>
			<a href="/member/list">회원검색</a>
			<a href="/member/logout">로그아웃</a>
			<a href="/admin/home">[관리메뉴]</a>
		</c:when>
		<c:otherwise>
			<a href="/">홈</a>
			<a href="/pokemon/list">포켓몬정보</a>
			<a href="/member/join">회원가입</a>
			<a href="/member/login">로그인</a>
		</c:otherwise>
	</c:choose>
	
</div>
<hr>
<div style="min-height:400px">