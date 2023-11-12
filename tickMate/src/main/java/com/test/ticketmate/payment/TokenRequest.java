package com.test.ticketmate.payment;

import lombok.Data;

@Data
public class TokenRequest {

	private String imp_key;
    private String imp_secret;
    private String access_token;
    
	public TokenRequest(String imp_key, String imp_secret, String access_token) {
		super();
		this.imp_key = imp_key;
		this.imp_secret = imp_secret;
		this.access_token = access_token;
	}

	public TokenRequest(String imp_key, String imp_secret) {
		this.imp_key = imp_key;
		this.imp_secret = imp_secret;
	}
	
    
}
