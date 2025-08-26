<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%-- 
         JSP
         -Java Server Page(자바를 기반으로 만든 화면)
         -자바 코드와 HTML을 섞어서 사용할 수 있다.(그래서어렵다)
         -HTML을 먼저배우고 자바 코드와 섞어서 사용하는 법을 배운다.
         -맨 위에 작성되는 설정은 지우면 안된다 
         -contentType은 사용자가 받을 화면을 형태를 정의한다.(MIME-Type ,대분류/소분류)
         -pageEncoding은 내부적으로 변환할때 적용시킬 글자셋을 의미
    --%>
    
    <h1>1번 예제</h1>
    
    <%-- 
    HTML
    -HyperText Markup Language
    -미리정의된 태그를 이용하여 구조를 구현(지정된 영역에 정해진 효과를 부여)
    h로 시작하는 태그는 heading 태그라고 부른다
    --%>
    
    아무런 태그없이 작성한 일반 글자
    
    <h1>태그로 감싼 글자</h1>
    <h2>태그로 감싼 글자</h2>
    <h3>태그로 감싼 글자</h3>
    <hr>
    <h4>태그로 감싼 글자</h4>
	<h5>태그로 감싼 글자</h5>
     <h6>태그로 감싼 글자</h6>
     
     <%--
     	a태그는 클릭하여 다른 페이지로 연결되는 하이퍼링크를 생성할떄 사용
     	태그만으로 정보가 부족한경우 속성을 사용하여 추가 정보를 제공
     	--%>
<a href="https://www.google.com/"> 구글로 이동</a>
     	
     	<a href="https://www.naver.com/">네이버 이동</a>
     	<a href="http://localhost:8080/hello">hello 페이지로 이동(절대경로)</a>
     	     	<a href="./hello">hello 페이지로 이동(상대경로)</a>
     	
     	<%-- h1태그와 a 태그를합쳐서 구글로 이동하는 큰제목 링크를만들어봅시다--%>
     	
     <h1>	<a href="https://www.google.com/"> 구글로 이동</a></h1>
     
    