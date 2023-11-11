package com.test.ticketmate.ticket;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TicketService {
	
    @Autowired
    TicketRepository ticketRepository;

    public String createTicket(Ticket ticket) {
        String categoryId = ticket.getCategory().getCategoryId();
        String randomNumber1 = String.valueOf((int)(Math.random() * 10000)); // 4자리 랜덤 숫자 생성
        String randomNumber2 = String.valueOf((int)(Math.random() * 10000)); // 4자리 랜덤 숫자 생성
        String ticketNum = categoryId + "-" + randomNumber1 + "-" + randomNumber2;
        ticket.setTicketNum(ticketNum);
        ticketRepository.save(ticket);
        return ticketNum;
    }
}
