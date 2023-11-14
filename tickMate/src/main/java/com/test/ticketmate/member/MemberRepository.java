package com.test.ticketmate.member;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    Optional<Member> findByMemberIdAndMemberPass(String memberId, String memberPass);
    
    Optional<Member> findByMemberNum(int memberNum);
}