package com.kh.spring04.dao;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring04.dto.PokemonDto;
import com.kh.spring04.mapper.PokemonMapper;

@Repository//파일이나 DB등 영속성 개체를 제어하는 도구
public class PokemonDao {
	//등록된 인스턴스 중에서 필요한 것들을 "주세요~"라고 한다(의존성 주입)
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private PokemonMapper pokemonMapper;
	
	public void insert(PokemonDto pokemonDto) {
		String sql = "insert into pokemon("
							+ "pokemon_no, pokemon_name, pokemon_type"
						+ ") values(pokemon_seq.nextval, ?, ?)";
		Object[] params = {
				pokemonDto.getPokemonName(), 
				pokemonDto.getPokemonType()
		};
		jdbcTemplate.update(sql, params);
	}
	
	public boolean update(PokemonDto pokemonDto) {
		String sql = "update pokemon "
						+ "set pokemon_name=?, pokemon_type=? "
						+ "where pokemon_no=?";
		Object[] params = {
			pokemonDto.getPokemonName(), pokemonDto.getPokemonType(),
			pokemonDto.getPokemonNo()
		};
		return jdbcTemplate.update(sql, params) > 0;
	}
	
	public boolean delete(int pokemonNo) {
		String sql = "delete pokemon where pokemon_no=?";
		Object[] params = {pokemonNo};
		return jdbcTemplate.update(sql, params) > 0;
	}
	
	public List<PokemonDto> selectList() {
		String sql = "select * from pokemon order by pokemon_no asc";
		return jdbcTemplate.query(sql, pokemonMapper);
	}
	public List<PokemonDto> selectList(String column, String keyword) {
		Set<String> allowList = Set.of("pokemon_name", "pokemon_type");
		if(!allowList.contains(column)) return List.of();
		
		String sql = "select * from pokemon "
						+ "where instr(#1, ?) > 0 "
						+ "order by #1 asc, pokemon_no asc";
		sql = sql.replace("#1", column);
		Object[] params = {keyword};
		return jdbcTemplate.query(sql, pokemonMapper, params);
	}
	
	public PokemonDto selectOne(int pokemonNo) {
		String sql = "select * from pokemon where pokemon_no = ?";
		Object[] params = {pokemonNo};
		List<PokemonDto> list = jdbcTemplate.query(sql, pokemonMapper, params);
		return list.isEmpty() ? null : list.get(0);
	}

	
	}












