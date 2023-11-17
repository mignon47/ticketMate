package com.test.ticketmate.member;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "memberNum")
	private int memberNum;
	
	private String memberId;
	private String memberPass;
	private String memberPass2;
	private String memberName;
	private String memberBirth;
	private String memberEmail;
	private String memberPhone;
	private String memberAddress;
	private String memberAddressSub;
	private String memberPost;
	private String memberAccount;
	@Column(name = "memberJoindate", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
	private LocalDateTime memberJoindate;
	private String memberStatus;
	private String memberPointNum;
}
