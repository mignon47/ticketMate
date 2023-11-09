package com.test.ticketmate.transfer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import groovyjarjarpicocli.CommandLine.Model;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@Controller
public class TransferController {
	
	//핀번호추가
	@GetMapping("/addfin")
	public String addfin (Model model) {
		return "transfer/addfin";
		
	}

}
