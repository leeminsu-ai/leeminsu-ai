package com.kh.spring04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/pokemon")//공용주소 설정
public class PokemonController {
	
	//스프링에 등록된 인스턴스를 주입하는 설정(DI, Dependency Injection)
	//= 한마디로 스프링에게 주세요~ 하면 준다
	@Autowired
	private JdbcTemplate jdbcTemplate;

	//목표 : pokemon/add라는 주소를 만들어서 포켓몬스터 등록 코드를 작성
	@RequestMapping("/add")
	public String add(@RequestParam String pokemonName, 
								@RequestParam String pokemonType) {
		String sql = "insert into pokemon("
							+ "pokemon_no, pokemon_name, pokemon_type"
						+ ") values(pokemon_seq.nextval, ?, ?)";
		Object[] params = {pokemonName, pokemonType};
		jdbcTemplate.update(sql, params);
		return "등록 완료";
	}
	
}




