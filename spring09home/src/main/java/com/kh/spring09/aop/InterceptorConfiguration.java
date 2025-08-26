package com.kh.spring09.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//application.properties에서 할 수 없는 프로그래밍 설정을 수행하는 파일
@Configuration//설정 파일로 등록
public class InterceptorConfiguration implements WebMvcConfigurer {//웹 기본 동작 설정을 위한 상속
	@Autowired
	private TestInterceptor testInterceptor;
	@Autowired
	private MemberLoginInterceptor memberLoginInterceptor;
	@Autowired
	private AdvancedMemberInterceptor advancedMemberInterceptor;
	@Autowired
	private AdminInterceptor adminInterceptor;
	
	//설정하고 싶은 메소드를 재정의
	@Override
	public void addInterceptors(InterceptorRegistry registry) {//인터셉터 등록메소드
		//registry.addInterceptor(인터셉터객체).addPathPatterns(적용시킬주소);
		
		//registry.addInterceptor(testInterceptor).addPathPatterns("/**");
		//registry.addInterceptor(testInterceptor).addPathPatterns("/member/join", "/member/login");
		
		//스프링에서는 주소 패턴을 위해 다음과 같은 기호를 제공
		// * 를 이용해서 지정한 대상과 동일한 엔드포인트 내의 모든 항목을 지정
		// ** 를 이용해서 지정한 대상과 하위 모든 항목을 지정
		registry.addInterceptor(memberLoginInterceptor)
					.addPathPatterns("/student/**", "/book/**", "/member/**")
					.excludePathPatterns(
						//"/member/join", "/member/joinFinish",
						"/member/join*",
						"/member/login",
						"/member/goodbye"
					).order(1);
		
//		우수회원용 인터셉터 등록
		registry.addInterceptor(advancedMemberInterceptor)
					.addPathPatterns("/book/**").order(2);
//		관리자 검사용 인터셉터 등록
		registry.addInterceptor(adminInterceptor)
					.addPathPatterns("/member/list").order(3);
	}
}





