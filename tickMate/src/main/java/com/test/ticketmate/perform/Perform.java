package com.test.ticketmate.perform;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.test.ticketmate.hall.Hall;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Perform {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long performNum;
	
	private int reviewNum;
	private String performTitle;
	private String categoryTitle;
	private String companyName;
	
	
	@ManyToOne
    @JoinColumn(name = "hallNum") // hall_num과의 관계를 매핑
    private Hall hall; // Hall 엔티티와의 관계
	
	private String performPoster;
	private String performInfo;
	private Date performDate;
	private String performTime;
	
	public void setHall(Hall hall) {
        this.hall = hall;
    }
	
}
