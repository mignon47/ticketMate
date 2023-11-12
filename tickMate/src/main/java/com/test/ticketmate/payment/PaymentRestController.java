package com.test.ticketmate.payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class PaymentRestController {
	
	@Autowired PaymentService paymentService;
    
    @PostMapping("/vbanks")
    public ResponseEntity<String> createVirtualBankAccount(
        @RequestBody BankAccount bankAccountRequest,
        @RequestHeader("Authorization") String access_token
    ) {
    	// System.out.println("createVBankAccount" + accessToken);
    	
    	// bankAccountRequest.setPg_api_key("ItEQKi3rY7uvDS8l");
    	
        String apiUrl = "https://api.iamport.kr/vbanks"; // 가상 계좌 생성 API 엔드포인트
        
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(apiUrl)
                .queryParam("pg_api_key", "ItEQKi3rY7uvDS8l");
        
        apiUrl = builder.toUriString();
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", access_token);

        HttpEntity<BankAccount> requestEntity = new HttpEntity<>(bankAccountRequest, headers);

        // 가상 은행 계좌 생성 요청
        ResponseEntity<String> response = new RestTemplate().exchange(
            apiUrl,
            HttpMethod.POST,
            requestEntity,
            String.class
        );

        return response;
    }

}
