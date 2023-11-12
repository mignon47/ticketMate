package com.test.ticketmate.order;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {

	@Autowired
    private OrderRepository orderRepository;
	
	@Transactional
	public void saveOrder(Orders orderInfo) {
		  orderRepository.save(orderInfo);
	}
}
