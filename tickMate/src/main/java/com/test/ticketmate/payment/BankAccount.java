package com.test.ticketmate.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {
	
	 private String vbank_code;
     private String userName;
     private String merchant_uid;
     private int amount;
     private int vbank_due;
     private String pg_api_key;

}
