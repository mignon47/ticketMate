package com.test.ticketmate.member;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;
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
	
	@Transactional
	public Member findMemberByMemberNum(int memberNum) {
        return memberRepository.findById(memberNum).orElse(null);
    }
	
	@Transactional
	public void update(Member member) {
	    Optional<Member> existingMember = memberRepository.findById(member.getMemberNum());
	    if (existingMember.isPresent()) {
	        Member updateMember = existingMember.get();
	        updateMember.setMemberName(member.getMemberName());
	        updateMember.setMemberPhone(member.getMemberPhone());
	        updateMember.setMemberEmail(member.getMemberEmail());
	       
	        memberRepository.save(updateMember);

	        System.out.println("서비스");
	    } else {
	        // 기존 회원을 찾을 수 없는 경우 예외 처리
	        throw new EntityNotFoundException("해당 회원을 찾을 수 없습니다. ID: " + member.getMemberNum());
	    }
	}

}
