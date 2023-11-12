package com.test.ticketmate.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrdersController {
	
	@Autowired
	private OrdersService orderService;
    
    @PostMapping("/paySuccess")
    @ResponseBody
    public ResponseEntity<String> handleRequest(@ModelAttribute Orders order) {
        try {
        	order.setOrderStatus(Orders.OrderStatus.COMPLETED); 
        	orderService.saveOrder(order);
            return new ResponseEntity<>("주문이 성공적으로 처리되었습니다.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("주문 처리 중 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 주문 - 결제 완료
    @GetMapping("/paySuccess")
    public String paySuccess() {
    	System.out.println("paySuccess 까지 왔는지");
    	
        return "order/paySuccess"; 
    }

}
