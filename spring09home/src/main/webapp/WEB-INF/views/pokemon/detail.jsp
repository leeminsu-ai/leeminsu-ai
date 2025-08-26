<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>포켓몬 상세정보</h1>

<table border="1" width="400">
	<tr>
		<th width="25%">번호</th>
		<td>${pokemonDto.pokemonNo}</td>
	</tr>
	<tr>
		<th>이름</th>
		<td>${pokemonDto.pokemonName}</td>
	</tr>
	<tr>
		<th>속성</th>
		<td>${pokemonDto.pokemonType}</td>
	</tr>
</table>

<h2><a href="list">목록으로 이동</a></h2>
<h2><a href="edit?pokemonNo=${pokemonDto.pokemonNo}">수정하기</a></h2>
<h2><a href="delete?pokemonNo=${pokemonDto.pokemonNo}">삭제하기</a></h2>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>






