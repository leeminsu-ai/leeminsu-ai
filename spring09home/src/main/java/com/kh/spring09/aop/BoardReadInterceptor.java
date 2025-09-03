package com.kh.spring09.aop;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.spring09.dao.BoardDao;
import com.kh.spring09.dto.BoardDto;
import com.kh.spring09.error.TargetNotfoundException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Service
public class BoardReadInterceptor implements HandlerInterceptor {
	@Autowired
	private BoardDao boardDao;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String loginId = (String) session.getAttribute("loginId");
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));//글번호
		
		//모든 경우에 통과를 시키지만 특정 상황에서 조회수 증가 처리를 하도록 만드는 것이 목적
		//[1] 작성자 본인은 어떠한 경우에도 조회수가 올라가지 않도록 처리
		BoardDto boardDto = boardDao.selectOne(boardNo);
		if(boardDto == null) throw new TargetNotfoundException("존재하지 않는 게시글");
		if(loginId != null && boardDto.getBoardWriter() != null) {//로그인 + 탈퇴하지 않은 사용자의 글
			if(loginId.equals(boardDto.getBoardWriter())) {//본인글(작성자=사용자)
				return true;//그냥 가라
			}
		}
		
		//[2] 관리자는 그냥 통과
		String loginLevel = (String) session.getAttribute("loginLevel");
		if(loginLevel != null && loginLevel.equals("관리자")) {//로그인되어 있고 등급이 관리자라면
			return true;//그냥 가라
		}
		
		//[3] 여태까지 읽은 글 번호중에 현재 글 번호가 있다면 그냥 통과
		//- 사용자가 들어올때마다 정보가 누적될 수 있는 방법은 현재 세션과 DB 뿐이다
		Set<Integer> history = (Set<Integer>) session.getAttribute("history");//session의 history를 추출
		if(history == null)//기록이 없으면 넌 처음이라고 생각하고
			history = new HashSet<>();//하나 만들어줄게
		//System.out.println("history = " + history);
		if(history.contains(boardNo)) //저장소에 번호가 존재한다면 (읽은적이 있는 글이라면)
			return true;//그냥 가라
		else //저장소에 번호가 존재하지 않는다면 (읽은적이 없는 글이라면)
			history.add(boardNo); //내역에 추가
		session.setAttribute("history", history);//세션을 갱신시켜		
		
		//위에서 차단되지 않았다면 조회수 증가 처리
		boardDao.updateBoardRead(boardNo);//증가시키고
		return true;//가라
	}
}

