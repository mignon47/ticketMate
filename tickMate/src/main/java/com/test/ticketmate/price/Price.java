package com.test.ticketmate.price;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.test.ticketmate.area.Area;
import com.test.ticketmate.hall.Hall;
import com.test.ticketmate.perform.Perform;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Price {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long priceNum;
	
	
	@ManyToOne
    @JoinColumn(name = "areaNum") 
    private Area area; 
	
	private int price;

}
