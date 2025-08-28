package com.kh.spring09.controller;

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
import com.kh.spring09.dto.BoardDto;

@Controller
@RequestMapping("/board")

public class BoardController {

	@Autowired
	private BoardDao boardDao;
	
	@GetMapping("/list")
	public String list(Model model,@RequestParam(required=false)String column,
				@RequestParam(required=false)String keyword)
	{
		List<BoardDto>list=boardDao.selectList(column,keyword);
		model.addAttribute("list",list);
		return "/WEB-INF/views/board/list.jsp";
		
	}
	@GetMapping("/write")
	public String write() {
		return "/WEB-INF/views/board/write.jsp";
	}
	  @GetMapping("/detail")
	    public String detail(@RequestParam int board_no, Model model) {
	        BoardDto dto = boardDao.selectOne(board_no);
	        boardDao.updateReadCount(board_no); // 조회수 증가
	        model.addAttribute("boardDto", dto);
	        return "/WEB-INF/views/board/detail.jsp";
	    }
	   @PostMapping("/write")
	    public String write(@ModelAttribute BoardDto dto) {
	        boardDao.insert(dto);
	        return "redirect:/board/list";
	    }
	   
	   @GetMapping("/delete")
	    public String delete(@RequestParam int board_no) {
	        boardDao.delete(board_no);
	        return "redirect:/board/list";
	    }
	   
	// 글 수정 화면
	    @GetMapping("/edit")
	    public String edit(@RequestParam int board_no, Model model) {
	        BoardDto dto = boardDao.selectOne(board_no);
	        model.addAttribute("dto", dto);
	        return "/WEB-INF/views/board/edit.jsp";
	    }
	    
	    @PostMapping("/edit")
	    public String edit(@ModelAttribute BoardDto dto) {
	        boardDao.update(dto);
	        return "redirect:/board/detail?board_no=" + dto.getBoard_no();
	    }
	}

	
		
	
	
	
	
	
	
	
	

