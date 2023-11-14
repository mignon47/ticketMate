package com.test.ticketmate.perform;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.ManyToOne;

import com.test.ticketmate.hall.Hall;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
	
	@Column(columnDefinition = "DATETIME")
	private LocalDateTime performDate;

	private String performTime;
	
	public void setHall(Hall hall) {
        this.hall = hall;
    }
	
}
