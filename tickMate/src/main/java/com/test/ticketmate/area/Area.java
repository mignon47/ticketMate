package com.test.ticketmate.area;

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
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long areaNum;

    @ManyToOne
    @JoinColumn(name = "hallNum") // hall_num과의 관계를 매핑
    private Hall hall; // Hall 엔티티와의 관계

    private String areaName;
    private int areaRows;
    private int areaColumns;
    private double areaPrice;
}


