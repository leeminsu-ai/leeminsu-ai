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

import com.kh.spring09.dao.StudentDao;
import com.kh.spring09.dto.StudentDto;
import com.kh.spring09.error.TargetNotfoundException;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentDao studentDao;
	
//	@RequestMapping(value = "/add", method = RequestMethod.GET)
	@GetMapping("/add")
	public String add1() {
		return "/WEB-INF/views/student/add.jsp";
	}
	@PostMapping("/add")
	public String add2(@ModelAttribute StudentDto studentDto) {
		studentDao.insert(studentDto);
		return "redirect:addFinish";
	}
	@RequestMapping("/addFinish")
	public String addFinish() {
		return "/WEB-INF/views/student/addFinish.jsp";
	}
	
	@RequestMapping("/list")
	public String list(Model model, 
			@RequestParam(required = false) String column, 
			@RequestParam(required = false) String keyword) {
		boolean isSearch = column != null && keyword != null;
		model.addAttribute("isSearch", isSearch);
		model.addAttribute("column", column);
		model.addAttribute("keyword", keyword);
		if(isSearch) {//검색
			List<StudentDto> studentList = studentDao.selectList(column, keyword);
			model.addAttribute("studentList", studentList);//화면에서 사용 가능하도록 이름 붙여서 전달
		}
		else {//목록
			List<StudentDto> studentList = studentDao.selectList();
			model.addAttribute("studentList", studentList);//화면에서 사용 가능하도록 이름 붙여서 전달
		}
		return "/WEB-INF/views/student/list.jsp";
	}
	
	@RequestMapping("/detail")
	public String detail(@RequestParam int studentNo, Model model) {
		StudentDto studentDto = studentDao.selectOne(studentNo);
		if(studentDto == null) throw new TargetNotfoundException("존재하지 않는 학생 번호");
		model.addAttribute("studentDto", studentDto);
		return "/WEB-INF/views/student/detail.jsp";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam int studentNo, Model model) {
		StudentDto studentDto = studentDao.selectOne(studentNo);
		if(studentDto == null) throw new TargetNotfoundException("존재하지 않는 학생 번호");
		model.addAttribute("studentDto", studentDto);
		return "/WEB-INF/views/student/edit.jsp";
	}
	@PostMapping("/edit")
	public String edit(@ModelAttribute StudentDto studentDto) {
		studentDao.update(studentDto);
		return "redirect:detail?studentNo="+studentDto.getStudentNo();
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam int studentNo) {
		StudentDto studentDto = studentDao.selectOne(studentNo);
		if(studentDto == null) throw new TargetNotfoundException("존재하지 않는 학생 정보");
		studentDao.delete(studentNo);
		return "redirect:list";
	}
	
}




