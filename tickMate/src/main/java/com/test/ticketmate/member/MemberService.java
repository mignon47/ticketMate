package com.test.ticketmate.member;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MemberService {
	
	private final MemberRepository memberRepository;

	@Transactional // 커밋
	public int join(Member member) {
		
		Member savedMember = memberRepository.save(member); // Member를 저장하고 반환합니다.
		System.out.println("서비스");
		
		int memberNum = savedMember.getMemberNum();
		
		return memberNum;
	}

}
