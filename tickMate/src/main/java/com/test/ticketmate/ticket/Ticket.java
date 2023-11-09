package com.test.ticketmate.ticket;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;


import lombok.Getter;
import lombok.Setter;
@Entity
@Setter
@Getter
public class Ticket {
	
	@Id
	private String ticketNum;

	private int showNum;

	private int amount;

	private int payment;

	private LocalDate showDate;

	private int seatNum;

	private String ticketStatus;

	private int perAmount;

}
