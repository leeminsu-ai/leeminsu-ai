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

import com.kh.spring09.dao.PokemonDao;
import com.kh.spring09.dto.PokemonDto;
import com.kh.spring09.error.TargetNotfoundException;

@Controller//@RestController랑 똑같이 처리를 하는데 마지막이 화면
@RequestMapping("/pokemon")
public class PokemonController {
	@Autowired
	private PokemonDao pokemonDao;

	//GET 방식의 요청만 처리하는 매핑
	@GetMapping("/add")
	public String add() {
		return "/WEB-INF/views/pokemon/add.jsp";
	}
	
	//POST 방식의 요청만 처리하는 매핑
	@PostMapping("/add")
	public String add(@ModelAttribute PokemonDto pokemonDto) {
		pokemonDao.insert(pokemonDto);
		return "redirect:addFinish";
	}
	
	@RequestMapping("/addFinish")
	public String addFinish() {
		return "/WEB-INF/views/pokemon/addFinish.jsp";
	}
	
//	목록 페이지 매핑
//	- 컨트롤러의 역할은 단순한 페이지 연결이 아님
//	- 주요 역할 중 하나가 페이지에 필요한 데이터 전달
//	- 전달할 데이터가 있다면 매개변수에 Model 선언 (자동으로 생성됨)
//	- model.addAttribute("이름", 값) 형태로 전달
	@RequestMapping("/list")
	public String list(Model model, 
			@RequestParam(required = false) String column, 
			@RequestParam(required = false) String keyword) {
		//column과 keyword의 상태에 따라 검색인지 아닌지 판정
		boolean isSearch = column != null && keyword != null;
		if(isSearch) {//검색이라면
			List<PokemonDto> pokemonList = pokemonDao.selectList(column, keyword);
			model.addAttribute("pokemonList", pokemonList);
		}
		else {//목록이라면
			List<PokemonDto> pokemonList = pokemonDao.selectList();
			model.addAttribute("pokemonList", pokemonList);
		}
		return "/WEB-INF/views/pokemon/list.jsp";
	}
	
//	상세 페이지 매핑
	@RequestMapping("/detail")
	public String detail(@RequestParam int pokemonNo, Model model) {
		PokemonDto pokemonDto = pokemonDao.selectOne(pokemonNo);
		if(pokemonDto == null) {
			throw new TargetNotfoundException("존재하지 않는 몬스터 번호");//내가 만든 예외
		}
		model.addAttribute("pokemonDto", pokemonDto);
		return "/WEB-INF/views/pokemon/detail.jsp";
	}
	
//	수정 매핑
//	- 입력과 처리 두 단계로 나눠져 있다
//	- GET / POST로 구분하고 주소를 통일
	@GetMapping("/edit")
	public String edit(@RequestParam int pokemonNo, Model model)  {
		PokemonDto pokemonDto = pokemonDao.selectOne(pokemonNo);
		if(pokemonDto == null) {
			//return "redirect:list";
			//return "redirect:에러페이지매핑";
			//throw new Exception("존재하지 않는 몬스터 번호");//unchecked exception
			//throw new RuntimeException("존재하지 않는 몬스터 번호");//checked exception
			throw new TargetNotfoundException("존재하지 않는 몬스터 번호");//내가 만든 예외
		}
		model.addAttribute("pokemonDto", pokemonDto);
		return "/WEB-INF/views/pokemon/edit.jsp";
	}
	
	@PostMapping("/edit")
	public String edit(@ModelAttribute PokemonDto pokemonDto) {
		pokemonDao.update(pokemonDto);
		return "redirect:detail?pokemonNo="+pokemonDto.getPokemonNo();
	}
	
//	삭제 매핑
	@RequestMapping("/delete")
	public String delete(@RequestParam int pokemonNo) {
		PokemonDto pokemonDto = pokemonDao.selectOne(pokemonNo);
		if(pokemonDto == null) throw new TargetNotfoundException("존재하지 않는 몬스터 정보");
		pokemonDao.delete(pokemonNo);
		return "redirect:list";
	}
}




