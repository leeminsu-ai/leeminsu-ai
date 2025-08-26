package com.kh.spring09.aop;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.spring09.error.UnauthorizationException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Service
public class MemberLoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(
			HttpServletRequest request, 		//요청 정보가 담긴 객체 (사용자의 정보)
			HttpServletResponse response, 	//응답 정보가 담긴 객체 (사용자에게 나갈 정보)
			Object handler)
			throws Exception {
		
		//사용자의 정보를 조회하고 싶을 때 (ex : 파라미터, 세션, 쿠키, ...)는 HttpServletRequest 사용
		//사용자의 결과화면을 제어하고 싶을 때 (ex : 에러처리, 리다이렉트)는 HttpServletResponse 사용
		//= 정보는 똑같이 있는데 Spring처럼 달라는대로 주진 않는다 (일반적인 Java EE의 방식)
		HttpSession session = request.getSession();
		
		String loginId = (String) session.getAttribute("loginId");
		boolean isMember = loginId != null;
		
		if(isMember) {//회원이면
			return true;//통과
		}
		else {
			throw new UnauthorizationException("로그인이 필요합니다");
		}
	}
}



