package com.kh.spring09.dto;

import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@Setter @Getter @EqualsAndHashCode
@Data
@NoArgsConstructor
@ToString(exclude = {"memberPw"})//toString()에서 비밀번호 출력 제외
public class MemberDto {
	private String memberId;
	private String memberPw;
	private String memberNickname;
	private String memberBirth;
	private String memberContact;
	private String memberEmail;
	private String memberLevel;
	private int memberPoint;
	private String memberPost, memberAddress1, memberAddress2;
	private Timestamp memberJoin, memberLogin, memberChange;
	
	}

