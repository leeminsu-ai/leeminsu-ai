package com.kh.spring03.controller;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//컨트롤러(Controller)
//-사용자가 접속할수있는 페이지를 제공하는 도구
//화면을 반환하는 Controller가 있고 데이터를 반환하는 RestController가 있다
//개발자가 직접 생성하는 것이아니라 스프링한테 "만들어줘"라고 해야한다.
//스프링이 시작과 동시에 만들어서 보관하고있는다
//@Controller또는 @RestController를 클래스 상단에 붙이면 처리됨 
// 스프링이 주도권을 가지고있는 형태이며 이를 Ioc(Inversion of control 제어반전)이라부른다.

@RestController
public class TestController {

	//실제로 접속하여 결과를 내놓는 매핑이라는걸 추가할수있다 
	//@RequesetMapping 키워드를 메소드 상단에 추가하면된다(사실상등록)
	// 메소드에는 사용자가 받을 내용을 내보내면 된다.
	// 주소는 http://localhost:8080 뒤에올값을 작성한다.
	@RequestMapping("/hello")
	public String hello(){
		return "안녕하세요!";
	}
	
	//원하는 개수만큼 매핑을 생성할수있음 (단 주소는 유일해야함)
	
	
	@RequestMapping("/test01")
	public String test01(){
		Random r= new Random();
		int dice=r.nextInt(6)+1;
		return "주사위:"+dice;
	}
	
	@RequestMapping("/test02")
	public String test02() {
		Random r=new Random();
		int Lotto=r.nextInt(45)+1;
		return "로또번호"+Lotto;
	}
	
	@RequestMapping("/test03")
	public Set<Integer>test03() {
		Set<Integer>lottoNumbers=new TreeSet<>();
		Random r=new Random();
	while(lottoNumbers.size()<6) {
		int number=r.nextInt(45)+1;
		lottoNumbers.add(number);
	}
	return lottoNumbers;
		
	}
	
	//주소에 포함된 파라미터를 읽는방법
	//홈페이지 주소에는 ?가 한개 포함될수있으며 그 뒷부분은 파라미터로 간주
	//파라미터는 ?a=1&b=2&c=3 형태이며 개수에 따라 다름
	//컨트롤러에서는 이름과 형태를 맞춰서 피라미터를 읽을수있음
	
	@RequestMapping("/test04")
	public String test04(String query) {
		return query+"에대한 검색결과를 출력합니다";
	}
	@RequestMapping("/test05")
	public double test05(int usd) {
		return usd*1389.03;
	}
	
	
		
}
