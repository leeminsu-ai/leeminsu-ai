package com.kh.spring07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller  //화면을 연결해주는 처리도구
public class ViewController {

		@RequestMapping("/hello")
		public String hello() {
			return"/WEB-INF/views/hello.jsp";
		}
		
		@RequestMapping("/test01")
		public String test01() {
			return "/WEB-INF/views/test01.jsp";
		}
		@RequestMapping("/test02")
		public String test02(){
			return "/WEB-INF/views/test02.jsp";
		}
		
		@RequestMapping("/test03")
		public String test03() {
			return"/WEB-INF/views/test03.jsp";
		}
		@RequestMapping("/test04")
		public String test04() {
			return "/WEB-INF/views/test04.jsp";
		}
}
