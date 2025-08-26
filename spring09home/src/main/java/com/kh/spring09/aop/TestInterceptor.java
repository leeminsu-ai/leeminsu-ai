package com.kh.spring09.aop;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service//[1] 복합적인 기능을 수행하는 도구로 등록
public class TestInterceptor implements HandlerInterceptor {//[2] 지정된 용도에 맞는 인터페이스 상속
	//[3] 상황에 걸맞는 메소드를 재정의하여 사용 (3개 중에서 선택)
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("테스트 인터셉터 실행");
		return true;
	}
}