package com.kh.spring09.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.spring09.dao.MemberDao;
import com.kh.spring09.dto.MemberDto;
import com.kh.spring09.error.NeedPermissionException;
import com.kh.spring09.error.TargetNotfoundException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//관리자 페이지에서 상세, 수정, 삭제를 할 때 관리자는 차단하는 인터셉터
@Service
public class PreventAdminInterceptor implements HandlerInterceptor {
	@Autowired
	private MemberDao memberDao;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//시나리오
		//1. 파라미터에 존재하는 memberId의 값을 불러온다
		String memberId = request.getParameter("memberId");
		if(memberId == null)
			throw new NeedPermissionException("허용되지 않은 접근");
		//2. 아이디에 맞는 회원정보를 조회
		MemberDto memberDto = memberDao.selectOne(memberId);
		if(memberDto == null)
			throw new TargetNotfoundException("존재하지 않는 회원");
		//3. 관리자면 차단
		boolean isAdmin = memberDto.getMemberLevel().equals("관리자");
		if(isAdmin) 
			throw new NeedPermissionException("관리자에 대한 접근 금지");
		
		return true;//통과
	}
}