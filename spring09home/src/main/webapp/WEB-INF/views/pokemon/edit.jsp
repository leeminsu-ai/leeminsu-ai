<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>포켓몬 정보 수정</h1>

<form action="edit" method="post">
	<input type="hidden" name="pokemonNo" value="${pokemonDto.pokemonNo}">
	
	<input type="text" name="pokemonName" value="${pokemonDto.pokemonName}" required> <br><br>
	<input type="text" name="pokemonType" value="${pokemonDto.pokemonType}" required><br><br>
	<button>수정</button>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>