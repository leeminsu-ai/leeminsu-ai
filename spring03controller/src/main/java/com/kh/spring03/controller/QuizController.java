package com.kh.spring03.controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
//@RequestMapping("/quiz")//공용주소

public class QuizController {

	@RequestMapping("/quiz01")     
	public int quiz01(@RequestParam(required=false,defaultValue="0")int cream, 
			@RequestParam(required=false,defaultValue="0")int nutella) {
	int creamTotal=cream*2500;
	int nutellaTotal=nutella*3500;
	
		int total=creamTotal+nutellaTotal;
		return total;
	}
	@RequestMapping("/quiz02")
	public int quiz02(@RequestParam(required=false) Integer  year) {
		int age=LocalDate.now().getYear()-year+1;
		if(age>=65||age<8) {
			return 0;
		}
		else if(age>=20||year==null) {
			return 1550;
		}
		else if(age>=14) {
			return 900;
		}
		else {
			return 550;    
		}
	}
}
