package com.test.ticketmate.perform;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.ticketmate.hall.Hall;
import com.test.ticketmate.hall.HallRepository;

@Controller
public class PerformController {

	
	
	@Autowired
    private HallRepository hallRepository;  // HallRepository 주입
	
	@Autowired
	private PerformService performService;

	@GetMapping("/perform_form")
    public String performForm(Model model) {
        model.addAttribute("perform", new Perform());
        model.addAttribute("halls", hallRepository.findAll());
        return "show/perform_form";
    }

	@PostMapping("/perform_form")
	public String registerPerform(@ModelAttribute("perform") Perform perform, BindingResult result) {
	    // 유효성 검사 및 저장 로직
	    if (result.hasErrors()) {
	        // 에러 처리
	    }

	    Hall selectedHall = perform.getHall();
	    
	    perform.setHall(selectedHall);
	    Date selectedPerformDate = perform.getPerformDate();
	    
	    perform.setPerformDate(selectedPerformDate);

	    performService.registerPerform(perform);
	    return "redirect:/"; // 이동할 경로를 원하는 경로로 수정
	}

}
