package com.test.ticketmate.seat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seatNum; // 고유 식별자

    private String seatRow;   // 좌석 행
    private int seatNumber; // 좌석 번호
    private boolean seatStatus; // 좌석 상태

    public Seat() {
    }
}
