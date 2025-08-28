package com.kh.spring09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring09.dao.MemberDao;
import com.kh.spring09.dto.MemberDto;
import com.kh.spring09.error.TargetNotfoundException;

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
			//model.addAttribute("memberList", memberDao.selectList());
		}
		return "/WEB-INF/views/admin/member/list.jsp";
	}
	
	@RequestMapping("/detail")
	public String detail(@RequestParam String memberId, Model model) {
		MemberDto memberDto = memberDao.selectOne(memberId);
		if(memberDto == null) throw new TargetNotfoundException("존재하지 않는 회원");
		model.addAttribute("memberDto", memberDto);
		return "/WEB-INF/views/admin/member/detail.jsp";
	}
	
	@RequestMapping("/drop")
	public String drop(@RequestParam String memberId) {
		MemberDto memberDto = memberDao.selectOne(memberId);
		if(memberDto == null) throw new TargetNotfoundException("존재하지 않는 회원");
		memberDao.delete(memberId);
		return "redirect:list";
		//return "redirect:/admin/member/list";
	}
	
	@GetMapping("/edit")
	public String edit(Model model, @RequestParam String memberId) {
		MemberDto memberDto = memberDao.selectOne(memberId);//정보를 조회하고
		if(memberDto == null) throw new TargetNotfoundException("존재하지 않는 회원 정보");
		model.addAttribute("memberDto", memberDto);
		return "/WEB-INF/views/admin/member/edit.jsp";
	}
	@PostMapping("/edit")
	public String edit(@ModelAttribute MemberDto memberDto) {
		memberDao.updateMemberByAdmin(memberDto);
		return "redirect:detail?memberId="+memberDto.getMemberId();
	}
}









