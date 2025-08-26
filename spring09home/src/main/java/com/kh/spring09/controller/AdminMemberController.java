package com.kh.spring09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring09.dao.MemberDao;

@Controller
@RequestMapping("/admin/member")
public class AdminMemberController {
	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping("/list")
	public String list(Model model, 
			@RequestParam(required = false) String column,
			@RequestParam(required = false) String keyword) {
		boolean isSearch = column != null && keyword != null;
		//column, keyword는 넘기지 않고 JSP가 자체적으로 해결
		if(isSearch) {
			model.addAttribute("memberList", memberDao.selectList(column, keyword));
		}
		else {
			model.addAttribute("memberList", memberDao.selectList());
		}
		return "/WEB-INF/views/admin/member/list.jsp";
	}
	
}
