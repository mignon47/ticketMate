package com.test.ticketmate.reserve;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReserveController {

	@GetMapping("/reserve")
    public String reserveticket() {

    	return "reserve/reserve1";
    }
	
	@GetMapping("/reserveseat")
    public String reserveseat() {

    	return "reserve/reserveseat";
    }
}
