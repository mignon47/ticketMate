package com.test.ticketmate.hall;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.ticketmate.area.Area;
import com.test.ticketmate.area.AreaRepository;

@Controller
public class HallController {
	
	@Autowired
    private HallRepository hallRepository;
	
	@Autowired
	private AreaRepository areaRepository;
	
	@GetMapping("/hall_form")
    public String hallForm() {
        return "show/hall_form";
    }
	
	@PostMapping("/hall_create")
	public String createHall(Hall hall, HttpSession session, Model model) {
	    // hall 엔티티를 저장하기 전에 hall_num을 세션에 저장합니다.
		hallRepository.save(hall);
	    Long hallNum = hall.getHallNum();
	    session.setAttribute("hallNum", hallNum);
	    
	    return "show/area_form";
	}

	 @PostMapping("/area_create")
	    public String createArea(@RequestParam List<String> areaName, @RequestParam List<Integer> areaRows,
	                             @RequestParam List<Integer> areaColumns, @RequestParam List<Integer> areaPrice,
	                             HttpSession session) {
	        // 세션에서 hallNum 읽기
	        Long hallNum = (Long) session.getAttribute("hallNum");
	        
	        // Hall 엔티티를 다시 생성하지 않고 이미 생성된 Hall 엔티티를 가져와서 사용합니다.
	        Hall hall = hallRepository.findById(hallNum).orElse(null);
	        if (hall == null) {
	            // Hall 엔티티를 찾을 수 없으면 오류 처리
	            // (이 부분에 대한 추가적인 오류 처리 로직이 필요할 수 있습니다.)
	            return "redirect:/error";
	        }
	        
	        // 구역 정보 저장
	        for (int i = 0; i < areaName.size(); i++) {
	            Area area = new Area();
	            
	            // Hall 엔티티와의 관계를 설정
	            area.setHall(hall);
	            
	            area.setAreaName(areaName.get(i));
	            area.setAreaRows(areaRows.get(i));
	            area.setAreaColumns(areaColumns.get(i));
	            area.setAreaPrice(areaPrice.get(i));
	            
	            areaRepository.save(area);
	        }
	        
	        return "redirect:/"; // 등록 후 목록 페이지로 이동
	    }


}
