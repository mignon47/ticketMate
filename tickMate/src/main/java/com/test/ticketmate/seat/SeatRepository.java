package com.test.ticketmate.seat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    // 기타 필요한 쿼리 메서드를 선언할 수 있습니다.
}



