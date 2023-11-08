package com.test.ticketmate.area;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.test.ticketmate.hall.Hall;
import com.test.ticketmate.hall.HallRepository;

@Controller
public class AreaController {

	@Autowired
    private AreaRepository areaRepository;
	
	@Autowired
    private HallRepository hallRepository;

	 @PostMapping("/save_area")
	    public ResponseEntity<String> saveArea(@RequestBody Area area, HttpSession session) {
	        // 세션에서 hallNum을 읽어옴
	        Long hallNum = (Long) session.getAttribute("hallNum");
	        if (hallNum == null) {
	            return new ResponseEntity<>("HallNum이 세션에 없습니다.", HttpStatus.NOT_FOUND);
	        }

	        // Hall 엔티티를 가져옴
	        Hall hall = hallRepository.findById(hallNum).orElse(null);
	        if (hall == null) {
	            return new ResponseEntity<>("Hall을 찾을 수 없습니다.", HttpStatus.NOT_FOUND);
	        }

	        // Hall 엔티티와의 관계 설정
	        area.setHall(hall);

	        // 구역 정보를 DB에 저장
	        areaRepository.save(area);

	        return new ResponseEntity<>("구역 정보가 성공적으로 저장되었습니다.", HttpStatus.OK);
	    }
}
