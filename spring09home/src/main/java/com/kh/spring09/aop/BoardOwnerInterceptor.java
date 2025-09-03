package com.kh.spring09.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.spring09.dao.BoardDao;
import com.kh.spring09.dto.BoardDto;
import com.kh.spring09.error.NeedPermissionException;
import com.kh.spring09.error.TargetNotfoundException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//목표 : 본인 글에만 접근할 수 있도록 처리 (+삭제는 관리자도 접근 가능)
@Service
public class BoardOwnerInterceptor implements HandlerInterceptor {
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String loginId = (String) session.getAttribute("loginId");
		String loginLevel = (String) session.getAttribute("loginLevel");
		
		//[1] 관리자가 삭제 페이지로 가는 경우 통과
		String uri = request.getRequestURI();
		//System.out.println("uri = " + uri);
		if(loginLevel.equals("관리자") && uri.equals("/board/delete")) 
			return true;
		
		//[2] 자기자신이 작성한 글이 아니라면 차단
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		BoardDto boardDto = boardDao.selectOne(boardNo);
		if(boardDto == null) 
			throw new TargetNotfoundException("존재하지 않는 게시글");
		
		if(loginId.equals(boardDto.getBoardWriter()) == false)
			throw new NeedPermissionException("본인의 글만 수정 및 삭제가 가능합니다");

		//그 외에도 여러가지 문제상황들을 사전에 차단
		//if(마음에 안들면) return false;//차단

		return true;//통과
	}
}





