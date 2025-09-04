<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--
			입력	창은 input, select,text area 태그로 만들수있다.
			-전송버튼은 button 태그로 만들수있다.
			입력창과 전송버튼만으로는 어딘가로 이동하며 데이터를 전달할수없다.
			외부에 form태그를 만들어서 입력창과 버튼을묶고 전송하도록 설정한다
 --%>

<h1>입력 창 만들기</h1>

<form action="https://genie.co.kr/search/searchMain">
<input name="query">
<button>전송</button>
</form>

<hr>

<h1>유튜브 검색창	</h1>

<form action="https://www.youtube.com/results">
<input name="search_query">
<button>검색</button>
</form>

<h1>Github 검색창</h1>
<form action="https://github.com/search">
<input name="q" placeholder="검색할 저장소명 입력">
<input type="hidden""type"value="repositories">
<button>검색</button>
</form>

<%-- select는 보기를주고 그 중에서 입력하는 태그 --%>
<h1>쿠팡 검색창</h1>
<form action=https://www.coupang.com/np/search>
<select name="component">
<option value="">전체</option>
<option value="564553">패션의류</option>
<option value="176422">뷰티</option>
<option value="1941676">식품</option>
</select>

<input type="text" name="q" placeholder="찾고 싶은 상품을 검색해보세요!">
<input type="hidden" name="channel"value="user">
<button>검색</button>

</form>