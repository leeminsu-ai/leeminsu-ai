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

import com.kh.spring09.dao.BookDao;
import com.kh.spring09.dto.BookDto;
import com.kh.spring09.error.TargetNotfoundException;

@Controller
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookDao bookDao;
	
//	//(+추가) 이 컨트롤러로 들어오는 empty string은 이제부터 null이다
//	@InitBinder//컨트롤러가 미리 알아야 하는 내용을 알려주기 위한 메소드(전처리 메소드)
//	public void initBinder(WebDataBinder binder) {
//		//binder.registerCustomEditor(데이터종류, 사용할도구);
//		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
//	}
	
	@GetMapping("/save")
	public String save() {
		return "/WEB-INF/views/book/save.jsp";
	}
	@PostMapping("/save")
	public String save(@ModelAttribute BookDto bookDto) {
		bookDao.insert(bookDto);
		return "redirect:saveFinish";
	}
	@RequestMapping("/saveFinish")
	public String saveFinish() {
		return "/WEB-INF/views/book/saveFinish.jsp";
	}
	
	
	@RequestMapping("/list")
	public String list(Model model, 
			@RequestParam(required = false) String column,
			@RequestParam(required = false) String keyword) {
		boolean isSearch = column != null && keyword != null;
		model.addAttribute("column", column);
		model.addAttribute("keyword", keyword);
		if(isSearch) {
			List<BookDto> bookList = bookDao.selectList(column, keyword);
			model.addAttribute("bookList", bookList);
		}
		else {
			List<BookDto> bookList = bookDao.selectList();
			model.addAttribute("bookList", bookList);
		}
		return "/WEB-INF/views/book/list.jsp";
	}
	
	@RequestMapping("/detail")
	public String detail(@RequestParam int bookId, Model model) {
		BookDto bookDto = bookDao.selectOne(bookId);
		if(bookDto == null) throw new TargetNotfoundException("존재하지 않는 도서 정보");
		model.addAttribute("bookDto", bookDto);
		return "/WEB-INF/views/book/detail.jsp";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam int bookId, Model model) {
		BookDto bookDto = bookDao.selectOne(bookId);
		if(bookDto == null) throw new TargetNotfoundException("존재하지 않는 도서 정보");
		model.addAttribute("bookDto", bookDto);
		return "/WEB-INF/views/book/edit.jsp";//forward
	}
	@PostMapping("/edit")
	public String edit(@ModelAttribute BookDto bookDto) {
		bookDao.update(bookDto);
		return "redirect:detail?bookId="+bookDto.getBookId();//redirect
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam int bookId) {
		BookDto bookDto = bookDao.selectOne(bookId);
		if(bookDto == null) throw new TargetNotfoundException("존재하지 않는 도서 정보");
		bookDao.delete(bookId);
		return "redirect:list";
	}
}







