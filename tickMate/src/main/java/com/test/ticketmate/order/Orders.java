package com.test.ticketmate.order;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.test.ticketmate.perform.Perform;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderNum; //주문번호
	
	private int memberNum;
	
	@ManyToOne
    @JoinColumn(name = "performNum")
	private Perform performNum;
	
	private String payMethod;
    private String memberName;
    private String memberEmail;
    private String memberPhone;
    private String memberAddress;
    private String memberPost;
    private String vbankDue;
	private int quantity;
	private int price;
	private LocalDateTime orderDate;
	
	public enum OrderStatus {// 완료, 대기, 취소
	  	COMPLETED("COMPLETED"),
	    PENDING("PENDING"),
	    CANCELLED("CANCELLED");

	    private final String value;

	    OrderStatus(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "order_status", length = 20)
	private OrderStatus orderStatus = OrderStatus.PENDING;
	
}


