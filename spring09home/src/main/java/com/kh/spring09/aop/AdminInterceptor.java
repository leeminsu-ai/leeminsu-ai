package com.kh.spring09.aop;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.spring09.error.NeedPermissionException;
import com.kh.spring09.error.UnauthorizationException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Service
public class AdminInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		
		String loginId = (String) session.getAttribute("loginId");
		String loginLevel = (String) session.getAttribute("loginLevel");
		
		if(loginId == null || loginLevel == null)
			throw new UnauthorizationException("로그인 필요");
		if(loginLevel.equals("관리자") == false)
			throw new NeedPermissionException("권한 부족");
		
		return true;
	}
}
