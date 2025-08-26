package com.kh.spring09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring09.dao.MemberDao;
import com.kh.spring09.dto.MemberDto;
import com.kh.spring09.error.TargetNotfoundException;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("")   // http://localhost:8080/member
	public String root() {
	    // /member/login 으로 리다이렉트
	    return "redirect:/member/login";
	}


	@GetMapping("/join")
	public String join() {
		return "/WEB-INF/views/member/join.jsp";
	}
	@PostMapping("/join")
	public String join(@ModelAttribute MemberDto memberDto) {
		memberDao.insert(memberDto);
		return "redirect:joinFinish";
	}
	@RequestMapping("/joinFinish")
	public String joinFinish() {
		return "/WEB-INF/views/member/joinFinish.jsp";
	}
	

	
//	로그인 매핑
	@GetMapping("/login")
	public String login() {
		return "/WEB-INF/views/member/login.jsp";
	}
	
	//HttpSesion은 서버에서 사용자마다 부여하는 공간의 모음이다 (= 단골수첩)
	//최소 30분동안은 유지를 시켜준다 (조절 가능)
	//스프링 컨트롤러에서 달라고 하면 주입해주기 때문에 자유롭게 사용 가능
	//- 데이터 추가(setAttribute), 데이터 제거(removeAttribute), 데이터 확인(getAttribute) 기능 사용
	@PostMapping("/login")
	public String login(@ModelAttribute MemberDto memberDto, HttpSession session) {
		//[1] 전달된 아이디로 데이터베이스의 회원정보를 탐색
		MemberDto findDto = memberDao.selectOne(memberDto.getMemberId());
		if(findDto == null) return "redirect:login?error";//로그인페이지(상대)
		
		//(주의) findDto에는 회원의 모든 정보가 있고 , memberDto에는 아이디랑 비밀번호 뿐이다
		
		//[2] 비밀번호 비교
		boolean isLogin = findDto.getMemberPw().equals(memberDto.getMemberPw());
		
		//[3] 성공 실패에 따라 처리
		if(isLogin)  {
			//로그인 성공 시 HttpSession에 이 사용자가 로그인을 성공했음을 데이터로 저장
			session.setAttribute("loginId", findDto.getMemberId());//아이디
			session.setAttribute("loginLevel", findDto.getMemberLevel());//등급
			
			return "redirect:/";//메인페이지
		}
		else {
//			return "redirect:/member/login?error";//로그인페이지(절대)
			return "redirect:login?error";//로그인페이지(상대)
		}
	}
	
//	로그아웃 매핑
//	- HttpSession에 저장해둔 데이터를 삭제하는 페이지 (loginId, loginLevel)
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginId");//loginId라는 이름으로 저장된 값을 지우세요
		session.removeAttribute("loginLevel");//loginLevel이라는 이름으로 저장된 값을 지우세요
		return "redirect:/";
	}
	
//	회원 상세페이지 매핑
	@RequestMapping("/detail")
	public String detail(Model model, @RequestParam String memberId) {
		MemberDto memberDto = memberDao.selectOne(memberId);
		if(memberDto == null) throw new TargetNotfoundException("존재하지 않는 회원");
		model.addAttribute("memberDto", memberDto);
		return "/WEB-INF/views/member/detail.jsp";
	}
	
//	마이페이지 매핑
	@RequestMapping("/mypage")
	public String mypage(Model model, HttpSession session) {
		//session에서 loginId를 추출하여 정보 조회한 뒤 화면으로 전달
		String loginId = (String) session.getAttribute("loginId");//loginId를 꺼내주세요!
		MemberDto memberDto = memberDao.selectOne(loginId);//로그인된 아이디로 정보 조회
		model.addAttribute("memberDto", memberDto);//화면에 전달
		return "/WEB-INF/views/member/mypage.jsp";
	}
	
	@GetMapping("/drop")
		public String drop() {
		return "/WEB-INF/views/member/drop.jsp";
	}
	
	@PostMapping("/drop")
	public String drop(HttpSession session,@RequestParam String memberPw) {
			String loginId=(String)session.getAttribute("loginId"); //세션의 아이디정보를 추출
			MemberDto memberDto=memberDao.selectOne(loginId);
			boolean isValid=memberDto.getMemberPw().equals(memberPw); //비밀번호 비교
			if(isValid) {
				memberDao.delete(loginId);
				
				session.removeAttribute("loginId");
				session.removeAttribute("loginLevel");
				return "redirect:goodbye";
				
			}
			else {
				//redirect는 Get으로밖에 보낼수없다
				return "redirect:drop?error";
				
			}
	}
	@RequestMapping("/goodbye")
	public String goodbye() {
		return "/WEB-INF/views/member/goodbye.jsp";
	}@GetMapping("/edit")
	public String edit(Model model, HttpSession session) {
		String loginId = (String) session.getAttribute("loginId");//다운캐스팅
		MemberDto memberDto = memberDao.selectOne(loginId);//정보조회
		model.addAttribute("memberDto", memberDto);//화면으로 전달
		return "/WEB-INF/views/member/edit.jsp";
	}
	@PostMapping("/edit")
	public String edit(@ModelAttribute MemberDto memberDto, HttpSession session) {
		String loginId = (String) session.getAttribute("loginId");//다운캐스팅
		MemberDto findDto = memberDao.selectOne(loginId);//정보조회
		boolean isValid = memberDto.getMemberPw().equals(findDto.getMemberPw());//비밀번호 검사
		if(!isValid) {//비밀번호 불일치
			return "redirect:edit?error";
		}
		
		//memberDto 사용 시 (아이디 추가)
		memberDto.setMemberId(loginId);//아이디를 추가 설정해야함
		memberDao.updateMember(memberDto);
		
		//findDto 사용 시 (변경항목을 교체) - 관리자랑 사용자를 통합해서 만들 경우 좋음
		//findDto.setMemberNickname(memberDto.getMemberNickname());
		//findDto.setMemberEmail(memberDto.getMemberEmail());
		//findDto.setMemberBirth(memberDto.getMemberBirth());
		//findDto.setMemberContact(memberDto.getMemberContact());
		//findDto.setMemberPost(memberDto.getMemberPost());
		//findDto.setMemberAddress1(memberDto.getMemberAddress1());
		//findDto.setMemberAddress2(memberDto.getMemberAddress2());
		//memberDao.updateMemberByAdmin(findDto);
		return "redirect:mypage";
	}
		
//		비밀번호 변경 매핑
		@GetMapping("/password")
		public String password() {
			return "/WEB-INF/views/member/password.jsp";
		}
		@PostMapping("/password")
		public String password(HttpSession session, 
				@RequestParam String currentPw, @RequestParam String changePw) {
			String loginId = (String) session.getAttribute("loginId");//로그인 아이디 확인
			MemberDto memberDto = memberDao.selectOne(loginId);//DB 테이블정보 조회
			boolean isValid = memberDto.getMemberPw().equals(currentPw);//현재 비밀번호 검사
			if(isValid == false) return "redirect:password?error";
			
			memberDao.updateMemberPw(loginId, changePw);
//			or
//			memberDto.setMemberPw(changePw);
//			memberDao.updateMemberPw(memberDto);
			
			return "redirect:mypage";
	}
}





