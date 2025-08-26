package com.kh.spring04.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring04.dao.PokemonDao;
import com.kh.spring04.dto.PokemonDto;

@RestController
@RequestMapping("/pokemon")
public class PokemonController2 {

	@Autowired
	private PokemonDao pokemonDao;
	
	//객체를 달라고하면 객체의 내부 필드값을 달라는 소리로 해석된다
	//이 때는 @ModelAttribute라고 선언하여 처리한다
	@RequestMapping("/add")
	public String add(@ModelAttribute PokemonDto pokemonDto) {
		pokemonDao.insert(pokemonDto);
		return "등록 완료";
	}
	
//	수정 매핑
	@RequestMapping("/edit")
	public String edit(@ModelAttribute PokemonDto pokemonDto) {
		boolean success = pokemonDao.update(pokemonDto);
		if(success) {
			return "변경 완료";
		}
		else {
			return "존재하지 않는 몬스터 번호";
		}
	}
	
//	삭제 매핑
	@RequestMapping("/delete")
	public String delete(@RequestParam int pokemonNo) {
		boolean success = pokemonDao.delete(pokemonNo);
		
		if(success) {
			return "삭제 완료";
		}
		else {
			return "존재하지 않는 몬스터 번호";
		}
	}
	
//	조회+검색 매핑
//	- column, keyword 파라미터를 선택적으로 수신
//	- 둘 다 있을 경우만 검색으로 판정하여 조회 or 검색 수행
	@RequestMapping("/list")
	public String list(
		@RequestParam(required = false) String column,
		@RequestParam(required = false) String keyword
	) {
		boolean isSearch = column != null && keyword != null;
		
		List<PokemonDto> pokemonList;
		if(isSearch) {
			pokemonList = pokemonDao.selectList(column, keyword);
		}
		else {
			pokemonList = pokemonDao.selectList();
		}
		
		//아직 화면을 만들 수 없으니까 StringBuffer로 출력할 글자를 모아서 반환
		StringBuffer buffer = new StringBuffer();
		buffer.append("몬스터 수 : "+pokemonList.size());
		buffer.append("<br>");//HTML의 엔터
		for(PokemonDto pokemonDto : pokemonList) {
			buffer.append(pokemonDto);
			buffer.append("<br>");//HTML의 엔터
		}
		return buffer.toString();//buffer에 담긴 내용을 문자열로 변환해서 반환!
	}
	
//	상세 매핑
	@RequestMapping("/detail")
	public String detail(@RequestParam int pokemonNo) {
		PokemonDto pokemonDto = pokemonDao.selectOne(pokemonNo);
		
		if(pokemonDto != null) {//있으면
			return pokemonDto.toString();
		}
		else {//없으면
			return "존재하지 않는 몬스터 정보";
		}
	}
	
}

























