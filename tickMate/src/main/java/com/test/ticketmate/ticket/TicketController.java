package com.test.ticketmate.ticket;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.ticketmate.category.Category;
import com.test.ticketmate.category.CategoryService;


@Controller
public class TicketController {
	@Autowired
	TicketService ticketService;
	
	@Autowired
    CategoryService categoryService;

	@GetMapping("/ticket")
	public String createTicketForm(Model model) {
	    model.addAttribute("ticket", new Ticket());
	    model.addAttribute("categories", categoryService.getAllCategories());
	    return "ticket/create_ticket";
	}
	
	@PostMapping("/ticket")
	public String createTicket(@ModelAttribute Ticket ticket, Model model) {
	    Category category = categoryService.getCategoryById(ticket.getCategory().getCategoryId());
	    ticket.setCategory(category);
	    String createdTicketNum = ticketService.createTicket(ticket);
	    model.addAttribute("ticketNum", createdTicketNum);
	    return "result";
	}
}
