<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>회원 정보 수정</h1>

<form action="edit" method="post">
	<input type="text" name="memberNickname" value="${memberDto.memberNickname}" required> <br><br>
	<input type="text" name="memberEmail" value="${memberDto.memberEmail}" required inputmode="email"> <br><br>
	<input type="date" name="memberBirth" value="${memberDto.memberBirth}"> <br><br>
	<input type="text" name="memberContact" value="${memberDto.memberContact}"> <br><br>
	<input type="text" name="memberPost" value="${memberDto.memberPost}" inputmode="numeric" size="6"> <br>
	<input type="text" name="memberAddress1" value="${memberDto.memberAddress1}"><br>
	<input type="text" name="memberAddress2" value="${memberDto.memberAddress2}"><br><br>
	<input type="password" name="memberPw" placeholder="확인용 비밀번호" required><br><br>
	<button>정보 변경하기</button>
</form>

<c:if test="${param.error != null}">
	<h3 style="color:red">비밀번호가 일치하지 않습니다</h3>
</c:if>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>


