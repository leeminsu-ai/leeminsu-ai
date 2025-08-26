<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>가입 정보 입력</h1>

<form action="join" method="post">
	<input type="text" name="memberId" placeholder="아이디" required> <br><br>
	<input type="password" name="memberPw" placeholder="비밀번호" required> <br><br>
	<input type="text" name="memberNickname" placeholder="닉네임" required> <br><br>
	<input type="text" name="memberEmail" placeholder="이메일" required inputmode="email"> <br><br>
	<input type="date" name="memberBirth"> <br><br>
	<input type="text" name="memberContact" placeholder="휴대전화번호" inputmode="tel"> <br><br>
	<input type="text" name="memberPost" placeholder="우편번호" size="6"> <br><br>
	<input type="text" name="memberAddress1" placeholder="기본주소" size="60"> <br><br>
	<input type="text" name="memberAddress2" placeholder="상세주소" size="60"> <br><br>
	<button>회원가입</button>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>







