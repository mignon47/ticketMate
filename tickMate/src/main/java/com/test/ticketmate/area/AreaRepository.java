package com.test.ticketmate.area;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {
    // 추가적인 메소드가 필요하다면 여기에 정의
}