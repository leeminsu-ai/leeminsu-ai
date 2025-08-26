package com.kh.spring09.aop;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.kh.spring09.error.TargetNotfoundException;
import com.kh.spring09.error.UnauthorizationException;

@ControllerAdvice
public class ExceptionControllerAdvice {

	//catch 블럭처럼 사용할 수 있는 도구
	//catch(TargetNotfoundException e) {}
	@ExceptionHandler(TargetNotfoundException.class)
	public String notFound(TargetNotfoundException e, Model model) {
		//컨트롤러에서 작성 가능한 코드라면 뭐든지 가능
		model.addAttribute("title", e.getMessage());
		return "/WEB-INF/views/error/notFound.jsp";
	}
	
	@ExceptionHandler(UnauthorizationException.class)
	public String unauthorize(UnauthorizationException e, Model model) {
		model.addAttribute("title", e.getMessage());
		return "/WEB-INF/views/error/unauthorize.jsp";
	}
	
}


