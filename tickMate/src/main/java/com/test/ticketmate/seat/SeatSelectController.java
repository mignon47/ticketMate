package com.test.ticketmate.seat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SeatSelectController {

	
    @GetMapping("/seat-selection")
    public String showSeatSelectionPage() {

    	return "seat/seat";
    }
}

