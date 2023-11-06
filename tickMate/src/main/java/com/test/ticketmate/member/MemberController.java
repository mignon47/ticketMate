package com.test.ticketmate.member;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class MemberController {
	
	private final MemberService memberService;
	
	@Autowired
    private MemberRepository memberRepository;
	
	@GetMapping("/login")
    public String login() {

    	return "member/login";
    }
	@PostMapping("/login")
	public String login(@RequestParam String memberid, @RequestParam String memberpass, HttpSession session, Model model) {
	    Optional<Member> member = memberRepository.findByMemberIdAndMemberPass(memberid, memberpass);
	    if (member.isPresent()) {
	        // 로그인 성공
	        session.setAttribute("user", member.get());
	        model.addAttribute("memberId", member.get().getMemberId()); // memberId를 모델에 추가
	        return "member/main"; // 로그인 성공 시 메인 페이지로 이동
	    } else {
	        // 로그인 실패
	        model.addAttribute("loginError", "아이디 또는 비밀번호가 올바르지 않습니다.");
	        return "login"; // 로그인 실패 시 로그인 페이지에 머무름
	    }
	}
	
	@GetMapping("/join_mate")
	public String join_mate(Model model) {
		model.addAttribute("member", new Member());
		System.out.println("기본 메이트 페이지");
		return "member/join_mate";
	}
	
	@PostMapping("/join_mate")
	public String join(@ModelAttribute Member member, @Validated Member memberForm, BindingResult result, Model model) {
		// 만약 바인딩 오류 발생 시 오류가 result에 담겨서 코드가 실행 됨
		System.out.println("메이트");
		
		/*
		 * if (result.hasErrors()) { return "members/join_mate"; }
		 */
        
        memberService.join(member);
        System.out.println("컨서비스 - 폼 다녀왔음");
        
        return "redirect:/";
        
	}	

	 
	 
}
