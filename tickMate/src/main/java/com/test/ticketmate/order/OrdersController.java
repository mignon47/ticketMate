package com.test.ticketmate.order;

import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.ticketmate.member.Member;
import com.test.ticketmate.member.MemberService;

@Controller
public class OrdersController {
	
	@Autowired
	private OrdersService orderService;
	
	@Autowired
	private MemberService memberService;
    
    @PostMapping("/paySuccess")
    @ResponseBody
    public ResponseEntity<String> handleRequest(@RequestBody Orders order,HttpSession session) {
        try {
        	
        	System.out.println("ordersController");
        	
        	Member member = (Member) session.getAttribute("user");
        	int memberNum = member.getMemberNum();
        	
        	System.out.println(memberNum);
        	System.out.println(order);

        	Orders completedOrder = Orders.builder()
        			.orderDate(LocalDateTime.now())
        			.orderNum(order.getOrderNum())
        			.orderStatus(Orders.OrderStatus.COMPLETED)
        			.payMethod(order.getPayMethod())
        			.memberNum(member)
        			.memberName(order.getMemberName())
        			.memberEmail(order.getMemberEmail())
        			.memberPhone(order.getMemberPhone())
        			.memberAddress(order.getMemberAddress())
        			.memberPost(order.getMemberPost())
        			.quantity(order.getQuantity())
        			.vbankDue(order.getVbankDue())
        			.price(order.getPrice())
        			//.performNum(order.getPerformNum())
        			.build();
        	
        	orderService.saveOrder(completedOrder);
            return new ResponseEntity<>("주문이 성공적으로 처리되었습니다.", HttpStatus.OK);
        } catch (Exception e) {
        	e.printStackTrace(); // 예외 세부 정보 기록
            return new ResponseEntity<>("주문 처리 중 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 주문 - 결제 완료
    @GetMapping("/orderSuccess")
    public String paySuccess() {
    	System.out.println("orderSuccess 까지 왔는지");
    	
        return "order/paySuccess"; 
    }

}
