package com.test.ticketmate.hall;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.test.ticketmate.area.Area;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hallNum;
    private String hallLocation;
    private String hallName;
    private String hallSeatpic;

    @OneToMany(mappedBy = "hall", cascade = CascadeType.ALL)
    private List<Area> areas;
}

