package com.test.ticketmate.transfer;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class Transfer {
	
	//복합키 추후 설정예정
	@Id
	private String transNum; 
	
	
	private String ticketNum;
	private String senderId;
	
	private String receiverId;
	private String showNum;
	
	private LocalDate showDate;
	private String seatNum;
	private String transQuantity;
	private String transPayment;
	@Column(name = "transDate", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP" ,insertable = false, updatable = false)
	private LocalDate transDate;
	private String ttransContent;
	

}
