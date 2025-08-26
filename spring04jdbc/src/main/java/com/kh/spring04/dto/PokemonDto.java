package com.kh.spring04.dto;

//등록 안함 (일회용 클래스이기 때문)
public class PokemonDto {
	private int pokemonNo;
	private String pokemonName;
	private String pokemonType;
	@Override
	public String toString() {
		return "PokemonDto [pokemonNo=" + pokemonNo + ", pokemonName=" + pokemonName + ", pokemonType=" + pokemonType
				+ "]";
	}
	public int getPokemonNo() {
		return pokemonNo;
	}
	public void setPokemonNo(int pokemonNo) {
		this.pokemonNo = pokemonNo;
	}
	public String getPokemonName() {
		return pokemonName;
	}
	public void setPokemonName(String pokemonName) {
		this.pokemonName = pokemonName;
	}
	public String getPokemonType() {
		return pokemonType;
	}
	public void setPokemonType(String pokemonType) {
		this.pokemonType = pokemonType;
	}
	public PokemonDto() {
		super();
	}
}