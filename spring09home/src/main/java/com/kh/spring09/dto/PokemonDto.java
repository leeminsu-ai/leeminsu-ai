package com.kh.spring09.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

//등록 안함 (일회용 클래스이기 때문)
@Data @NoArgsConstructor
public class PokemonDto {
	private int pokemonNo;
	private String pokemonName;
	private String pokemonType;
}
