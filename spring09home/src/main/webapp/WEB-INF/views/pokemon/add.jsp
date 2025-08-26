<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>포켓몬 등록</h1>

<form action="add" method="post">
	<input type="text" name="pokemonName" placeholder="포켓몬 이름"><br><br>
	<input type="text" name="pokemonType" placeholder="포켓몬 속성"><br><br>
	<button>등록</button>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>