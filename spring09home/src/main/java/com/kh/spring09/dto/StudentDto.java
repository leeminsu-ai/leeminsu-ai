package com.kh.spring09.dto;

import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class StudentDto {
	private int studentNo;
	private String studentName;
	private int studentKor, studentEng, studentMat;
	private Timestamp studentReg;
	
	public int getTotal() {
		return studentKor + studentEng + studentMat;
	}
	public double getAverage() {
		return getTotal() / 3d;
	}	
}
