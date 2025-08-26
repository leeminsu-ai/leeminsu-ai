<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
    
<%-- 이 페이지에서 반복 등 프로그래밍 태그를 사용하도록 설정 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<h1>포켓몬 목록</h1>
<h2><a href="add">신규 등록</a></h2>

<!-- System.out.println("몬스터 수 : " + pokemonList.size()); -->
<h2>몬스터 수 : ${pokemonList.size()}</h2>

<!-- 검색창 구현 -->
<form action="list" method="get">
	<select name="column">
		<option value="pokemon_name">몬스터명</option>
		<option value="pokemon_type">속성</option>
	</select>
	<input type="search" name="keyword">
	<button>검색</button>
</form>

<table border="1" width="400">
	<thead>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>속성</th>
		</tr>
	</thead>
	<tbody align="center">
<!-- 		for(PokemonDto pokemonDto : pokemonList) { -->
		<c:forEach var="pokemonDto" items="${pokemonList}">
		<tr>
			<td>${pokemonDto.getPokemonNo()}</td>
			<td>
				<a href="detail?pokemonNo=${pokemonDto.pokemonNo}">
					${pokemonDto.getPokemonName()}
				</a>
			</td>
			<td>${pokemonDto.getPokemonType()}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>


