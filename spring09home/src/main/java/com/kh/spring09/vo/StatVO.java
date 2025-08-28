package com.kh.spring09.vo;

import lombok.Data;

//VO(Value Object)
// 테이블이 아닌 데이터를 내 입맛에 맞게 모아서 사용하고자 할떄 만드는 클래스
// 지금이 클래스는 group 조회 결과를 담기 위한 생성
@Data
public class StatVO {
private String title;
private double value;

}
