package com.kh.spring09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring09.dao.StatDao;

@Controller
@RequestMapping("/admin/stat")
public class AdminStatController {
	@Autowired
	private StatDao statDao;

	@RequestMapping("/pokemon")
	public String pokemon(Model model) {
		model.addAttribute("statList", statDao.countByPokemonType());
		return "/WEB-INF/views/admin/stat/pokemon.jsp";
	}
	@RequestMapping("/book")
	public String book(Model model) {
		model.addAttribute("statList", statDao.countByBookGenre());
		return "/WEB-INF/views/admin/stat/book.jsp";
	}
	@RequestMapping("/member")
	public String member(Model model) {
		model.addAttribute("statList", statDao.countByMemberLevel());
		return "/WEB-INF/views/admin/stat/member.jsp";
	}
	@RequestMapping("/student")
	public String student(Model model) {
		model.addAttribute("statList", statDao.countByStudentDaily());
		return "/WEB-INF/views/admin/stat/student.jsp";
	}
}









