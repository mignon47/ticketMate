package com.test.ticketmate.ticket;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.test.ticketmate.category.Category;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class Ticket {
	@Id
	private String ticketNum;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId")
    private Category category;

	private String showNum;

	private String amount;

	private String payment;

	private LocalDateTime showDate;

	private String seatNum;

	private String ticketStatus;

	private String perAmount;

}
