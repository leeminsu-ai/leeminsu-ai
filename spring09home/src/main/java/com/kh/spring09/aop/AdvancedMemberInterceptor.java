package com.kh.spring09.aop;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.spring09.error.NeedPermissionException;
import com.kh.spring09.error.UnauthorizationException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Service
public class AdvancedMemberInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();//세션객체를 추출
		
		String loginId = (String)session.getAttribute("loginId");
		String loginLevel = (String)session.getAttribute("loginLevel");
		
		if(loginId == null || loginLevel == null) 
			throw new UnauthorizationException("로그인이 필요합니다");
		
		if(loginLevel.equals("일반회원"))
			throw new NeedPermissionException("권한이 부족합니다");
		
		return true;//위에서 차단당하지 않았으면 통과
	}
}	