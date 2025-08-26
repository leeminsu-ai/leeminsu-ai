package com.kh.spring09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//첫페이지 또는 공통페이지(이용약관 등)을 처리하는 컨트롤러
@Controller
public class MainController {

	 @RequestMapping("/")//가장 짧은 주소 부여
	 public String home() {
		 return "/WEB-INF/views/home.jsp";
	 }
	
}
