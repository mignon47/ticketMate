package com.test.ticketmate.hall;

import java.util.List;

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
	public String createHall(Hall hall, Model model) {
	    hallRepository.save(hall);

	    // 이제 저장한 엔티티에서 hall_num 값을 얻을 수 있습니다.
	    Long hallNum = hall.getHallNum();

	    // hall_num을 모델에 추가하고 area_create.html로 전달
	    model.addAttribute("hallNum", hallNum);

	    return "show/area_form";
	}

	
	@PostMapping("/area_create")
	public String createHall(@ModelAttribute Hall hall, @RequestParam List<String> areaNames,
	                         @RequestParam List<Integer> areaRows, @RequestParam List<Integer> areaColumns,
	                         @RequestParam List<Integer> areaPrices) {
	    // Hall 정보 저장
	    hallRepository.save(hall);

	    // Hall 정보에서 hallNum 가져오기
	    Long hallNum = hall.getHallNum();

	    // 구역 정보 저장
	    for (int i = 0; i < areaNames.size(); i++) {
	        Area area = new Area();
	        
	        // Hall 엔티티와의 관계를 설정
	        area.setHall(hall);
	        
	        area.setAreaName(areaNames.get(i));
	        area.setAreaRows(areaRows.get(i));
	        area.setAreaColumns(areaColumns.get(i));
	        area.setAreaPrice(areaPrices.get(i));

	        areaRepository.save(area);
	    }

	    return "redirect:/"; // 등록 후 목록 페이지로 이동
	}




}
