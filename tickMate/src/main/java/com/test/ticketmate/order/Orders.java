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

import com.test.ticketmate.member.Member;
import com.test.ticketmate.perform.Perform;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
	
	@Id
	@Column(name = "orderNum")
	private Long orderNum; //주문번호
	
	// 주문번호 직접 입력
	 public void setOrderNum(Long orderNum) {
	        this.orderNum = orderNum;
    }

	
	@ManyToOne
	@JoinColumn(name = "memberNum")
	private Member memberNum;

	// json 넘어오면서 문자로 인식해서 변환해줌
	public void setMemberNum(String memberNum) {
        this.memberNum = new Member();
        this.memberNum.setMemberNum(Integer.parseInt(memberNum));
    }
	
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
	private Integer quantity;
	private Integer price;
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


