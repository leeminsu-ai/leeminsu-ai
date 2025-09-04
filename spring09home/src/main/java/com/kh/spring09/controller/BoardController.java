package com.kh.spring09.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring09.dao.BoardDao;
import com.kh.spring09.dao.MemberDao;
import com.kh.spring09.dto.BoardDto;
import com.kh.spring09.dto.MemberDto;
import com.kh.spring09.error.NeedPermissionException;
import com.kh.spring09.error.TargetNotfoundException;
import com.kh.spring09.vo.BoardListVO;
import com.kh.spring09.vo.BoardMentionVO;
import com.kh.spring09.vo.PageVO;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardDao boardDao;
	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping("/list")
	public String list(Model model, @ModelAttribute PageVO pageVO) {
		List<BoardListVO> boardNoticeList = boardDao.selectListNotice(pageVO);//공지글
		model.addAttribute("noticeCount", boardNoticeList.size());//공지사항 개수를 전달(배경색 칠하기용)
		List<BoardListVO> boardList = boardDao.selectListWithPaging(pageVO);//전체글
		List<BoardListVO> result = new ArrayList<>();//합성(공지+전체)
		result.addAll(boardNoticeList);
		result.addAll(boardList);
		model.addAttribute("boardList", result);//검색이든 목록이든 한번에 처리
		
		int dataCount = boardDao.count(pageVO);//검색이든 목록이든 카운트를 구해
		pageVO.setDataCount(dataCount);//pageVO에 설정
		
		model.addAttribute("pageVO", pageVO);//전달!
		
		return "/WEB-INF/views/board/list.jsp";
	}
	
	@RequestMapping("/list2")
	public String list2(Model model, @ModelAttribute PageVO pageVO) {
		List<BoardMentionVO> boardList = boardDao.selectListWithMention(pageVO);//전체글
		model.addAttribute("boardList", boardList);//검색이든 목록이든 한번에 처리
		
		int dataCount = boardDao.count(pageVO);//검색이든 목록이든 카운트를 구해
		pageVO.setDataCount(dataCount);//pageVO에 설정
		
		model.addAttribute("pageVO", pageVO);//전달!
		
		return "/WEB-INF/views/board/list2.jsp";
	}
	
//	상세
	@RequestMapping("/detail")
	public String detail(Model model, @RequestParam int boardNo) {
		BoardDto boardDto = boardDao.selectOne(boardNo);
		if(boardDto == null) throw new TargetNotfoundException("존재하지 않는 글 번호");
		model.addAttribute("boardDto", boardDto);//게시글 정보 첨부
		
		if(boardDto.getBoardWriter() != null) {//작성자가 존재한다면(탈퇴하지 않았다면)
			MemberDto memberDto = memberDao.selectOne(boardDto.getBoardWriter()); 
			model.addAttribute("memberDto", memberDto);//작성자 정보 첨부
		}
		
		return "/WEB-INF/views/board/detail.jsp";
	}
	
//	등록
	@GetMapping("/write")
	public String write() {
		return "/WEB-INF/views/board/write.jsp";
	}
	//새글과 답글을 구분하여 값을 계산한 뒤 등록
	//→ 새글은 boardOrigin이 null인 경우를 말함
	//		새글일 경우 그룹번호는 글번호로, 상위글번호는 null로, 차수는 0으로 설정
	//→ 답글은 boardOrigin이 null이 아닌 경우를 말함
	//		답글일 경우 그룹번호를 대상글의 그룹번호로, 상위글번호는 대상글의 글번호로, 차수는 대상글의 차수+1로 설정
	@PostMapping("/write")
	public String write(@ModelAttribute BoardDto boardDto, HttpSession session) {
		String loginId = (String) session.getAttribute("loginId");
		boardDto.setBoardWriter(loginId);
		
		//세션에 있는 등급을 검사해서 관리자가 아닌데 공지사항을 작성하려고 하면 차단 
		//-> 인터셉터를 만들어서 해도 됨
		String loginLevel = (String) session.getAttribute("loginLevel");
		if(loginLevel.equals("관리자") == false && boardDto.getBoardNotice().equals("Y"))
			throw new NeedPermissionException("공지글을 작성할 권한이 없습니다");
		
		//기존 : 번호를 알아서 만들어서 등록
		//변경 : 번호를 미리 구해와서 boardDto에 합쳐서 등록
		
		int boardNo = boardDao.sequence();//번호를 생성해서
		boardDto.setBoardNo(boardNo);//게시글 정보에 합친다
		if(boardDto.getBoardOrigin() == null) {//새글이라면
			boardDto.setBoardGroup(boardNo);//게시글 그룹번호를 설정한다
			//boardDto.setBoardOrigin(null);
			//boardDto.setBoardDepth(0);
		}
		else {//답글이라면
			BoardDto findDto = boardDao.selectOne(boardDto.getBoardOrigin());//상위글정보 조회
			boardDto.setBoardGroup(findDto.getBoardGroup());//대상글의 그룹번호를 그대로 설정
			//boardDto.setBoardOrigin(findDto.getBoardNo());//대상글의 글번호를 그대로 설정(생략가능)
			boardDto.setBoardDepth(findDto.getBoardDepth()+1);//대상글의 차수보다 1 크게 설정
		}
		boardDao.insert(boardDto);//등록
		//return "redirect:list";
		return "redirect:detail?boardNo="+boardNo;
	}
	
//	삭제
	@RequestMapping("/delete")
	public String delete(@RequestParam int boardNo) {
		BoardDto boardDto = boardDao.selectOne(boardNo);
		if(boardDto == null) throw new TargetNotfoundException("존재하지 않는 글");
		boardDao.delete(boardNo);
		return "redirect:list";
	}
	
//	수정
	@GetMapping("/edit")
	public String edit(Model model, @RequestParam int boardNo) {
		BoardDto boardDto = boardDao.selectOne(boardNo);
		if(boardDto == null) throw new TargetNotfoundException("존재하지 않는 글");
		model.addAttribute("boardDto", boardDto);
		return "/WEB-INF/views/board/edit.jsp";
	}
	@PostMapping("/edit")
	public String edit(@ModelAttribute BoardDto boardDto) {
		boardDao.update(boardDto);
		return "redirect:detail?boardNo="+boardDto.getBoardNo();
	}
}







