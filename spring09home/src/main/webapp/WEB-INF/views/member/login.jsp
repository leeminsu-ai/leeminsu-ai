<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>로그인</h1>

<form action="login" method="post">
	<input type="text" name="memberId" placeholder="ID" required> <br><br>
	<input type="password" name="memberPw" placeholder="Password" required> <br><br>
	<button>로그인</button>	
</form>

<%--  error라는 파라미터가 존재한다면 오류 메세지를 출력 --%>
<c:if test="${param.error != null}">
	<h2 style="color:red">입력하신 정보가 일치하지 않습니다</h2>
</c:if>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>


